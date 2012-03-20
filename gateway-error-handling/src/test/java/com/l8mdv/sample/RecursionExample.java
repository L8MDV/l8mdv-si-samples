package com.l8mdv.sample;

import java.util.Arrays;

/**
 * Copyright Matt Vickery 2012
 *
 * @author matt.d.vickery@gmail.com
 * @since 04/02/2012
 */
public class RecursionExample {

    public static void main(String[] a) {
        int [] list = {1,2,3,4,5};
        int answer = (new RecursionExample()).sum(list);
        System.out.println("Answer:"+answer);
    }

    public int sum(int [] tail) {
        int tailSum = 0;
        if (tail.length > 1)
            tailSum = sum(Arrays.copyOfRange(tail, 1, tail.length));
        return tail[0] + tailSum;
    }
}
