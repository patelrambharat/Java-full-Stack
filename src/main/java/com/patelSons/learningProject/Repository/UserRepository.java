package com.patelSons.learningProject.Repository;

import com.patelSons.learningProject.DTO.UserRequest;
import com.patelSons.learningProject.Entity.User;
import org.springframework.stereotype.Repository;

@Repository
public class UserRepository {


    public User getUserById(UserRequest userRequest) {

        User user = executeQuery(userRequest);
        return user;
    }
    private User executeQuery(UserRequest userRequest){
        //connect with DB and fetch the data
        User user = new User();
        user.setUserid(Integer.parseInt(userRequest.getId()));
        user.setUsername(userRequest.getName());
        user.setPassword(userRequest.getPassword());
        return user;
    }
}
