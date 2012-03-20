package com.l8mdv.sample;

import org.springframework.integration.Message;

/**
 * Copyright Matt Vickery 2012
 *
 * @author matt.d.vickery@gmail.com
 * @since 20/03/2012
 */
public interface AsynchChannelsGateway {

    public Message<String> send(Message<String> message);

}
