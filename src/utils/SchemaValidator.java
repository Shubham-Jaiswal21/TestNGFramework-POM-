package utils;
import io.restassured.module.jsv.JsonSchemaValidator;
import java.io.File;

public class SchemaValidator {


    public static JsonSchemaValidator getUserSchemaValidator() {
        return JsonSchemaValidator.matchesJsonSchema(new File(commonUtils.getSchemaPath("user-schema.json")));
    }

    public static JsonSchemaValidator getUserListSchemaValidator() {
        return JsonSchemaValidator.matchesJsonSchema(new File(commonUtils.getSchemaPath("user-list-schema.json")));
    }
}
