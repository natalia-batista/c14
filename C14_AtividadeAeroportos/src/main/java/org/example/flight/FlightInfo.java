package org.example.flight;

import org.example.airline.Airline;

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

    public double pricePerKm() throws RuntimeException {
        if (this.distance > 0){
            return this.price / this.distance;
        }
        throw new RuntimeException("Distance is negative");
    }



    public double averageSpeed() throws RuntimeException {
        if (this.duration > 0){
            return this.distance / this.duration;
        }
        throw new RuntimeException("Distance is negative"); //CRIAR UMA EXCEPTION
    }

    public boolean isCheaperThan(FlightInfo other) {
        return this.price < other.price;
    }

    public boolean canBuyTicket() {
        if (this.capacity > 0) {
            this.capacity--;
            return true; // sucesso
        } else {
            return false; // sem assentos
        }
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public int getCapacity() {
        return capacity;
    }

    public double getDuration() {
        return duration;
    }

    public double getPrice() {
        return price;
    }

    public double getDistance() {
        return distance;
    }
}
