package org.daniel.services;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import org.daniel.entities.TemperatureData;
import org.daniel.repository.TemperatureDataRepo;

@ApplicationScoped
public class TemperatureService implements ITemperatureService {
    @Inject
    TemperatureDataRepo temperatureRepo;
    @Override
    @Transactional
    public void save(TemperatureData temperatureData){
        temperatureRepo.save(temperatureData);
    }
}
