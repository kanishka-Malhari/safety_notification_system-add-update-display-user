package com.example.User.Controller;

import com.example.User.Entity.User;
import com.example.User.Service.UserService;
import com.example.User.dto.UserRequest;
import com.example.User.dto.UserResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
@CrossOrigin
public class UserController {

    @Autowired
private UserService userService;

    @PostMapping("/addUser")
    public Integer addUser(@RequestBody UserRequest user){
        return  userService.registerUser(user);
    }

    @GetMapping("/getUserDetails/{userId}")
    public UserResponse getUserById(@PathVariable Integer userId){
        return  userService.getUserById(userId);
    }

    @PutMapping("/updateUserDetails/{userId}")
    public UserResponse updateUserDetails(@PathVariable Integer userId,@RequestBody UserRequest userRequest){
        return  userService.updateUserDetails(userId,userRequest);
    }

//    @PutMapping("/updateUserDetails/{userId}")
//    public UserResponse updateUserDetails(@PathVariable String userId, @RequestBody UserRequest userRequest) {
//        Integer parsedUserId;
//        try {
//            parsedUserId = Integer.parseInt(userId);
//        } catch (NumberFormatException e) {
//            // Handle the conversion error
//            // You can log an error message or return an appropriate response
//            // For example:
//            throw new IllegalArgumentException("Invalid userId format");
//        }
//
//        // Continue with the rest of the code using the parsedUserId
//
//        return userService.updateUserDetails(parsedUserId, userRequest);
//    }



}
