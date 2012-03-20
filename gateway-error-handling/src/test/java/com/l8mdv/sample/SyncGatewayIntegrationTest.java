package com.l8mdv.sample;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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

    private Logger logger = LoggerFactory.getLogger(SyncGatewayIntegrationTest.class);

    @Autowired
    private EnrollmentServiceGateway enrollmentServiceGateway;

    @Test
    public void requestTimeGreaterThanTimeout() throws Exception {

        /**
         * Because the gateway timeout is not observed in a synchronous
         * request pattern, the Service Activator will reflect the contents
         * of the request message. Had the gateway timeout been active, a
         * null would have been returned.
         */
        String sleepPeriod = "5";
        String response = enrollmentServiceGateway.send(sleepPeriod);
        Assert.assertTrue(response.equals(sleepPeriod));
    }

    @Test
    public void requestTimeLessThanTimeout() throws Exception {

        /**
         * The fact that the "1" is returned (and is shorter than the gateway
         * timeout) means that the method completed successfully.
         */
        String sleepPeriod = "1";
        String response = enrollmentServiceGateway.send(sleepPeriod);
        Assert.assertTrue(response.equals(sleepPeriod));
    }
}