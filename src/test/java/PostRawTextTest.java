import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import java.net.URL;

import static io.restassured.RestAssured.given;

public class PostRawTextTest {
    private final static String URl = "https://postman-echo.com";
    @Test
    public void PostRawtest(){
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

}
