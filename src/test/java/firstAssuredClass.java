import io.restassured.response.Response;
import org.junit.jupiter.api.Test;

import java.text.MessageFormat;
import java.util.concurrent.TimeUnit;

import static io.restassured.RestAssured.given;

public class firstAssuredClass {

    String url = "http://demo.guru99.com/V4/sinkministatement.php";

    @Test
    public void getResponseBody() {

        given().queryParam("CUSTOMER_ID", "68195")
                .queryParam("PASSWORD", "1234!")
                .queryParam("Account_No", "1")
                .when().get().then().log().body();
    }

    @Test
    public void getResponseStatus() {
        int statusCode = given().queryParam("CUSTOMER_ID", "68195")
                .queryParam("PASSWORD", "1234!")
                .queryParam("Account_No", "1")
                .when().get(url).getStatusCode();

        //System.out.println(MessageFormat.format("The status code is {0}", statusCode));
        System.out.println("Status Code " + statusCode);
        given().when().get(url).then().assertThat().statusCode(200);

    }

    @Test
    public void getResponseTime(){
        System.out.println("The time taken to fetch the response "+
                given().queryParam("CUSTOMER_ID", "68195")
                        .queryParam("PASSWORD", "1234!")
                        .queryParam("Account_No", "1")
                        .when().get(url)
                .timeIn(TimeUnit.MILLISECONDS) + " milliseconds");
    }

    @Test
    public void getResponseContentType() {
        System.out.println("The content type of response " +
                given().queryParam("CUSTOMER_ID", "68195")
                        .queryParam("PASSWORD", "1234!")
                        .queryParam("Account_No", "1")
                        .when()
                        .get(url).then().extract().contentType());
    }

}
