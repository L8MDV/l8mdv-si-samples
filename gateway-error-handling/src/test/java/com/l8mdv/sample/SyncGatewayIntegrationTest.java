package com.l8mdv.sample;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Copyright Matt Vickery 2012
 *
 * @author matt.d.vickery@gmail.com
 * @since 02/02/2012
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(
    locations = {"classpath:META-INF/spring/sync-gateway.xml"}
)
public class SyncGatewayIntegrationTest {

    @Autowired
    EnrollmentServiceGateway enrollmentServiceGateway;

    @Test
    public void requestTimeGreaterThanTimeout() throws Exception {

        /**
         * Because the gateway timeout is not observed in a synchronous
         * request pattern, the Service Activator will reflect the contents
         * of the request message. Had the gateway timeout been active, a
         * null would have been returned.
         */
        String knapPeriod = "5";
        String response = enrollmentServiceGateway.send(knapPeriod);
        Assert.assertTrue(response.equals(knapPeriod));
    }

    @Test
    public void requestTimeLessThanTimeout() throws Exception {

        /**
         * The fact that the "1" is returned (and is shorter than the gateway
         * timeout) means that the method completed successfully.
         */
        String knapPeriod = "1";
        String response = enrollmentServiceGateway.send(knapPeriod);
        Assert.assertTrue(response.equals(knapPeriod));
    }
}