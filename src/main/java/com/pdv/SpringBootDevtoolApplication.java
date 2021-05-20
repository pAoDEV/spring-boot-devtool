package com.pdv;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

@RestController
@SpringBootApplication
public class SpringBootDevtoolApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootDevtoolApplication.class, args);
    }

    @Value("${spring.message.welcome}")
    private String welcomeMessage;

    @GetMapping({"hello", "hello/{value}"})
    public ResponseEntity hello(
            @PathVariable(value = "value", required = false) String value
    ) {

        return ResponseEntity.ok(new HashMap<String, Object>() {{
            put("message", welcomeMessage);
            put("value", value);
        }});
    }
}
