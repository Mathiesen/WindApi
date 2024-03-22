package org.example;

import com.google.gson.*;
import com.google.maps.errors.ApiException;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class Main {
    public static void main(String[] args) throws URISyntaxException, IOException, InterruptedException, ApiException {
        HttpClient client = HttpClient.newBuilder().build();

        // Create http request
       HttpRequest request = HttpRequest
                .newBuilder()
                .uri(new URI("https://vind-og-klima-app.videnomvind.dk/api/stats?location=vindtved"))
                .GET()
                .build();

        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

        Gson gson = new Gson();
        JsonObject jObj = JsonParser.parseString(response.body()).getAsJsonObject();
        LatestReading reading = gson.fromJson(jObj.get("latest_reading").toString(), LatestReading.class);

        System.out.println(reading.data.turbines);

        for (String s : reading.data.turbines.keySet()) {
            System.out.println(s);
        }


        reading.data.turbines.put("8", 1200);
        reading.data.turbines.put("9", 1500);
        System.out.println(reading.data.turbines.get("8"));
    }
}