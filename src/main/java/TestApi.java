import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.given;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;
public class TestApi {
    @Test()
    public void testGet() {
        Response response1 =
                given()
                        .log().all()
                        .when()
                        .get("https://reqres.in/api/users?page=2")
                        .then()
                        .log().all()
                        .statusCode(200)
                        .extract()
                        .response();
        response1.getBody().print();
    }
    @Test
    public void updateExistingPet() {
            given()
                .body("{\n" +
                        "    \"name\": \"Мария\",\n" +
                        "    \"job\": \"Моё дело\"\n" +
                        "}")
                .log().everything()
                .contentType(ContentType.JSON)
                .baseUri("https://reqres.in")
                .post("/api/users/")
                .then()
                .log().all()
                .statusCode(201)
                .body(matchesJsonSchemaInClasspath("JsonSchema.json"));
   /*  ni*/

    }
}
