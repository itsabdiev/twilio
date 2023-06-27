package com.sunny.twilio;

import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication

public class TwilioApplication implements CommandLineRunner {

    @Value("${spring.twilio.sid}")
    private String ACCOUNT_SID;
    @Value("${spring.twilio.auth-token}")
    private String AUTH_TOKEN;
    @Value("${spring.twilio.number}")
    private String PHONE_NUMBER;


    public static void main(String[] args) {
        SpringApplication.run(TwilioApplication.class, args);
    }

    @Override
    public void run(String... args)  {
        Twilio.init(ACCOUNT_SID, AUTH_TOKEN);
        Message message = Message.creator(
                        new PhoneNumber("+996708403454"),
                        new PhoneNumber(PHONE_NUMBER),
                        "Hello ,Mate")
                .create();
        System.out.println(message.getSid());
    }
}
