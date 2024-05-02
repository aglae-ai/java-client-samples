package ai.aglae.client;

import com.google.auth.oauth2.GoogleCredentials;

import java.io.ByteArrayInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.charset.StandardCharsets;

public class ApiClientExample {
    private static final String aglaeApiHostname = "api.aglae.ai";

    public static void main(String[] args) throws Exception {
        String aglaeAiJsonKeyFile = args[0];

        GoogleCredentials credential = buildGoogleCredentials(aglaeAiJsonKeyFile);

        credential.refreshIfExpired();
        String accessToken = credential.getAccessToken().getTokenValue();

        HttpResponse<String> response = sayHelloToAglaeAiApi(accessToken);

        System.out.println("aglae.ai API Response :");
        System.out.println(response.body());
    }

    private static GoogleCredentials buildGoogleCredentials(String filePath) throws IOException {
        InputStream jsonKeyFileStream = new FileInputStream(filePath);
        GoogleCredentials credentials = GoogleCredentials.fromStream(jsonKeyFileStream);
        return credentials.createScoped("email");
    }

    private static HttpResponse<String> sayHelloToAglaeAiApi(String accessToken) throws URISyntaxException, IOException, InterruptedException {
        HttpRequest request = HttpRequest.newBuilder()
                .uri(new URI("https://" + aglaeApiHostname + "/hello"))
                .header("Authorization", "Bearer " + accessToken)
                .GET()
                .build();
        return HttpClient.newBuilder().build()
                .send(request, HttpResponse.BodyHandlers.ofString());
    }
}
