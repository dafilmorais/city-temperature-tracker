package org.daniel;

import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;


@Path("/api/daniel-kafka")
@Produces(MediaType.APPLICATION_JSON)
public class KafkaResource {
    @Inject
    KafkaProducer producer;
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response send(City city) {
        producer.sendCity(city);
        // Return an 202 - Accepted response.
        return Response.accepted().build();
    }
}
