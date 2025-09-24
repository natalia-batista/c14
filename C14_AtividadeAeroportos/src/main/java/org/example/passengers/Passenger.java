package org.example.passengers;

import org.example.WebBanking.WebBanking;
import org.example.flight.FlightInfo;

import java.util.Random;

public class Passenger {
    private int passengerId;
    String passengerName;
    private int passengerAge;
    private Random ticketNumber = new Random();
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
    private boolean payment(WebBanking payment, double price){
        if(payment.getBalance() - price >= 0){
            return true;
        }
        return false;
    }

    public boolean buyTicket(WebBanking payment) {
        boolean ticketAvailable = this.flightInfo.canBuyTicket();
        boolean cash = this.payment(payment, this.flightInfo.getPrice());
        if (ticketAvailable && cash) {
            int ticketNb = ticketNumber.nextInt((flightInfo.getCapacity()) + 1);
            this.printTicket(ticketNb);
            return true;
        }
        return false;
    }

    private void printTicket(int ticketNb) {
        System.out.println("Ticket available");
        System.out.println("---------------------------------------------------------");
        System.out.println(this.flightInfo.toString());
        System.out.println("---------------------------------------------------------");
        System.out.println(this.toString());
        System.out.println("Ticket number: " + ticketNb);
    }

}
