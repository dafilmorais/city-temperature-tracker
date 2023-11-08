package org.daniel.repository;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import org.daniel.entities.TemperatureData;

@ApplicationScoped
public class TemperatureDataRepo implements ITemperatureDataRepo {
    @Inject
    EntityManager em;

    @Override
    public void save(TemperatureData temperatureData){
        em.persist(temperatureData);
    }

}