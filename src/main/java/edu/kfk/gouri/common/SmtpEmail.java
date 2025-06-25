package edu.kfk.gouri.common;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RequestMapping
@RestController("/smtp-email")
public class SmtpEmail {


    @PostMapping(value = "/sendEmail", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> sendEmail(String usercreated) {
        log.info(" Sending email for users creation "+usercreated);
        return ResponseEntity.ok("Email sent successfully for user creation: " + usercreated);
    }
}
