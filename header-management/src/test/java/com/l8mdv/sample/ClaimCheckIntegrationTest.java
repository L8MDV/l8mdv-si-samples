package com.l8mdv.sample;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.integration.Message;
import org.springframework.integration.support.MessageBuilder;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static com.l8mdv.sample.ClaimCheckGateway.CLAIM_CHECK_ID;

/**
 * Copyright Matt Vickery 2012
 *
 * @author matt.d.vickery@gmail.com
 * @since 21/01/2012
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(
    locations = {"classpath:META-INF/spring/claim-check.xml"}
)
public class ClaimCheckIntegrationTest {

    @Autowired ClaimCheckGateway claimCheckGateway;

    @Test
    public void locatePayloadInHeader() {
        String payload = "Sample test message.";
        Message<String> message = MessageBuilder.withPayload(payload).build();
        Message<String> response = claimCheckGateway.send(message);

        Assert.assertTrue(response.getPayload().equals(payload));
        Assert.assertTrue(response.getHeaders().get(CLAIM_CHECK_ID) != null);
    }
}
