package com.patech;

import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

/**
 * @ClassName: TestCoverage
 * @Description:
 * @Author: zhzh.yin
 * @Date: 2020-04-01 14:47
 * @Verion: 1.0
 */
public class TestNumDivide {
    NumDivide co = new NumDivide();

    @Test
    public void testCoverage1() {
        assertThat(co.divide1(1,2),equalTo(2));
    }

    @Test
    public void testCoverage2() {
        assertThat(co.divide1(2,1),equalTo(2));
    }

    @Test
    public void testCoverage3() {
        assertThat(co.divide1(0,0),equalTo(0));
    }

    @Test
    public void testCoverage4() {
        assertThat(co.divide1(1,1),equalTo(1));
    }
}
