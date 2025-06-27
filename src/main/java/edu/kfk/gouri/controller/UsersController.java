package edu.kfk.gouri.controller;


import edu.kfk.gouri.common.SmtpEmail;
import edu.kfk.gouri.model.UserRequest;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
@CrossOrigin("*")
@AllArgsConstructor
@Slf4j
public class UsersController {

    @Autowired
    SmtpEmail smtpEmail;

//    @Autowired
//    KafkaTemplate<String, String> kafkaTemplate;
//
//    ObjectMapper objectMapper = new ObjectMapper();

    @PostMapping(value = "/createUser", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<UserRequest> createUser(@Valid @RequestBody UserRequest users){
        log.info(" Start creating user ");
        //String userRequestJson = null;
//        try{
//            userRequestJson = objectMapper.writeValueAsString(users);
//            log.info("orderRequestJson : {}", userRequestJson);
//        }catch (JsonProcessingException e){
//            e.printStackTrace();
//        }
//        kafkaTemplate.send("trial", userRequestJson);
        smtpEmail.sendEmail(" User created: " + users.getUsername()+ "created successfully");
        log.info("User details: {}", users);
        return ResponseEntity.status(HttpStatus.CREATED).build();


    }

}
