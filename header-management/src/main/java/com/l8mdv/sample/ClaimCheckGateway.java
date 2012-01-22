package com.l8mdv.sample;

import org.springframework.integration.Message;
import org.springframework.integration.annotation.Gateway;

public interface ClaimCheckGateway {

    public static final String CLAIM_CHECK_ID = "CLAIM_CHECK_ID";

    @Gateway (requestChannel = "claim-check-in-channel")
    public Message<String> send(Message<String> message);
}
