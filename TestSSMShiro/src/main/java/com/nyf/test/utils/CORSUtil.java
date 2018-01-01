package com.nyf.test.utils;

import javax.servlet.http.HttpServletResponse;


public class CORSUtil {
    public static final String ALLOW_ORIGIN = "Access-Control-Allow-Origin";
    public static final String ALLOW_METHOD = "Access-Control-Allow-Method";
    public static final String ALLOW_HEADERS = "Access-Control-Allow-Headers";
    public static final String ALLOW_CREDENTIALS = "Access-Control-Allow-Credentials";
    public static final String MAX_AGE = "Access-Control-Max-Age";
    public static final String EXPOSE_HEADER = "Access-Control-Expose-Headers";

    public static void setCORSHeader(HttpServletResponse response) {
        response.setHeader(CORSUtil.ALLOW_ORIGIN, "*");
        response.setHeader(CORSUtil.ALLOW_METHOD, "POST, GET");
        response.setHeader(CORSUtil.ALLOW_HEADERS, "Authentication, Content-Type, responseType, CaptchaKey");
        response.setHeader(CORSUtil.ALLOW_CREDENTIALS, "true");
        response.setHeader(CORSUtil.MAX_AGE, "1728000");
    }

}
