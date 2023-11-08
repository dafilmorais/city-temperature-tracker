package org.daniel;

import io.smallrye.mutiny.Uni;
import io.smallrye.mutiny.infrastructure.Infrastructure;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import org.daniel.bo.City;
import org.daniel.entities.TemperatureData;
import org.daniel.services.TemperatureService;
import org.eclipse.microprofile.reactive.messaging.Incoming;

@ApplicationScoped
public class KafkaConsumer {
    @Inject
    TemperatureService temperatureService;
    @Incoming("city-in")
    public Uni<City> receive(City city) {
        System.out.println("Received city: " + city.toString());

        /* I do it like this because this is an asynchronous process. I process the kafka message
        * without blocking the current thread */
        return Uni.createFrom().item(() -> {
            TemperatureData temperatureData = new TemperatureData();
            temperatureData.setCountry("Portugal");
            temperatureData.setName("Porto");
            temperatureData.setTemp(21.5);
            temperatureData.setTime("11:59:662");
            temperatureService.save(temperatureData);

            return city;
        }).runSubscriptionOn(Infrastructure.getDefaultWorkerPool());
    }
}