package com.patelSons.learningProject.Service;

import com.patelSons.learningProject.DTO.UserRequest;
import com.patelSons.learningProject.DTO.UserResponse;
import com.patelSons.learningProject.Entity.User;
import com.patelSons.learningProject.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    UserRepository userRepository;

    public UserResponse getUserDetailsById(UserRequest userRequest){

        User user = userRepository.getUserById(userRequest);

        //map it to response objecct

        UserResponse userResponse = mapModelToResponseDTo(user);
        return userResponse;
    }
    private UserResponse mapModelToResponseDTo(User user){
        UserResponse userResponse = new UserResponse();
        userResponse.setUserid(user.getUserid());
        userResponse.getUsername(user.getUsername());
        userResponse.getPassword(user.getPassword());
        return userResponse;
    }

}
