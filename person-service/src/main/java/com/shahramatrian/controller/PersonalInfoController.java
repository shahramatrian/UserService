package com.shahramatrian.controller;

// import java.time.LocalDateTime;
import java.util.concurrent.TimeUnit;

import org.springframework.beans.factory.annotation.Value;
// import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.shahramatrian.dto.PersonalInfoDTO;
import com.shahramatrian.grpc.PersonLoggerClient;

import io.grpc.Grpc;
import io.grpc.InsecureChannelCredentials;
import io.grpc.ManagedChannel;

@RestController
@RequestMapping("/api/v1/users")
public class PersonalInfoController {
    @Value("${grpc.client.name.address}")
    private String target;

    @PostMapping(consumes="application/json")
    public ResponseEntity<Void> setPersonalInfo(@RequestBody PersonalInfoDTO personalInfo) throws InterruptedException {
        // Create a communication channel to the server, known as a Channel.
        ManagedChannel channel = Grpc.newChannelBuilder(target, InsecureChannelCredentials.create())
                .build();
        try {
            PersonLoggerClient loggerClient = new PersonLoggerClient(channel);
            loggerClient.sendPersonalInfo(personalInfo);
        } finally {
            // ManagedChannels use resources like threads and TCP connections. To prevent
            // leaking these resources the channel should be shut down when it will no longer be used. If
            // it may be used again leave it running.
            channel.shutdownNow().awaitTermination(5, TimeUnit.SECONDS);
            // return ResponseEntity.noContent().build();
        }
        return ResponseEntity.noContent().build();
    }
}
