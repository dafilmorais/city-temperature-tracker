package org.daniel;


import jakarta.inject.Inject;
import org.eclipse.microprofile.reactive.messaging.Channel;
import org.eclipse.microprofile.reactive.messaging.Emitter;

public class KafkaProducer {
    @Inject
    @Channel("city-out")
    Emitter<City> emitter;

    //Logging
    public void sendCity(City city) {
        emitter.send(city);
    }
}