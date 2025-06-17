package edu.kfk.gouri.controller;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import edu.kfk.gouri.model.UserRequest;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.graphql.GraphQlProperties;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
@CrossOrigin("*")
@AllArgsConstructor
@Slf4j
public class UsersController {
    @Autowired
    KafkaTemplate<String, String> kafkaTemplate;

    ObjectMapper objectMapper = new ObjectMapper();

    @PostMapping("/createUser")
    public ResponseEntity<UserRequest> createUser(@Validated @RequestBody UserRequest users){
        log.info(" Start creating user ");
        String userRequestJson = null;
        try{
            userRequestJson = objectMapper.writeValueAsString(users);
            log.info("orderRequestJson : {}", userRequestJson);
        }catch (JsonProcessingException e){
            e.printStackTrace();
        }
        kafkaTemplate.send("User_created", userRequestJson);

        log.info("User details: {}", userRequestJson);
        return ResponseEntity.status(HttpStatus.CREATED).build();


    }

}
