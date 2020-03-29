package com.testcall;

public class Son extends Father {
    private String name = "no3";

    @Override
    public String getName() {
        return "son is "+name;
    }
    public String getFatherNameUseSuper(){
        return super.getName();
    }
    public String getGrandFatherName(){
        return super.getFatherName();
    }
    public void eat(){
        System.out.println((name + "eat 3 apple"));
    };
}
