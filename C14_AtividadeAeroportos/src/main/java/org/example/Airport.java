package org.example;

public class Airport {
    private String name;
    private String city;
    private String country;
    private double latitude;
    private double longitude;
    private double area;

    public Airport(String name, String city, String country, double latitude, double longitude, double area) {
        this.name = name;
        this.city = city;
        this.country = country;
        this.latitude = latitude;
        this.longitude = longitude;
        this.area = area;
    }

    @Override
    public String toString() {
        return "\nAirport [name=" + name + ",\n city=" + city + ",\n country="
                + country + ",\n latitude=" + latitude + ",\n longitude=" + longitude + ",\n area=" + area + "]\n";
    }
}
