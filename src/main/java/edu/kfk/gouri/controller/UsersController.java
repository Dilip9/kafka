package edu.kfk.gouri.controller;


import edu.kfk.gouri.model.UserRequest;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
@CrossOrigin("*")
@AllArgsConstructor
@Slf4j
public class UsersController {

    @PostMapping("/createUser")
    public ResponseEntity<?> createUser(@Validated @RequestBody UserRequest users){
        log.info("Create user");
        log.info("User details: {}", users);
        return ResponseEntity.ok(users);


    }

}
