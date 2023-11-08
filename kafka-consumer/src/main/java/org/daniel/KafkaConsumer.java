package org.daniel;

import io.smallrye.mutiny.Uni;
import io.smallrye.mutiny.infrastructure.Infrastructure;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import org.daniel.bo.CityData;
import org.daniel.entities.TemperatureData;
import org.daniel.services.TemperatureService;
import org.eclipse.microprofile.reactive.messaging.Incoming;

@ApplicationScoped
public class KafkaConsumer {
    @Inject
    TemperatureService temperatureService;
    @Incoming("city-in")
    public Uni<CityData> receive(CityData city) {
        System.out.println("[RECIEVED] : " + city.toString());

        /* I do it like this because this is an asynchronous process. I process the kafka message
        * without blocking the current thread */
        return Uni.createFrom().item(() -> {
            TemperatureData temperatureData = new TemperatureData();
            temperatureData.setCountry(city.getCountry());
            temperatureData.setName(city.getName());
            temperatureData.setTemp(city.getTemperature());
            temperatureData.setTime(city.getDateTime());
            temperatureService.save(temperatureData);

            return city;
        }).runSubscriptionOn(Infrastructure.getDefaultWorkerPool());
    }
}