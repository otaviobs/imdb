package br.com.setedayscode;

import java.io.IOException;
import java.net.URISyntaxException;
import java.net.http.HttpResponse;

public class InitializerApplication {
    public static void main(String[] args) throws URISyntaxException, IOException, InterruptedException {

        ApiImdb apiImdb = new ApiImdb("Top250Movies");
        ApiImdb apiImdb2 = new ApiImdb("Ratings","tt1375666");
        HttpResponse<String> response = apiImdb.callToApi();
        System.out.println(response.body());
    }
}
