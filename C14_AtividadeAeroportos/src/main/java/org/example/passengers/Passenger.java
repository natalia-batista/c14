package org.example.passengers;

import org.example.flight.FlightInfo;

import java.util.Random;

public class Passenger {
    int passengerId;
    String passengerName;
    int passengerAge;
    Random ticketNumber = new Random();
    FlightInfo flightInfo;

    public Passenger(int passengerId, String passengerName, int passengerAge, FlightInfo flightInfo) {
        this.passengerId = passengerId;
        this.passengerName = passengerName;
        this.passengerAge = passengerAge;
        this.flightInfo = flightInfo;
    }

    @Override
    public String toString() {
        return "\nPassenger [name=" + passengerName + ",\n id=" + passengerId + ",\n age="
                + passengerAge;
    }

    public boolean buyTicket() {
        boolean ticketAvailable = this.flightInfo.canBuyTicket();
        if (ticketAvailable) {
            int ticketNb = ticketNumber.nextInt((flightInfo.getCapacity()) + 1);
            this.printTicket(ticketNb);
            return true;
        }
        return false;
    }

    public void printTicket(int ticketNb) {
        System.out.println("Ticket available");
        System.out.println("---------------------------------------------------------");
        System.out.println(this.flightInfo.toString());
        System.out.println("---------------------------------------------------------");
        System.out.println(this.toString());
        System.out.println("Ticket number: " + ticketNb);
    }

}
