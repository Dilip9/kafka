package edu.kfk.gouri.controller;

import edu.kfk.gouri.common.SmtpEmail;
import edu.kfk.gouri.model.Auditable;
import edu.kfk.gouri.model.GuestUserRequest;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
@AllArgsConstructor
@RequestMapping("/common/")
@RestController
@CrossOrigin("*")
public class CommonController {

    @Autowired
    SmtpEmail smtpEmail;

    @GetMapping(value = "/guestUsers", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> getGuestUserData(){


        return ResponseEntity.ok(new GuestUserRequest("34rqde23rd-2rd23fd23-f2rdf23-rd32r", "John.Doe@gmail.com", "2e32e2dedwd", "127.0.0.1","US", new Auditable()));
    }

    @PostMapping(value = "/createGuest", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> createGuestUser(@Valid @RequestBody GuestUserRequest guestUserRequest) {
        log.info("Creating guest user with data: {}", guestUserRequest);
        // Logic to create a guest user
        smtpEmail.sendEmail("Guest user  " + guestUserRequest.getUsername() +"created.");
        return ResponseEntity.ok(guestUserRequest);

    }



}
