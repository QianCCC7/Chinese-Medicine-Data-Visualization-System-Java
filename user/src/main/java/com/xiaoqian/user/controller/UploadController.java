package com.xiaoqian.user.controller;

import com.xiaoqian.common.domain.ResponseResult;
import com.xiaoqian.user.service.UploadService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequiredArgsConstructor
@Api("文件上传相关接口")
public class UploadController {
    private final UploadService uploadService;

    @ApiOperation("上传用户头像")
    @PostMapping("/uploadAvatar")
    public ResponseResult<String> uploadAvatar(@RequestParam(value = "imgFile") MultipartFile imgFile) {
        return uploadService.uploadAvatar(imgFile);
    }
}
