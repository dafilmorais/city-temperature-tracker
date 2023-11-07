package org.daniel;

import io.quarkus.kafka.client.serialization.ObjectMapperDeserializer;

public class CityDeserializer extends ObjectMapperDeserializer<City> {
    public CityDeserializer() {
        super(City.class);
    }
}
