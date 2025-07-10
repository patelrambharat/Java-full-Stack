package com.patelSons.learningProject.Controller;

import com.patelSons.learningProject.DTO.PaymentRequest;
import com.patelSons.learningProject.DTO.PaymentResponse;
import com.patelSons.learningProject.DTO.UserRequest;
import com.patelSons.learningProject.DTO.UserResponse;
import com.patelSons.learningProject.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/users")
public class UserController {
   @Autowired
    UserService userService;
    @GetMapping("/{id}")
    public ResponseEntity<UserResponse> getUserDetailsById(@PathVariable String id){
       //map incoming data to internal request DTO
       UserRequest internalRequestObj =  new UserRequest();
       internalRequestObj.setId(id);

       //pass this internalRequestObj to further layer for processing

       UserResponse userResponse = userService.getUserDetailsById(internalRequestObj);

       //return the requst DTO
       return ResponseEntity.ok(userResponse);
   }
}
