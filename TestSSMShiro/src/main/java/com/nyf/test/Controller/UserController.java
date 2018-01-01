package com.nyf.test.Controller;

import com.nyf.test.mapper.UserMapper;
import com.nyf.test.model.LoginUser;
import com.nyf.test.model.User;
import com.nyf.test.service.UserService;
import com.nyf.test.utils.JWTUtil;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin
public class UserController {
    @Autowired
    private UserService userService;

    @Autowired
    private UserMapper userMapper;

    @RequestMapping(value = "user/add")
    public int addUser(User user) {
        return userService.addUser(user);
    }

    @GetMapping(value = "user/all")
    public Map<String, Object> findAllUser() {
        Map<String, Object> resultMap = new LinkedHashMap<String, Object>();
        resultMap.put("status", 200);
        resultMap.put("message", "成功");
        resultMap.put("data", userService.findAllUser());
        return resultMap;
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public Map<String, Object> submitLogin(@RequestBody LoginUser loginUser) {
        Map<String, Object> resultMap = new LinkedHashMap<String, Object>();

        System.out.println(loginUser.getUserName() + ":" + loginUser.getPassword());

        User user = userMapper.selectByUsername(loginUser.getUserName());
        if (user != null) {
            if (user.getPassword().equals(loginUser.getPassword())) {
                resultMap.put("status", 200);
                resultMap.put("message", "登录成功");
                resultMap.put("token", JWTUtil.sign(loginUser.getUserName(), loginUser.getPassword()));
            } else {
                resultMap.put("status", 500);
                resultMap.put("message", "登录失败");
            }
        }

        return resultMap;
    }
}


