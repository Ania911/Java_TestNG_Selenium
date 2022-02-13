package API;

import io.restassured.RestAssured;
import org.apache.http.config.ConnectionConfig;
import org.testng.annotations.BeforeTest;

public class Config  {

    @BeforeTest
    public void setup() {
        RestAssured.baseURI = "https://petstore.swagger.io/v2";
    }

}
