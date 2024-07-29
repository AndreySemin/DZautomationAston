import io.restassured.response.ValidatableResponse;
import org.hamcrest.Matchers;
import org.testng.Assert;
import org.testng.annotations.Test;


import static io.restassured.RestAssured.given;

public class PostmanTest {
    private final static String URl = "https://postman-echo.com";
    private final static String TEXT = "This is expected to be sent back as part of response body.";

    @Test
    public void getRequest() {
        ValidatableResponse args;
        args = given()
                .when()
                .get(URl + "/get?foo1=bar1&foo2=bar2")
                .then()
                .assertThat()
                .statusCode(200)
                .and()
                .assertThat()
                .body("args.foo1", Matchers.equalTo("bar1"))
                .body("args.foo2", Matchers.equalTo("bar2"));
    }

    @Test
    public void postRawTextTest(){
        String rawText = "\"test\":\"value\"";

        given()
                .body(rawText)
                .when()
                .post(URl+"/post")
                .then()
                .log().all()
                .assertThat()
                .statusCode(200)
                .and()
                .body("data", Matchers.equalTo(rawText));


    }
    @Test
    public void postDateTest() {
        String rawText = "\"test\":\"value\"";
        given()
                .body(rawText)
                .when()
                .post(URl + "/post")
                .then()
                .log().all()
                .assertThat()
                .statusCode(200)
                .and()
                .body("data", Matchers.equalTo(rawText));
    }
    @Test
    public void putRawTextTest(){
        given()
                .body(TEXT)
                .when()
                .put(URl + "/put")
                .then()
                .log().all()
                .assertThat()
                .body("data", Matchers.equalTo(TEXT));

    }
    @Test
    public void patchRawTextTest(){
        given()
                .body(TEXT)
                .when()
                .patch(URl+"/patch")
                .then()
                .log().all()
                .assertThat()
                .body("data", Matchers.equalTo(TEXT));
    }
    @Test
    public void deleteRawTextTest(){
        given()
                .body(TEXT)
                .when()
                .delete(URl+"/delete")
                .then()
                .log().all()
                .assertThat()
                .body("data", Matchers.equalTo(TEXT));
    }

}
