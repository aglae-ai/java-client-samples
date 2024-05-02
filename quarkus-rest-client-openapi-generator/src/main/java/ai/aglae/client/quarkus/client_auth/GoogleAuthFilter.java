package ai.aglae.client.quarkus.client_auth;

import com.google.auth.oauth2.GoogleCredentials;
import jakarta.inject.Inject;
import jakarta.ws.rs.client.ClientRequestContext;
import jakarta.ws.rs.client.ClientRequestFilter;
import jakarta.ws.rs.ext.Provider;

import java.io.IOException;

@Provider
public class GoogleAuthFilter implements ClientRequestFilter {
    @Inject
    GoogleCredentials credential;

    @Override
    public void filter(ClientRequestContext clientRequestContext) throws IOException {
        credential.refreshIfExpired();
        clientRequestContext.getHeaders().add("Authorization", "Bearer " + credential.getAccessToken().getTokenValue());
    }
}
