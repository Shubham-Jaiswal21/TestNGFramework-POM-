package test.api_be;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.RequestBuilder;
import utils.SchemaValidator;

import static io.restassured.RestAssured.given;

public class testApiBackend {

    @Test
    public void testPostCreateUser() {
        String baseUrl = "https://reqres.in/api";
        String requestBody = "{ \"name\": \"John\", \"job\": \"QA Engineer\" }";
        RequestSpecification requestSpec = RequestBuilder.getRequestSpec(baseUrl);
        Response response = given()
                .spec(requestSpec)
                .body(requestBody)
                .when()
                .post("/users")
                .then()
                .statusCode(201)
                .body(SchemaValidator.getUserSchemaValidator())
                .extract().response();

        System.out.println("Response: " + response.asPrettyString());
    }

    @Test
    public void testGetUsers() {
        String baseUrl = "https://reqres.in/api";
        RequestSpecification requestSpec = RequestBuilder.getRequestSpec(baseUrl);
        Response response = given()
                .spec(requestSpec)
                .when()
                .get("/users?page=2")
                .then()
                .statusCode(200)
                .body(SchemaValidator.getUserListSchemaValidator())
                .extract().response();

        System.out.println("Response: " + response.asPrettyString());
        Assert.assertEquals(response.getStatusCode(), 200);
    }
}

