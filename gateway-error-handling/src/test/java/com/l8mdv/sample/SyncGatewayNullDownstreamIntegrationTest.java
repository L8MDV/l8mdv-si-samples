package com.l8mdv.sample;

import org.junit.Assert;
import org.junit.Ignore;
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
    locations = {"classpath:META-INF/spring/sync-gateway-null-downstream.xml"}
)
public class SyncGatewayNullDownstreamIntegrationTest {

    private Logger logger = LoggerFactory.getLogger(SyncGatewayNullDownstreamIntegrationTest.class);

    @Autowired
    private EnrollmentServiceGateway enrollmentServiceGateway;

    @Ignore
    @Test
    public void requestTimeGreaterThanTimeout() throws Exception {

        String sleepPeriod = "3";
        String response = enrollmentServiceGateway.send(sleepPeriod);
        Assert.assertTrue(response.equals(sleepPeriod));
    }

}