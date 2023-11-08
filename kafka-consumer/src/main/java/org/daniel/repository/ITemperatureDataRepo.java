package org.daniel.repository;

import org.daniel.entities.TemperatureData;

public interface ITemperatureDataRepo {
    public void save(TemperatureData temperatureData);
}
