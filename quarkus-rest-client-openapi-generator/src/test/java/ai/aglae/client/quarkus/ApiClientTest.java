package ai.aglae.client.quarkus;

import io.quarkus.test.junit.QuarkusTest;
import jakarta.ws.rs.core.Response;
import org.eclipse.microprofile.rest.client.inject.RestClient;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.openapi.quarkus.openapi_json.api.DefaultApi;

import java.io.File;

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

    @Test
    @Disabled // Comment this out to run the upload test
    void testUploadCsv() {
        DefaultApi.UpsertJobSeekersCsvMultipartForm form = new DefaultApi.UpsertJobSeekersCsvMultipartForm();
        form._file = new File("src/test/resources/empty.csv");
        Response response = api.upsertJobSeekersCsv(form);

        System.out.println("Reponse code :");
        System.out.println(response.getStatus());
    }
}
