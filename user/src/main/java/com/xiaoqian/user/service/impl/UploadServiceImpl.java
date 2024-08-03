package com.xiaoqian.user.service.impl;

import com.xiaoqian.common.constants.ImageBedConstants;
import com.xiaoqian.common.domain.ResponseResult;
import com.xiaoqian.common.enums.HttpCodeEnum;
import com.xiaoqian.user.service.UploadService;
import lombok.extern.slf4j.Slf4j;
import okhttp3.*;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Base64;

@Service
@Slf4j
public class UploadServiceImpl implements UploadService {
    /**
     * 上传用户头像
     */
    @Override
    public ResponseResult<String> uploadAvatar(MultipartFile imgFile) {
        // 1. github请求 url
        String url = ImageBedConstants.BASE_URL + imgFile.getOriginalFilename();
        // 2. 将图片进行 Base64编码
        String base64Image;
        try {
            base64Image = Base64.getEncoder().encodeToString(imgFile.getBytes());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        // 3. 封装 JSON数据
        JSONObject json = new JSONObject();
        try {
            json.put("message", "upload image");
            json.put("content", base64Image);
            json.put("branch", ImageBedConstants.BRANCH);
        } catch (JSONException e) {
            throw new RuntimeException(e);
        }
        // 4. 构建消息体
        RequestBody body = RequestBody.create(MediaType.parse("application/json"), json.toString());
        // 5. 创建 http请求
        Request request = new Request.Builder()
                .url(url)
                .header("Authorization", "token " + ImageBedConstants.ACCESS_TOKEN)
                .put(body)
                .build();
        // 6. 发送 http请求
        OkHttpClient httpClient = new OkHttpClient();
        try (Response response = httpClient.newCall(request).execute()) {
            assert response.body() != null;
            if (response.isSuccessful()) {
                log.debug("图片上传成功");
                return ResponseResult.okResult(obtainDownloadUrl(response.body().string()));
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return ResponseResult.errorResult(HttpCodeEnum.UPLOAD_FILE_FAILED);
    }

    /**
     * 获取到 github响应中的图片地址
     */
    private String obtainDownloadUrl(String body) {
        try {
            JSONObject jsonObject = new JSONObject(body);
            return jsonObject.getJSONObject("content").getString("download_url");
        } catch (JSONException e) {
            throw new RuntimeException(e);
        }
    }
}
