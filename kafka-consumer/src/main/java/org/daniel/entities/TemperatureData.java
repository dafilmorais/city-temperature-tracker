package org.daniel.entities;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import jakarta.persistence.Entity;

@Entity
public class TemperatureData extends PanacheEntity {

    public String name;
    public String country;
    public String temp;
    public String dateTime;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getTemp() {
        return temp;
    }

    public void setTemp(String temperature) {
        this.temp = temperature;
    }

    public String getTime() {
        return dateTime;
    }

    public void setTime(String dateTime) {
        this.dateTime = dateTime;
    }
}