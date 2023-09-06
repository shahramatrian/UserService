package com.shahramatrian.grpc;

import io.grpc.Channel;
import io.grpc.StatusRuntimeException;
import net.devh.boot.grpc.client.inject.GrpcClient;

import java.time.Instant;
import java.util.logging.Level;
import java.util.logging.Logger;
import com.shahramatrian.intuit.PersonLoggerGrpc;
import com.google.protobuf.Timestamp;
import com.shahramatrian.dto.PersonalInfoDTO;
import com.shahramatrian.intuit.PersonInfoRequest;
import com.shahramatrian.intuit.Response;

/**
 * A simple client that requests to log user details from the {@link PersonLoggerServer}.
 */
public class PersonLoggerClient {
    private static final Logger logger = Logger.getLogger(PersonLoggerClient.class.getName());

    private final PersonLoggerGrpc.PersonLoggerBlockingStub blockingStub;

    /**
     * Construct client for accessing PersonLogger server using the existing
     * channel.
     */
    public PersonLoggerClient(Channel channel) {
        // 'channel' here is a Channel, not a ManagedChannel, so it is not this code's
        // responsibility to
        // shut it down.

        // Passing Channels to code makes code easier to test and makes it easier to
        // reuse Channels.
        blockingStub = PersonLoggerGrpc.newBlockingStub(channel);
    }

    /** Send personal info to server. */
    public void sendPersonalInfo(PersonalInfoDTO info) {
        logger.info("Will try to send personal info " + info + " ...");

        Instant time = Instant.now();
        Timestamp timestamp = Timestamp.newBuilder().setSeconds(time.getEpochSecond())
                .setNanos(time.getNano()).build();

        PersonInfoRequest request = PersonInfoRequest.newBuilder()
                .setFirstName(info.getFirstName())
                .setLastName(info.getLastName())
                .setDob(info.getDob())
                .setEmail(info.getEmail())
                .setPhoneNumber(info.getPhoneNumber())
                .setTimestamp(timestamp)
                .build();
        Response response;
        try {
            response = blockingStub.logPersonalInfo(request);
        } catch (StatusRuntimeException e) {
            logger.log(Level.WARNING, "RPC failed: {0}", e.getStatus());
            return;
        }
        logger.info("Logging: " + response.getMessage());
    }
}
