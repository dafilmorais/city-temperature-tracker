package org.daniel.bo;

public class CityData {
    public String name;
    public String country;
    public String temp;
    public String dateTime;

    public CityData(String name, String country, String temp, String dateTime) {
        this.name = name;
        this.country = country;
        this.temp = temp;
        this.dateTime = dateTime;
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

    public String getTemperature() {
        return temp;
    }

    public void setTemperature(String temperature) {
        this.temp = temperature;
    }

    public String getDateTime() {
        return dateTime;
    }

    public void setDateTime(String dateTime) {
        this.dateTime = dateTime;
    }

    @Override
    public String toString() {
        return "City{" +
                "name='" + name + '\'' +
                ", country='" + country + '\'' +
                ", temperature='" + temp + '\'' +
                ", dateTime='" + dateTime + '\'' +
                '}';
    }
}