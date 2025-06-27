package edu.kfk.gouri.common;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@Configuration
public class SmtpEmail {


    public ResponseEntity<?> sendEmail(String usercreated) {
        log.info(" Sending email for "+usercreated);
        return ResponseEntity.ok("Email sent successfully for user creation: " + usercreated);
    }
}
