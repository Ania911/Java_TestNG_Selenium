package API;

import io.restassured.RestAssured;
import org.testng.annotations.BeforeTest;

public class Config  {

    @BeforeTest
    public void setup() {
        RestAssured.baseURI = "https://petstore.swagger.io/v2";
    }

}
