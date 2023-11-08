package org.daniel;


import io.quarkus.kafka.client.serialization.ObjectMapperDeserializer;
import org.daniel.bo.CityData;

public class CityDeserializer extends ObjectMapperDeserializer<CityData> {
    public CityDeserializer() {
        super(CityData.class);
    }
}
