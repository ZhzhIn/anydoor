package anydoor.service;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.HashMap;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;

public class TestWechat {
    String corpId="ww1aa64e79931be685";
    //通讯录同步secret
    String corpsecret="82N9nLXm5CH7ZtY6LgkWHZtEnTa0PqW2hNvy-NlUXIA";
    static String token ="";
    int parentDepartId=4;
    @BeforeAll
    public static void checkCompany(){
        token =given()
                .param("corpid","ww1aa64e79931be685")
                .param("corpsecret","82N9nLXm5CH7ZtY6LgkWHZtEnTa0PqW2hNvy-NlUXIA")
                .when()
                    .log().all()
                    .get("https://qyapi.weixin.qq.com/cgi-bin/gettoken?corpid=ID")
                .then()
                    .log().all()
                    .body("errcode",equalTo(0))
                .extract()
                    .body().path("access_token");
        System.out.println(token);
    }
    @Test
    public void departmentCreate(){
        HashMap<String,Object> data = new HashMap<>();
        data.put("name","尹ZZZZZZ");
        data.put("name_en","departID5");
        data.put("parentid",parentDepartId);
        data.put("order",1);
        data.put("id",5);
        given()
                .queryParam("access_token",token)
                .contentType(ContentType.JSON)
                .body(data)
                .when()
                .post("https://qyapi.weixin.qq.com/cgi-bin/department/create")
                .then()
                .body("errcode",equalTo(0));
//        System.out.println(token);
    }
    @Test
    public void departmentDelete(){}
    @Test
    public void departmentUpdate(){}
    @Test
    public void departmentSelect(){}

}