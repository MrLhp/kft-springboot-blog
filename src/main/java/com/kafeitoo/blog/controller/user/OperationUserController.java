package com.kafeitoo.blog.controller.user;

import com.google.gson.Gson;
import com.kafeitoo.blog.model.authentication.BaseUser;
import com.kafeitoo.blog.model.authentication.OperationUser;
import com.kafeitoo.blog.repository.user.BaseUserRepository;
import com.kafeitoo.blog.service.user.OperationUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/users")
public class OperationUserController {
    @Autowired
    OperationUserService operationUserService;
    @Autowired
    BaseUserRepository baseUserRepository;

    @RequestMapping(value = "/createoptuser", method = RequestMethod.GET)
    public String createUserForm(ModelMap map) {
        map.addAttribute("user", new OperationUser());
        return "/system/user/createOptUser";
    }

    @RequestMapping(value = "/createoptuser", method = RequestMethod.POST)
    public String createUser(@ModelAttribute OperationUser user) {
        System.out.println(new Gson().toJson(user, OperationUser.class));
        OperationUser operationUser = operationUserService.create(user);
        System.out.println(new Gson().toJson(operationUser, OperationUser.class));
        return "/home";
    }

    @ResponseBody
    @RequestMapping(value = "/find", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public String getUser(@RequestParam String username) {
        BaseUser operationUser = baseUserRepository.findFirstByUserName("admin");

        String json = new Gson().toJson(operationUser, BaseUser.class);

        return json;
    }
}
