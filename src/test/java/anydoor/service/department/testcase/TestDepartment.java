package anydoor.service.department.testcase;

import anydoor.service.WechatConfig;
import anydoor.service.department.api.Department;
import io.qameta.allure.*;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.Matchers.hasItem;

public class TestDepartment {
    static String newDepName="yin"+(int)(Math.random()*100);
    static String  token= WechatConfig.getInstance().getToken();
    static Department department= new Department();
    static int parentDepartId = department.getParentDepId();

    @BeforeAll
    public static void setUp(){
        List<String> name  = department.depList(parentDepartId).getBody().jsonPath().get("department.name");
        if(name.contains(newDepName)){
            Integer id =department.depList(parentDepartId).getBody().jsonPath().get("department.find{department->department.id=="+parentDepartId+"}.id");
            department.depDelete(id);
        }
//        List<Map> deps= department.depList(parentDepartId).getBody().jsonPath().get("department");
        /*        RestAssured.filters((req, res, ctx)->{
            req.queryParam("access_token",token);
            Response response=ctx.next(req,res);
            return response;
        });*/
    }
    @Test
    public void testcase(){}
    @Test
    @Order(1)
    @DisplayName("添加部门")
    @Severity(SeverityLevel.MINOR)
    public void testDepCreate(){
       department.depCreate(newDepName,parentDepartId)
            .then()
            .body("errmsg",equalTo("created"));
       department.depList(parentDepartId)
               .then()
               .body("department.name",hasItem(newDepName));
       department.depDelete(
               department.depList(parentDepartId)
               .getBody().jsonPath().get("department.find{" +
                       "department->department.name=='"+newDepName+"'}.id")
       );
    }
    @Test
    @Order(2)
    public void testDepList(){
        department.depList(department.getParentDepId())
        .then()
                .body("errmsg",equalTo("ok"));
    }
    @Test
    @Order(3)
    public void tesDepDelete(){
        int id = department.depCreate(newDepName,parentDepartId)
                .then()
                .body("errmsg",equalTo("created"))
                .extract().body().path("id");
        department.depDelete(id)
                .then()
                .body("errmsg",equalTo("deleted"));
    }
    @Test
    public void testDepUpdate(){}
    @Test
    public void testDepSelect(){}

}