package wuhan.vp.userservice.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import wuhan.vp.userservice.model.HttpResp;
import wuhan.vp.userservice.model.User;
import wuhan.vp.userservice.service.UserService;
import wuhan.vp.userservice.util.JwtUtil;

@RestController
@Slf4j
public class UserController {

    @Value("${server.port}")
    String port;

    @Autowired
    UserService userService;

    @GetMapping("/getUserByUsername")
    User getUserByUsername(String username){
        log.info(username);

        return userService.getUserByUsername(username);
    }

    @PostMapping("/userLogin")
    Object userLogin(@RequestBody User user){
        log.info(port);
        User u=userService.userLogin(user);

        return u==null? HttpResp.fail():
                HttpResp.success(JwtUtil.sign(u.getUserName(),u.getPassword()));
    }




}
