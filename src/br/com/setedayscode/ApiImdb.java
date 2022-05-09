package br.com.setedayscode;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ApiImdb {
    final String apiKey = "";
    private URI uri;

    public ApiImdb(String subject, String id) throws URISyntaxException {
        this.uri = new URI("https://imdb-api.com/en/API/"+subject+"/"+apiKey+"/"+id+"");
    }
    public ApiImdb(String subject) throws URISyntaxException {
        this.uri = new URI("https://imdb-api.com/en/API/"+subject+"/"+apiKey);
    }

    public HttpResponse<String> callToApi() throws IOException, InterruptedException {
        return HttpClient.newHttpClient()
                .send(this.request(), HttpResponse.BodyHandlers.ofString());
    }
    private HttpRequest request(){
        return HttpRequest
                .newBuilder()
                .uri(this.uri)
                .GET()
                .build();

    }
}
