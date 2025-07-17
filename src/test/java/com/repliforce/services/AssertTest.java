package com.repliforce.services;

import org.junit.Assert;
import org.junit.Test;

public class AssertTest {

    @Test
    public void testAssert() {
        Assert.assertTrue(true);
        Assert.assertFalse(false);

        Assert.assertEquals(1, 1);
        Assert.assertEquals(0.55, 0.55, 0.01);
        Assert.assertEquals(Math.PI, 3.14, 0.01);

        int i = 5;
        Integer i2 = 5;
        Assert.assertEquals(Integer.valueOf(i), i2);
        Assert.assertEquals(5, i2.intValue());

        Assert.assertEquals("Hello", "Hello");
        Assert.assertEquals("Hello".equalsIgnoreCase("hello"), true);
        Assert.assertTrue("Hello".equalsIgnoreCase("hello"));
    }
}
