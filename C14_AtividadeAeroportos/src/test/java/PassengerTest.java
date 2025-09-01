import org.example.flight.FlightInfo;
import org.example.passengers.Passenger;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class PassengerTest {

    @Test
    public void testBuyTicket() {
        FlightInfo f15 = new FlightInfo(0,"GRU-MAD",300,12,5000,1000,"LATAM Airlines","LATAM");
        Passenger passenger = new Passenger(123,"Natalia",20,f15);
        assertTrue(passenger.buyTicket());
    }
    @Test
    public void testCantBuyTicket() {
        FlightInfo f15 = new FlightInfo(0,"GRU-MAD",0,12,5000,1000,"LATAM Airlines","LATAM");
        Passenger passenger = new Passenger(123,"Natalia",20,f15);
        assertFalse(passenger.buyTicket());
    }
}
