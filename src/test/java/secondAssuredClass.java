

import static io.restassured.RestAssured.*;

import org.json.simple.JSONObject;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.hamcrest.Matchers.*;


public class econdAssuredClass {

    @Test
    public void statusCheck() {
        baseURI = "https://reqres.in/api";
        given().get("/users?page=2")
                .then().statusCode(200);
    }

    @Test
    public void checkID() {
        baseURI = "https://reqres.in/api";
        given().get("/users?page=2")
                .then().statusCode(200)
                .body("data.id[1]", equalTo(8)).log().all();
    }

    @Test
    public void checkSeveralNames() {
        baseURI = "https://reqres.in/api";
        given().get("/users?page=2")
                .then().statusCode(200)
                .body("data.first_name", hasItems("Michael", "Lindsay", "Tobias", "Byron", "George", "Rachel")).log().all();
    }


    @Test
    public void checkPost() {

        baseURI = "https://reqres.in/api";

        Map<String, Object> map = new HashMap<String, Object>();
        JSONObject request = new JSONObject(map);
        request.put("name", "MyName");
        request.put("job", "OtherJob");

        given().header("Content-Type", "application/json")
                .body(request.toJSONString()).when()
                .post("/users")
                .then()
                .statusCode(201).log().all();

    }


}
