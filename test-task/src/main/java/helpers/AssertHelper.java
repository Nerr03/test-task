package helpers;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.Assert;

public class AssertHelper {
    public static void asserStatusCodeAndContentType(Response response, int statusCode, ContentType type) {
        Assert.assertEquals(response.statusCode(), statusCode, "Status code");
        Assert.assertEquals(response.contentType(), type.toString(), "Content type");
    }
}
