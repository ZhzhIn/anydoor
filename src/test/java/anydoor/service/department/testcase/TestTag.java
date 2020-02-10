package anydoor.service.department.testcase;

import anydoor.service.WechatConfig;
import anydoor.service.department.api.Department;
import anydoor.service.department.api.Tag;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.Matchers.hasItem;

public class TestTag {
        static String newTagName = "yin" + (int) (Math.random() * 100);
        static String token = WechatConfig.getInstance().getToken();
        static Tag tag = new Tag();

        @BeforeAll
        public static void setUp() {
            System.out.println(newTagName);
            List<String> name = tag.tagList().getBody().jsonPath().get("taglist.tagname");
            if (name.contains(newTagName)) {
                Integer id = tag.tagList().getBody().jsonPath().get("taglist.find{taglist->taglist.tagname==" + newTagName + "}.id");
                tag.tagDelete(id);
            }
        }

        @Test
        @Order(1)
        public void testTagCreate() {
            tag.tagCreate(newTagName)
                    .then()
                    .body("errmsg", equalTo("created"));
            tag.tagList()
                    .then()
                    .body("taglist.tagname", hasItem(newTagName));
            tag.tagDelete(
                    tag.tagList()
                            .getBody().jsonPath().get("taglist.find{" +
                            "taglist->taglist.tagname=='" + newTagName + "'}.tagid")
            );
        }

        @Test
        @Order(2)
        public void testTagList() {
            tag.tagList()
                    .then()
                    .body("errmsg", equalTo("ok"));
        }

        @Test
        @Order(3)
        public void tesTagDelete() {
            int id = tag.tagCreate(newTagName)
                    .then()
                    .body("errmsg", equalTo("created"))
                    .extract().body().path("tagid");
            tag.tagDelete(id)
                    .then()
                    .body("errmsg", equalTo("deleted"));
        }

        @Test
        public void testTagUpdate() {
        }

        @Test
        public void testTagSelect() {
        }
}