package com.testpackage.suite;

import org.junit.Assert;
import org.junit.experimental.categories.Category;
import org.junit.jupiter.api.Test;

public class TestDemo {
    @Test
    @Category({FastGroup.class,SlowGroup.class})
    void test1(){
        Assert.assertTrue(true);
    }
    @Category(FastGroup.class)
    @Test
    void test2(){
        Assert.assertTrue(true);
    }
    @Test
    @Category(SlowGroup.class)
    void test3(){
        Assert.assertTrue(true);
    }
    @Test
    @Category(SlowGroup.class)
    void test4(){
        Assert.assertTrue(true);
    }
    @Test
    void test5(){
        Assert.assertTrue(true);
    }
    @Test
    void test6(){
        Assert.assertTrue(true);
    }


}
