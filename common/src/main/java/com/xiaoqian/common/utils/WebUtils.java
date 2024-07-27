package com.xiaoqian.common.utils;


import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class WebUtils {
    /**
     * 将字符串渲染到客户端
     */
    public static void renderString(HttpServletResponse response, String content) {
        try {
            response.setContentType("application/json");
            response.setCharacterEncoding("utf-8");
            response.setStatus(200);
            response.getWriter().print(content);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
