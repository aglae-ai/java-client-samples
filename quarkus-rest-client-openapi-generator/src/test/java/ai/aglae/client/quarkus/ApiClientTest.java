package ai.aglae.client.quarkus;

import io.quarkus.test.junit.QuarkusTest;
import jakarta.ws.rs.core.Response;
import org.eclipse.microprofile.rest.client.inject.RestClient;
import org.junit.jupiter.api.Test;
import org.openapi.quarkus.openapi_json.api.DefaultApi;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;

@QuarkusTest
class ApiClientTest {
    @RestClient
    DefaultApi api;

    @Test
    void testHello() {
        Response response = api.sayHello();

        System.out.println("Response :");
        System.out.println(response.readEntity(String.class));
    }
}
