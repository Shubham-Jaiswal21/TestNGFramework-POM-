package utils;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;

public class RequestBuilder {

    public static RequestSpecification getRequestSpec(String BASE_URL) {
        return new RequestSpecBuilder()
                .setBaseUri(BASE_URL)
                .setContentType(ContentType.JSON)
                .build();
    }

}
