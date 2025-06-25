package edu.kfk.gouri.controller;

import edu.kfk.gouri.model.Auditable;
import edu.kfk.gouri.model.UserRequest;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@Slf4j
@RestController
@RequestMapping("/admin/")
@CrossOrigin
@AllArgsConstructor
public class AdminController {


    @GetMapping(value = "/getAllUsers", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> getAllUsers(){
        log.info("getAllUsers");
        return ResponseEntity.ok().body(new UserRequest("65t3y2er6refydj3edytud7263trdfgyudt627tdyu-3dwudytgd-wddqwedw","dilip","demo@gmail.com", "1234567890", "IT", new Auditable()));
    }
}
