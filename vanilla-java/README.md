# Vanilla Java API client

This is a very minimalistic example of a Java HTTP client for the [aglae.ai REST API](https://docs.aglae.ai/).

Authentication is done using a GCP service account JSON private key file that must be provided by the aglae.ai tech team.

## Usage

```bash
mvn clean compile assembly:single
java -jar target/vanilla-api-client-example-1.0-SNAPSHOT-jar-with-dependencies.jar [PATH_TO_JSON_PRIVATE_KEY]
```
