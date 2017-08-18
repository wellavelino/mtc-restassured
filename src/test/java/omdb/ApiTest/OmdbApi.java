package omdb.ApiTest;

import org.junit.Test;

import static io.restassured.RestAssured.given;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;
import static org.junit.Assert.assertThat;

/**
 * Created by wellingtonsantos on 8/17/17.
 */
public class OmdbApi {

    @Test
    public void ShouldReturnStatusCode200WhenGetAValidRequest() {
        given()

                .when()
                .get("http://www.omdbapi.com/?t=Batman&apikey=1bcadfd2")

                .then()
                .statusCode(200);
    }

    @Test
    public void ValidateJsonSchemaWithValidRequest() {
        String response = given()
                .when()
                .get("http://www.omdbapi.com/?t=Batman&apikey=1bcadfd2")

                .then()
                .extract().response().body().print();

        assertThat(response, matchesJsonSchemaInClasspath("assets/schema.json"));
    }
}
