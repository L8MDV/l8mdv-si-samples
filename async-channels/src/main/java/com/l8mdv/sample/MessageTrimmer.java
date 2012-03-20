package com.l8mdv.sample;

import org.springframework.integration.annotation.Header;
import org.springframework.util.Assert;

/**
 * Copyright Matt Vickery 2012
 *
 * @author matt.d.vickery@gmail.com
 * @since 20/03/2012
 */
public class MessageTrimmer {

    public static final String MANDATORY_ARGUMENT_MISSING = "Mandatory argument missing.";

    public String service(String message, @Header(value = "TRIM_LENGTH") String length) {

        Assert.notNull(message, MANDATORY_ARGUMENT_MISSING);
        Assert.notNull(length, MANDATORY_ARGUMENT_MISSING);

        int proposedLastCharPosition = Integer.parseInt(length);
        return message.substring(0, proposedLastCharPosition > message.length() ? message.length() : proposedLastCharPosition);
    }
}
