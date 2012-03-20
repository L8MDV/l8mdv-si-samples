package com.l8mdv.sample;

import junit.framework.Assert;
import org.junit.Test;

/**
 * Copyright Matt Vickery 2012
 *
 * @author matt.d.vickery@gmail.com
 * @since 20/03/2012
 */
public class MessageTrimmerTest {

    public static final String THE_CAT_IN_THE_HAT = "The cat in the hat.";
    private MessageTrimmer trimmer = new MessageTrimmer();

    @Test(expected = java.lang.IllegalArgumentException.class)
    public void service_nullMessage() throws Exception {
        trimmer.service(null, "5");
    }

    @Test(expected = java.lang.IllegalArgumentException.class)
    public void service_nullLength() throws Exception {
        trimmer.service(THE_CAT_IN_THE_HAT, null);
    }

    @Test(expected = java.lang.IllegalArgumentException.class)
    public void service_nullBoth() throws Exception {
        trimmer.service(null, null);
    }

    @Test
    public void service_shorter() throws Exception {
        String response = trimmer.service(THE_CAT_IN_THE_HAT, "95");
        Assert.assertEquals(response, THE_CAT_IN_THE_HAT);
    }

    @Test
    public void service_longer() throws Exception {
        String response = trimmer.service(THE_CAT_IN_THE_HAT, "4");
        Assert.assertEquals(response, THE_CAT_IN_THE_HAT.substring(0,4));
    }

    @Test
    public void service_same() throws Exception {
        String response = trimmer.service(THE_CAT_IN_THE_HAT, ""+THE_CAT_IN_THE_HAT.length());
        Assert.assertEquals(response, THE_CAT_IN_THE_HAT);
    }
}
