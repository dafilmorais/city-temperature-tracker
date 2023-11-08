package org.daniel;

import io.quarkus.kafka.client.serialization.ObjectMapperDeserializer;
import org.daniel.bo.City;

public class CityDeserializer extends ObjectMapperDeserializer<City> {
    public CityDeserializer() {
        super(City.class);
    }
}
