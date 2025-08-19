package org.example;

public class FlightInfo {
    private int flightId;
    private String flightName;
    private Airline airline;
    private String capacity;
    private double duration;
    private double price;
    private double distance;

    public FlightInfo(int flightId, String flightName, Airline airline, String capacity, double duration, double price, double distance) {
        this.flightId = flightId;
        this.flightName = flightName;
        this.airline = airline;
        this.capacity = capacity;
        this.duration = duration;
        this.price = price;
        this.distance = distance;
    }

    public FlightInfo(int flightId, String flightName, double distance) {
        this.flightId = flightId;
        this.flightName = flightName;
        this.distance = distance;
    }
    @Override
    public String toString() {
        return "Flight Info [flightId=" + flightId + ",\n flightName=" + flightName + ",\n airlineName=" + airlineName +
                ",\n capacity=" + capacity + ",\n duration=" + duration + ",\n price=" + price + ",\n distance=" + distance + "]";
    }

}
