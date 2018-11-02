package com.kafeitoo.blog.config.security;

import cn.hutool.json.JSONUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationFailureHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@Component
@Slf4j
public class LoginAuthenticationFailHandler extends SimpleUrlAuthenticationFailureHandler {
    @Override
    public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response, AuthenticationException exception) throws IOException, ServletException {
        this.log.error("登录失败");

        String msg = "登录失败";
        //处理登录失败信息
        if ("User account is locked".equals(exception.getMessage())) {
            msg = "登录账号已被禁用";
        }
        if("Bad credentials".equals(exception.getMessage())){
            msg = "登录账号或密码错误";
        }

        if("User account has expired".equals(exception.getMessage())){
            msg = "登录账号已过期";
        }

        //将 登录失败 信息打包成json格式返回
        response.setContentType("application/json;charset=UTF-8");
        //todo:map 临时使用。实际上需要一个通用bean
        Map<String, String> map = new HashMap<>();
        map.put("msg", msg);
        response.getWriter().write(JSONUtil.toJsonStr(map));
    }
}
