package com.example.User.Service;

import com.example.User.Entity.User;
import com.example.User.dto.UserRequest;
import com.example.User.dto.UserResponse;
import org.springframework.stereotype.Service;


public interface UserService {
  

    Integer registerUser(UserRequest user);

    UserResponse getUserById(Integer userId);

    UserResponse updateUserDetails(Integer userId, UserRequest userRequest);
}
