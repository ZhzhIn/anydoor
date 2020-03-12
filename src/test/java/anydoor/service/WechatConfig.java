package anydoor.service;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;

public class WechatConfig {
    static String corpId="ww1aa64e79931be685";
    static String corpsecret="82N9nLXm5CH7ZtY6LgkWHdqbxoO05__ju05IEQvWYTk";
    static String wechatUrl="https://qyapi.weixin.qq.com";
    static String tokenLink="/cgi-bin/gettoken";
    public static WechatConfig config;
    static String token;




    public static WechatConfig getInstance(){
        if(config==null){
            config = new WechatConfig();
        }
        return config;
    }
    public String getToken(){
        if(token ==null) {
            token = given()
                    .param("corpid", corpId)
                    .param("corpsecret", corpsecret)
                    .when()
                    .get(wechatUrl + tokenLink)
                    .then()
                    .body("errcode", equalTo(0))
                    .extract()
                    .body().path("access_token");
        }
        return token ;
    }

}
