# Quarkus API client

This is an example of integrating the [aglae.ai REST API](https://docs.aglae.ai/) in a [Quarkus](https://quarkus.io/) codebase.

This project uses the following Quarkus extensions:
- [Quarkus - OpenAPI Generator - Client](https://docs.quarkiverse.io/quarkus-openapi-generator/dev/client.html)
- its underlying [REST Client](https://quarkus.io/guides/rest-client)

Authentication requires using a GCP service account JSON private key file that must be provided by the aglae.ai tech team.

Authentication is done with :
- a [GoogleCredentialsProvider](./src/main/java/ai/aglae/client/quarkus/client_auth/GoogleCredentialsProvider.java) to autoconfigure the GCP authentication plumbing from the JSON private key file
- a [GoogleAuthFilter](./src/main/java/ai/aglae/client/quarkus/client_auth/GoogleAuthFilter.java) to add the `Authorization` header to the HTTP requests with an access token obtained from GoogleCredentials

## Configuration

Create the application.properties from the template
```bash
cp src/main/resources/application.properties.example src/main/resources/application.properties
```

Open `src/main/resources/application.properties` and replace `[PATH_TO_JSON_PRIVATE_KEY]` with the path to the JSON private key file provided by the aglae.ai tech team.

## Usage

Running :
```bash
mvn clean package
```
will :
- download the latest OpenAPI specification from the aglae.ai API documentation site (c.f. `wagon-maven-plugin` in `pom.xml`).
- generate the Java client code from the OpenAPI specification (output in `target/generated-sources/open-api-json`).
- Run [a test](./src/test/java/ai/aglae/client/quarkus/ApiClientTest.java) that uses the generated client code with the authentication plumbing to call the aglae.ai API `/hello` endpoint.
