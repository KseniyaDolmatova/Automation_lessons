import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.apache.http.HttpStatus;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

import static org.hamcrest.Matchers.*;

public class ApiTest {

    private final String BASE_URL = "https://postman-echo.com";
    private final Map<String, String> paramsEmpty = new HashMap<>();

    @Test
    public void getRequestest() {
        RestAssured.given()
                .baseUri(BASE_URL)
                .accept(ContentType.ANY)
                .when()
                .get("get")
                .then()
                .assertThat()
                .statusCode(HttpStatus.SC_OK)
                .assertThat()

                .body("args", equalTo(paramsEmpty))

                .body("headers.host", equalTo("postman-echo.com"))
                .body("headers.x-request-start", startsWith("t="))
                .body("headers.connection", equalTo("close"))
                .body("headers.x-forwarded-proto", equalTo("https"))
                .body("headers.x-forwarded-port", equalTo("443"))
                .body("headers.x-amzn-trace-id", startsWith("Root="))
                .body("headers.user-agent", equalTo("Apache-HttpClient/4.5.13 (Java/11.0.22)"))
                .body("headers.accept", equalTo("*/*"))
                .body("headers.cache-control", equalTo(null))
                .body("headers.postman-token", equalTo(null))
                .body("headers.cookie", equalTo(null))

                .body("url", equalTo(BASE_URL + "/get"));
    }

    @Test
    public void postRawTextTest() {

        String raw = "{\n" +
                "    \"test\": \"value\"\n" +
                "}";

        RestAssured.given()
                .baseUri(BASE_URL)
                .accept(ContentType.ANY)
                .contentType(ContentType.TEXT)
                .body(raw)
                .post("post")
                .then()
                .assertThat()
                .statusCode(HttpStatus.SC_OK)
                .assertThat()

                .body("args", equalTo(paramsEmpty))

                .body("data", equalTo(raw))

                .body("files", equalTo(paramsEmpty))

                .body("form", equalTo(paramsEmpty))

                .body("headers.host", equalTo("postman-echo.com"))
                .body("headers.x-request-start", startsWith("t="))
                .body("headers.connection", equalTo("close"))
                .body("content-length", equalTo(null))
                .body("headers.x-forwarded-proto", equalTo("https"))
                .body("headers.x-forwarded-port", equalTo("443"))
                .body("headers.x-amzn-trace-id", startsWith("Root="))
                .body("headers.content-type", startsWith("text/plain"))
                .body("headers.user-agent", equalTo("Apache-HttpClient/4.5.13 (Java/11.0.22)"))
                .body("headers.accept", equalTo("*/*"))
                .body("headers.cache-control", equalTo(null))
                .body("headers.postman-token", equalTo(null))
                .body("headers.accept-encoding", equalTo("gzip,deflate"))
                .body("headers.cookie", equalTo(null))

                .body("json", equalTo(null))

                .body("url", equalTo(BASE_URL + "/post"));

    }

    @Test
    public void postFormDataTest() {

        Map<String, String> params = new HashMap<>();
        params.put("foo1", "bar1");
        params.put("foo2", "bar2");

        RestAssured.given()
                .baseUri(BASE_URL)
                .accept(ContentType.ANY)
                .contentType(ContentType.URLENC.withCharset("UTF-8"))
                .params(params)
                .request()
                .post("post")
                .then()
                .assertThat()
                .statusCode(HttpStatus.SC_OK)
                .assertThat()

                .body("args", equalTo(paramsEmpty))

                .body("data", sameInstance(""))

                .body("files", equalTo(paramsEmpty))

                .body("form", equalTo(params))

                .body("headers.host", equalTo("postman-echo.com"))
                .body("headers.x-request-start", startsWith("t="))
                .body("headers.connection", equalTo("close"))
                .body("content-length", equalTo(null))
                .body("headers.x-forwarded-proto", equalTo("https"))
                .body("headers.x-forwarded-port", equalTo("443"))
                .body("headers.x-amzn-trace-id", startsWith("Root="))
                .body("headers.user-agent", equalTo("Apache-HttpClient/4.5.13 (Java/11.0.22)"))
                .body("headers.accept", equalTo("*/*"))
                .body("headers.cache-control", equalTo(null))
                .body("headers.postman-token", equalTo(null))
                .body("headers.accept-encoding", equalTo("gzip,deflate"))
                .body("headers.cookie", equalTo(null))
                .body("headers.content-type", startsWith("application/x-www-form-urlencoded"))

                .body("json", equalTo(params))

                .body("url", equalTo(BASE_URL + "/post"));
    }

    @Test
    public void putRequest() {

        String data = "This is expected to be sent back as part of response body.";

        RestAssured.given()
                .baseUri(BASE_URL)
                .accept(ContentType.ANY)
                .contentType(ContentType.TEXT)
                .body(data)
                .put("put")
                .then()
                .assertThat()
                .statusCode(HttpStatus.SC_OK)
                .assertThat()

                .body("args", equalTo(paramsEmpty))

                .body("data", equalTo(data))

                .body("files", equalTo(paramsEmpty))

                .body("form", equalTo(paramsEmpty))

                .body("headers.host", equalTo("postman-echo.com"))
                .body("headers.x-request-start", startsWith("t="))
                .body("headers.connection", equalTo("close"))
                .body("content-length", equalTo(null))
                .body("headers.x-forwarded-proto", equalTo("https"))
                .body("headers.x-forwarded-port", equalTo("443"))
                .body("headers.x-amzn-trace-id", startsWith("Root="))
                .body("headers.content-type", startsWith("text/plain"))
                .body("headers.user-agent", equalTo("Apache-HttpClient/4.5.13 (Java/11.0.22)"))
                .body("headers.accept", equalTo("*/*"))
                .body("headers.cache-control", equalTo(null))
                .body("headers.postman-token", equalTo(null))
                .body("headers.accept-encoding", equalTo("gzip,deflate"))
                .body("headers.cookie", equalTo(null))

                .body("json", equalTo(null))

                .body("url", equalTo(BASE_URL + "/put"));
    }

    @Test
    public void patchRequest() {

        String data = "This is expected to be sent back as part of response body.";

        RestAssured.given()
                .baseUri(BASE_URL)
                .accept(ContentType.ANY)
                .contentType(ContentType.TEXT)
                .body(data)
                .patch("patch")
                .then()
                .assertThat()
                .statusCode(HttpStatus.SC_OK)
                .assertThat()

                .body("args", equalTo(paramsEmpty))
                .body("data", equalTo(data))
                .body("files", equalTo(paramsEmpty))
                .body("form", equalTo(paramsEmpty))

                .body("headers.host", equalTo("postman-echo.com"))
                .body("headers.x-request-start", startsWith("t="))
                .body("headers.connection", equalTo("close"))
                .body("content-length", equalTo(null))
                .body("headers.x-forwarded-proto", equalTo("https"))
                .body("headers.x-forwarded-port", equalTo("443"))
                .body("headers.x-amzn-trace-id", startsWith("Root="))
                .body("headers.content-type", startsWith("text/plain"))
                .body("headers.user-agent", equalTo("Apache-HttpClient/4.5.13 (Java/11.0.22)"))
                .body("headers.accept", equalTo("*/*"))
                .body("headers.cache-control", equalTo(null))
                .body("headers.postman-token", equalTo(null))
                .body("headers.accept-encoding", equalTo("gzip,deflate"))
                .body("headers.cookie", equalTo(null))

                .body("json", equalTo(null))

                .body("url", equalTo(BASE_URL + "/patch"));

    }

    @Test
    public void deleteRequest() {

        String data = "This is expected to be sent back as part of response body.";

        RestAssured.given()
                .baseUri(BASE_URL)
                .accept(ContentType.ANY)
                .contentType(ContentType.TEXT)
                .body(data)
                .delete("delete")
                .then()
                .assertThat()
                .statusCode(HttpStatus.SC_OK)
                .assertThat()

                .body("args", equalTo(paramsEmpty))
                .body("data", equalTo(data))
                .body("files", equalTo(paramsEmpty))
                .body("form", equalTo(paramsEmpty))

                .body("headers.host", equalTo("postman-echo.com"))
                .body("headers.x-request-start", startsWith("t="))
                .body("headers.connection", equalTo("close"))
                .body("content-length", equalTo(null))
                .body("headers.x-forwarded-proto", equalTo("https"))
                .body("headers.x-forwarded-port", equalTo("443"))
                .body("headers.x-amzn-trace-id", startsWith("Root="))
                .body("headers.content-type", startsWith("text/plain"))
                .body("headers.user-agent", equalTo("Apache-HttpClient/4.5.13 (Java/11.0.22)"))
                .body("headers.accept", equalTo("*/*"))
                .body("headers.cache-control", equalTo(null))
                .body("headers.postman-token", equalTo(null))
                .body("headers.accept-encoding", equalTo("gzip,deflate"))
                .body("headers.cookie", equalTo(null))

                .body("json", equalTo(null))

                .body("url", equalTo(BASE_URL + "/delete"));
    }

}