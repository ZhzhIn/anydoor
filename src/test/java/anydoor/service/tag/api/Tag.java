package anydoor.service.tag.api;

import anydoor.service.WechatConfig;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import java.util.HashMap;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;

public class Tag {

    //TODO dataProvider
    static String wechatUrl="https://qyapi.weixin.qq.com";
    static String tagListLink="/cgi-bin/tag/list";
    static String createTagLink="/cgi-bin/tag/create";
    static String deleteTagLink="/cgi-bin/tag/delete";
    static String updateTagLink="/cgi-bin/tag/update";
    static String getTagLink="/cgi-bin/tag/get";
    private String token = WechatConfig.getInstance().getToken();



    public Response tagList(){
        return given()
                .queryParam("access_token",token)
                .when()
                .get(wechatUrl+tagListLink)
                .then()
                .log().all()
                .body("errcode",equalTo(0))
                .extract().response()
                ;
    }

    public Response tagCreate(String tagName){
        HashMap<String,Object> data = new HashMap<>();
        data.put("tagname",tagName);
        return given()
                .queryParam("access_token",token)
                .contentType(ContentType.JSON)
                .body(data)
                .when()
                .post(wechatUrl+createTagLink)
                .then()
                .log().all()
                .body("errcode",equalTo(0))
                .extract().response();
    }
    public Response tagDelete(int tagId){
        return given()
                .queryParam("access_token",token)
                .queryParam("tagid",tagId)
                .when()
                .get(wechatUrl+deleteTagLink)
                .then()
                .log().all()
                .body("errcode",equalTo(0))
                .extract().response();
    }
}