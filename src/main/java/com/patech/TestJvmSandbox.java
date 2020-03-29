package com.patech;

class MathMethod {

    //修复testException()不成功
    public Integer testExceptionNum(int x, int y) {
        return x / y;
    }

    public void testException() {
        throw new ArithmeticException("error");
    }

}

public class TestJvmSandbox {
    public static void main(String[] args) throws InterruptedException {
        MathMethod mm = new MathMethod();
        while (true) {
            try {
                mm.testException();
                mm.testExceptionNum(1, 0);
            } catch (Throwable e) {
                e.printStackTrace();
            }
            Thread.sleep(2000);
            System.out.println("byebye");
        }
    }

}
