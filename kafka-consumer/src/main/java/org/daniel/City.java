package org.daniel;

public class City {
    public String name;
    public String country;
    public float temperature;

    public City(String name, String country, float temperature) {
        this.name = name;
        this.country = country;
        this.temperature = temperature;
    }

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

    public float getTemperature() {
        return temperature;
    }

    public void setTemperature(float temperature) {
        this.temperature = temperature;
    }

    @Override
    public String toString() {
        return "City{" +
                "name='" + name + '\'' +
                ", country='" + country + '\'' +
                ", temperature='" + temperature + '\'' +
                '}';
    }
}