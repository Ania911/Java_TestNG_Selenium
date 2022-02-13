package API;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import org.json.simple.JSONObject;
import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static io.restassured.http.ContentType.JSON;
import static org.hamcrest.Matchers.equalTo;

public class APIMethods {

    public static ValidatableResponse getPetsStatus(String endpoint) {
        return given()
                .when()
                .get(endpoint)
                .then().log().all();
    }

    public static void createPost(String key, String value, String endpoint, Integer statusCode) {
        JSONObject request = new JSONObject();
        request.put(key, value);
        given().
                header("Content-type", "application/json").
                contentType(JSON).
                body(request.toJSONString()).
                when().post(endpoint).
                then().statusCode(statusCode).log().all();
    }

    public static void createPostHashMap(String nameKey, String nameValue, String statusKey, String statusValue, String createNewPet, Integer statusCode) {
        Map<String, Object>  jsonAsMap = new HashMap<>();
        jsonAsMap.put(nameKey, nameValue);
        jsonAsMap.put(statusKey, statusValue);

        given().
                contentType(JSON).
                body(jsonAsMap).
                when().
                post(createNewPet).
                then().
                statusCode(statusCode).log().all();;
    }

    public static void createPostRequest(String endpoint, String requestBody, Integer statusCode) {
        given()
                .header("Content-type", "application/json")
                .and()
                .body(requestBody)
                .when()
                .post(endpoint)
                .then()
                .statusCode(statusCode)
                .body("message", equalTo("no data")).log().all();
    }

    public static void requestSpecification() {
        RequestSpecification requestSpec = new RequestSpecBuilder()
                .addParam("parameter1", "value1").build();
    }

    public static void responseSpecification() {
        ResponseSpecification responseSpec = new ResponseSpecBuilder()
                .expectStatusCode(200).build();
    }

}
