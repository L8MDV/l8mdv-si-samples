package com.l8mdv.sample;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Copyright Matt Vickery 2012
 *
 * @author matt.d.vickery@gmail.com
 * @since 02/02/2012
 */
public class SleeperService {

    public static final String INTERRUPTED_DURING_SERVICE_CALL = "interrupted during service call";
    public final Logger logger = LoggerFactory.getLogger(getClass());

    public String service(String message) {

        logger.info("Going into wait..");
        try {
            Thread.sleep(Long.parseLong(message)*1000);
            logger.info("..waited");
            return message;
        } catch (Exception e) {
            Thread.interrupted();
            return INTERRUPTED_DURING_SERVICE_CALL;
        } finally {
            logger.info("Destruction....");
        }
    }
}
