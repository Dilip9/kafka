package edu.kfk.gouri.common;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RequestMapping
@RestController("/smtp-email")
public class SmtpEmail {

    @Autowired
    @KafkaListener(topics="User_created",groupId="cid")

    public void consume(String usercreated) {
        log.info(" Sending email for users creation "+usercreated);
    }
}
