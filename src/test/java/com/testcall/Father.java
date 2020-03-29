package com.testcall;

public class Father extends Grandfather {
    private String name = "no2";

    @Override
    public String getName() {
        return "father is "+name;
    }
    public String getFatherName(){
        return super.getName();
    }
    public String getFatherVariableName(){
        return super.nickname;
    }
    public void eat(){
        System.out.println((name + "eat 2 apple"));
    };
}
