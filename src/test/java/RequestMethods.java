import io.restassured.response.ValidatableResponse;
import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;


public class RequestMethods {
    private final static String URl = "https://postman-echo.com";

    @Test
    public void argsBody() {
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


}







