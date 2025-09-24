import org.example.WebBanking.WebBanking;
import org.example.flight.FlightInfo;
import org.example.passengers.Passenger;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class PassengerTest {
    @Mock
    private WebBanking webBanking;

    @Test
    public void testBuyTicket() {
        FlightInfo f15 = new FlightInfo(0,"GRU-MAD",300,12,5000,1000,"LATAM Airlines","LATAM");
        Passenger passenger = new Passenger(123,"Natalia",20,f15);
        when(webBanking.getBalance()).thenReturn(10000.0);
        assertTrue(passenger.buyTicket(webBanking));
    }
    @Test
    public void testCantBuyTicketNoCapacity() {
        FlightInfo f15 = new FlightInfo(0,"GRU-MAD",0,12,5000,1000,"LATAM Airlines","LATAM");
        Passenger passenger = new Passenger(123,"Natalia",20,f15);
        when(webBanking.getBalance()).thenReturn(10000.0);
        assertFalse(passenger.buyTicket(webBanking));
    }
    @Test
    public void testCantBuyTicketNoBudget() {
        FlightInfo f15 = new FlightInfo(0,"GRU-MAD",100,12,5000,1000,"LATAM Airlines","LATAM");
        Passenger passenger = new Passenger(123,"Natalia",20,f15);
        when(webBanking.getBalance()).thenReturn(1000.0);
        assertFalse(passenger.buyTicket(webBanking));
    }
}
