package com.testpackage.testcase;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

@RunWith(Parameterized.class)
public class testParameterized {
    @Parameterized.Parameters
    public static Collection<Object[]> data(){
        return Arrays.asList(new Object[][]{
            {1,2},
            {3,3},
            {4,5},
            {6,7}
        });
    }
    @Parameterized.Parameter(0)
    public int actual;

    @Parameterized.Parameter(1)
    public int expection;

    @Test
    public void testDemo(){
        assertThat("demo",actual ,equalTo(expection));
    }
}
