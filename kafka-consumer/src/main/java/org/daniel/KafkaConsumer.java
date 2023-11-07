package org.daniel;

import jakarta.enterprise.context.ApplicationScoped;
import org.eclipse.microprofile.reactive.messaging.Incoming;

@ApplicationScoped
public class KafkaConsumer {
    @Incoming("city-in")
    public City receive(City city) {
        System.out.println("Received city: " + city.toString());

        //Do something with the post
        //...

        return city;
    }
}