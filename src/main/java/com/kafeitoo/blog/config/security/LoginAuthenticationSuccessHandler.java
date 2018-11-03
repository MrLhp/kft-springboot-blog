package com.kafeitoo.blog.config.security;

import cn.hutool.json.JSONUtil;
import com.kafeitoo.blog.bean.UserBean;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.SavedRequestAwareAuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;

@Slf4j
@Component
public class LoginAuthenticationSuccessHandler extends SavedRequestAwareAuthenticationSuccessHandler {

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws ServletException, IOException {
        Object principal = authentication.getPrincipal();

        String username;
        if (principal instanceof UserBean) {
            username = ((UserDetails) principal).getUsername();
        } else {
            username = principal.toString();
        }

        log.info("当前登录用户【 {} 】【 {} 】，登录时间【 {} 】", ((UserBean) principal).getNickname(), username, LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));
        //将 authention 信息打包成json格式返回
        //todo:添加实体类，添加登录成功跳转页面
        response.setContentType("application/json;charset=UTF-8");
        Map<String, Object> map = new HashMap<>(1);
        map.put("list", authentication);
        response.getWriter().write(JSONUtil.toJsonStr(map));

        super.getRedirectStrategy().sendRedirect(request, response, "/home");
    }
}
