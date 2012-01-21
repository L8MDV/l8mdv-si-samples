package com.l8mdv.sample;

import org.springframework.integration.Message;
import org.springframework.integration.annotation.Gateway;

public interface HeaderManagementGateway {

    public static final String REQUEST_PAYLOAD_HEADER_KEY = "REQUEST_PAYLOAD_HEADER_KEY";

    @Gateway (requestChannel = "request-message-storage-channel")
    public Message<String> send(Message<String> message);
}
