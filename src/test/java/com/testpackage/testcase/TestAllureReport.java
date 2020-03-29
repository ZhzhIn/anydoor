package com.testpackage.testcase;

import io.qameta.allure.*;
import io.qameta.allure.model.Status;
import io.qameta.allure.model.StepResult;
import org.junit.jupiter.api.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class TestAllureReport {
    @Test
    @Description("this is a description")
    @Link("http://testerhome.com")
    @Issue("110")
    void test() throws FileNotFoundException {
        try{
        Allure.addAttachment("picture","image/png",
               new FileInputStream("C:\\Users\\yindongzi\\Desktop\\20200317170224.png"),
                ".png");
        }catch (FileNotFoundException e){
            e.printStackTrace();
        }
    }
    @Test
    void testStep(){
        StepResult stepResult=new StepResult();
        stepResult.setStatus(Status.BROKEN);
        stepResult.setName("step name");

        Allure.getLifecycle().startStep("new step",stepResult);
        Allure.getLifecycle().stopStep();
    }
    @Step("this is a step")
    public void login(){
        System.out.println("hello");
        try{
            Allure.addAttachment("step pic ","image/png",
                    new FileInputStream("C:\\Users\\yindongzi\\Desktop\\20200317170224.png"),
                    ".png");
        }catch (FileNotFoundException e){
            e.printStackTrace();
        }
    }
}
