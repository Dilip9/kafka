package edu.kfk.gouri.controller;

import edu.kfk.gouri.model.GuestUserRequest;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
@AllArgsConstructor
@RequestMapping("/common/")
@RestController
@CrossOrigin("*")
public class CommonController {

    @GetMapping(value = "/guestUserData", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> getGuestUserData(){
        return ResponseEntity.ok("Guest User Data");
    }

    @PostMapping(value = "/createGuestUser", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> createGuestUser(@Valid @RequestBody GuestUserRequest guestUserRequest) {
        log.info("Creating guest user with data: {}", guestUserRequest);
        // Logic to create a guest user
        return ResponseEntity.ok("Guest user created successfully");

    }



}
