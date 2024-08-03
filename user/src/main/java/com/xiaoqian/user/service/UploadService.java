package com.xiaoqian.user.service;

import com.xiaoqian.common.domain.ResponseResult;
import org.springframework.web.multipart.MultipartFile;

public interface UploadService {
    /**
     * 上传用户头像
     */
    ResponseResult<String> uploadAvatar(MultipartFile imgFile);
}
