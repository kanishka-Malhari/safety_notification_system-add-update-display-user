package com.example.User.Service;

import com.example.User.Entity.User;
//import com.example.User.Repository.UserRepo;
import com.example.User.Repository.UserRepository;
import com.example.User.dto.UserRequest;
import com.example.User.dto.UserResponse;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ModelMapper modelMapper;



    @Override
    public Integer registerUser(UserRequest user) {
        return userRepository.save(convertToUserEntity(user)).getId();
    }

    @Override
    public UserResponse getUserById(Integer userId) {
        return convertToUserResponse(userRepository.findById(userId).get());
    }

    @Override
    public UserResponse updateUserDetails(Integer userId, UserRequest userRequest) {
        User entity =userRepository.saveAndFlush(updateUserEntity(userRepository.findById(userId).get(), userRequest));
        return convertToUserResponse(entity);
    }

    private User updateUserEntity(User user, UserRequest userRequest) {
        user.setCity(userRequest.getCity());
        user.setHeight(userRequest.getHeight());
        user.setWeight(userRequest.getWeight());
        user.setContact(userRequest.getContact());
        user.setGender(userRequest.getGender());
        user.setFirstName(userRequest.getFirstName());
        user.setLastName(userRequest.getLastName());
        user.setState(userRequest.getState());
        user.setPostcode(userRequest.getPostcode());
        user.setProvince(userRequest.getProvince());
       return  user;
    }

    private User convertToUserEntity(UserRequest userRequest) {
        User userEntity = null;
        userEntity = modelMapper.map(userRequest, User.class);


        return userEntity;

    }

    private UserResponse convertToUserResponse(User userEntity) {
        UserResponse dto = null;
        dto = modelMapper.map(userEntity, UserResponse.class);

        return dto;
    }
}
