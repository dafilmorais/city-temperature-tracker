package org.daniel;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.json.Json;
import jakarta.json.JsonObject;
import org.apache.hc.client5.http.impl.classic.CloseableHttpClient;
import org.apache.hc.client5.http.impl.classic.CloseableHttpResponse;
import org.apache.hc.client5.http.impl.classic.HttpClients;
import org.apache.hc.core5.http.io.entity.EntityUtils;
import org.daniel.bo.CityData;
import org.eclipse.microprofile.config.inject.ConfigProperty;
import org.eclipse.microprofile.reactive.messaging.Channel;
import org.eclipse.microprofile.reactive.messaging.Emitter;
import io.quarkus.scheduler.Scheduled;
import org.apache.hc.client5.http.classic.methods.*;
import java.io.StringReader;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;


@ApplicationScoped
public class KafkaProducer {
    @Inject
    @Channel("city-out")
    Emitter<CityData> cityDataEmittermitter;
    @ConfigProperty(name = "openweather.api.key")
    private String apiKey;

    @Scheduled(every = "1m")
    public void getWeatherForTwoCities() {
            getWeatherForCity("Porto");
            getWeatherForCity("Lisbon");
    }

    private CityData getWeatherForCity(String city) {
        String apiUrl = "http://api.openweathermap.org/data/2.5/weather?q=" + city + "&appid=" + apiKey + "&units=metric";

        try (CloseableHttpClient httpClient = HttpClients.createDefault()) {
            HttpGet httpGet = new HttpGet(apiUrl);
            try (CloseableHttpResponse response = httpClient.execute(httpGet)) {
                if (response.getCode() == 200) {
                    String jsonResponse = EntityUtils.toString(response.getEntity());

                    JsonObject jsonObject = Json.createReader(new StringReader(jsonResponse)).readObject();
                    String name = jsonObject.getString("name");
                    String country = jsonObject.getJsonObject("sys").getString("country");
                    String temp = String.valueOf(jsonObject.getJsonObject("main").getJsonNumber("temp"));

                    String dateTime = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss"));
                    CityData cityData = new CityData(name, country, temp, dateTime);
                    System.out.println("["+ dateTime+ "] -> [REQUEST] Temperature in " + city + ": " + temp);
                    cityDataEmittermitter.send(cityData);
                    return cityData;
                } else {
                    System.err.println("Failed to fetch weather data for " + city + ". HTTP Status Code: " + response.getCode());
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}