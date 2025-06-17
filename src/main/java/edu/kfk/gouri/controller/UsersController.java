package edu.kfk.gouri.controller;


import edu.kfk.gouri.model.UserRequest;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
@CrossOrigin("*")
@AllArgsConstructor
public class UsersController {

    @PostMapping("/createUser")
    public ResponseEntity<?> createUser(@Validated @RequestBody UserRequest users){
        return ResponseEntity.ok(users);


    }

}
