package org.example;

public class FlightInfo {
    private int flightId;
    private String flightName;
    private int capacity;
    private double duration;
    private double price;
    private double distance;

    public FlightInfo(int flightId, String flightName, int capacity, double duration, double price, double distance,
                      String airlineName, String airlineCode) {
        this.flightId = flightId;
        this.flightName = flightName;
        Airline airline = new Airline(airlineName,airlineCode);
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
        return "Flight Info [flightId=" + flightId + ",\n flightName=" + flightName +
                ",\n capacity=" + capacity + ",\n duration=" + duration + ",\n price=" + price + ",\n distance=" + distance + "]";
    }

    public double pricePerKm() {
        if (this.distance > 0){
            return this.price / this.distance;
        }
        return 0;
    }

    public double averageSpeed() {
        if (this.duration > 0){
            return this.distance / this.duration;
        }
        return 0;
    }

    public boolean isCheaperThan(FlightInfo other) {
        return this.price < other.price;
    }

}
