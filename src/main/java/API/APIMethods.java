package API;

import io.restassured.response.ValidatableResponse;
import org.json.simple.JSONObject;
import java.util.HashMap;
import java.util.Map;
import static io.restassured.RestAssured.*;
import static io.restassured.http.ContentType.JSON;
import static org.hamcrest.Matchers.*;

public class APIMethods {


    public static ValidatableResponse getPetsStatus(String endpoint) {
        return given()
                .when()
                .get(endpoint)
                .then().log().all();
    }

    public static ValidatableResponse getPetsStatusById(String endpoint, Integer id) {
        return given()
                .when()
                .get(endpoint + id)
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

    public static void createPostHashMap(String id, Integer value, String nameKey, String nameValue, String statusKey, String statusValue, String createNewPet, Integer statusCode) {
        Map<String, Object> jsonAsMap = new HashMap<>();
        jsonAsMap.put(nameKey, nameValue);
        jsonAsMap.put(statusKey, statusValue);
        jsonAsMap.put(id, value);

        given().
                contentType(JSON).
                body(jsonAsMap).
                when().
                post(createNewPet).
                then().
                statusCode(statusCode)
                .body(nameKey, equalTo(nameValue))
                .body(statusKey, equalTo(statusValue)).log().all();
    }

    public static void updatePutHashMap(String id, Integer value, String nameKey, String nameValue, String statusKey, String statusValue, String createNewPet, Integer statusCode) {
        Map<String, Object> jsonAsMap = new HashMap<>();
        jsonAsMap.put(nameKey, nameValue);
        jsonAsMap.put(statusKey, statusValue);
        jsonAsMap.put(id, value);

        given().
                contentType(JSON).
                body(jsonAsMap).
                when().
                post(createNewPet).
                then().
                statusCode(statusCode)
                .body(nameKey, equalTo(nameValue))
                .body(statusKey, equalTo(statusValue)).log().all();
    }

    public static void createPostRequest(String endpoint, String requestBody, Integer statusCode) {
        given()
                .header("Content-type", "application/json")
                .and()
                .body(requestBody)
                .when()
                .post(endpoint)
                .then()
                .statusCode(statusCode).log().all();
    }

    public static void deleteRequest(String endpoint, Integer id, Integer statusCode) {
        given()
                .when()
                .delete(endpoint + id)
                .then()
                .statusCode(statusCode).log().all();
    }

    public static void request(int id, String name, String status, String endpoint) {
        Pet body = new Pet(id, name, status);
        given()
                .body(body)
                .when()
                .post(endpoint)
                .then();
        System.out.println(endpoint);
        System.out.println(body);
           //     .log().all();
    }

}
