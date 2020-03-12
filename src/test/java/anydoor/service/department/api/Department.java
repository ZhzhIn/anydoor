package anydoor.service.department.api;

import anydoor.service.WechatConfig;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import java.util.HashMap;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.Matchers.hasItem;

public class Department {
    //TODO dataProvider
    static String wechatUrl="https://qyapi.weixin.qq.com";
    static String depListLink="/cgi-bin/department/list";
    static String createDepartLink="/cgi-bin/department/create";
    static String deleteDepartLink="/cgi-bin/department/delete";
    static String updateDepartLink="/cgi-bin/department/update";
    private String token = WechatConfig.getInstance().getToken();
    private static int parentDepId = 2;
    public int getParentDepId(){
        return parentDepId;
    }

    /**
     *
     * @param depId 父部门ID
     * @return response 按照父ID查找部门列表
     */
    public Response depList(int depId){
        return given()
                .queryParam("access_token",token)
                .queryParam("id",depId)
                .when()
                .get(wechatUrl+depListLink)
                .then()
                .log().all()
                .body("errcode",equalTo(0))
                .extract().response()
                ;
    }

    /**
     *
     * @param depName 创建的部门名
     * @param depId 创建的部门的父ID
     * @return response 创建的response
     */
    public Response depCreate(String depName,int depId){
        HashMap<String,Object> data = new HashMap<>();
        data.put("name",depName);
        data.put("parentid",depId);
        return given()
                .queryParam("access_token",token)
                .contentType(ContentType.JSON)
                .body(data)
                .when()
                .post(wechatUrl+createDepartLink)
                .then()
                .log().all()
                .body("errcode",equalTo(0))
                .extract().response();
    }
    public Response depDelete(int depId){
        return given()
                .queryParam("access_token",token)
                .queryParam("id",depId)
                .when()
                .get(wechatUrl+deleteDepartLink)
                .then()
                .log().all()
                .body("errcode",equalTo(0))
                .extract().response();
    }
}
