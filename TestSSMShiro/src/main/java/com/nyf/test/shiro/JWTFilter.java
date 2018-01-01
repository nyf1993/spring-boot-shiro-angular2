package com.nyf.test.shiro;

import com.nyf.test.utils.CORSUtil;
import org.apache.shiro.web.filter.authc.BasicHttpAuthenticationFilter;
import org.apache.shiro.web.util.WebUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class JWTFilter extends BasicHttpAuthenticationFilter {

    private Logger logger = LoggerFactory.getLogger(JWTFilter.class);

    @Override
    protected boolean onAccessDenied(ServletRequest request, ServletResponse response) throws Exception {
        HttpServletRequest httpServletRequest = (HttpServletRequest) request;
        HttpServletResponse res = WebUtils.toHttp(response);
        if (httpServletRequest.getMethod().equals(HttpMethod.OPTIONS.toString())) {
            CORSUtil.setCORSHeader(res);
            return true;
        }
        // 获取Authorization字段
        String authentication = httpServletRequest.getHeader("Authentication");
        logger.info("---------------jwt=" + authentication + "------------------");
        if (authentication != null) {
            try {
                JWTToken token = new JWTToken(authentication);
                // 提交给realm进行登入，如果错误他会抛出异常并被捕获
                getSubject(request, response).login(token);
                return true;
            } catch (Exception e) {
                response401(request, response);
                return false;
            }
        } else {
            response401(request, response);
            return false;
        }
    }

    /**
     * 将请求返回到 /401
     */
    private void response401(ServletRequest req, ServletResponse resp) throws Exception {
        HttpServletResponse httpServletResponse = (HttpServletResponse) resp;
//        httpServletResponse.sendRedirect("/login");
        System.out.println("无权限请求");
    }

}
