package ai.aglae.client.quarkus.client_auth;

import com.google.auth.oauth2.GoogleCredentials;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.ws.rs.Produces;
import org.eclipse.microprofile.config.inject.ConfigProperty;

import java.io.ByteArrayInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;

public class GoogleCredentialsProvider {
    @ConfigProperty(name = "AGLAE_AI_JSON_KEY")
    String aglaeAiJsonKey;

    @Produces
    @ApplicationScoped
    public GoogleCredentials getCredentials() throws IOException {
        InputStream jsonKeyFileStream = new FileInputStream(aglaeAiJsonKey);
        return GoogleCredentials.fromStream(jsonKeyFileStream).createScoped("email");
    }
}
