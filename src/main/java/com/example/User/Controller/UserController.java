package com.example.User.Controller;

import com.example.User.Entity.User;
import com.example.User.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
@CrossOrigin
public class UserController {

    @Autowired
private UserService userService;

    @PostMapping("/addUser")
    public String addUser(@RequestBody User user){
        userService.saveUser(user);
        return "new user added";
    }

//    @PostMapping("/getUserDetails{userId}")
//    public String getUserById(@PathVariable Integer userId){
//        return  userService.getUserById(userId);;
//    }

}
