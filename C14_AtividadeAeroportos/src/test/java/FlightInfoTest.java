import org.example.airport.Airport;
import org.example.flight.FlightInfo;
import org.junit.Test;

import static org.junit.Assert.*;

public class FlightInfoTest {
    @Test
    public void testPricePerkm(){
        Airport a1 = new Airport("GRU","Guarulhos","Brasil",-23.4325,-46.4694,14.5);
        Airport a5 = new Airport("Adolfo Suárez/Madrid-Barajas (MAD)","Madrid","Espanha",40.4839361, -3.5679515,10);
        FlightInfo f15 = new FlightInfo(0,"GRU-MAD",300,12,5000,a1.distanceTo(a5),"LATAM Airlines","LATAM");

        double price = f15.getPrice()/f15.getDistance();
        double expPrice = f15.pricePerKm();
        assertEquals(price,expPrice,0.001);
    }
    @Test
    public void testPricePerkm2(){
        Airport a1 = new Airport("GRU","Guarulhos","Brasil",-23.4325,-46.4694,14.5);
        Airport a2 = new Airport("GRU","Guarulhos","Brasil",-23.4325,-46.4694,14.5);
        FlightInfo f11 = new FlightInfo(0,"GRU-GRU",0,0,0,a1.distanceTo(a1)," "," ");
        assertEquals(0,f11.pricePerKm(),0.001);
    }
    @Test(expected = RuntimeException.class)
    public void testPricePerkm3 (){
        FlightInfo f15 = new FlightInfo(0,"GRU-MAD",300,12,5000,-10,"LATAM Airlines","LATAM");
        f15.pricePerKm();
    }
    @Test
    public void testAverageSpeed(){
        Airport a1 = new Airport("GRU","Guarulhos","Brasil",-23.4325,-46.4694,14.5);
        Airport a5 = new Airport("Adolfo Suárez/Madrid-Barajas (MAD)","Madrid","Espanha",40.4839361, -3.5679515,10);
        FlightInfo f15 = new FlightInfo(0,"GRU-MAD",300,12,5000,a1.distanceTo(a5),"LATAM Airlines","LATAM");

        double speed = f15.getDistance()/ f15.getDuration();
        double expSpeed = f15.averageSpeed();
        assertEquals(speed,expSpeed,0.001);
    }
    @Test
    public void testAverageSpeed2(){
        Airport a1 = new Airport("GRU","Guarulhos","Brasil",-23.4325,-46.4694,14.5);
        FlightInfo f15 = new FlightInfo(0,"GRU-MAD",300,12,5000,a1.distanceTo(a1),"LATAM Airlines","LATAM");

        assertEquals(f15.averageSpeed(),0,0.001);
    }
    @Test(expected = RuntimeException.class)
    public void testAverageSpeed3 (){
        FlightInfo f15 = new FlightInfo(0,"GRU-MAD",300,0,5000,10,"LATAM Airlines","LATAM");
        f15.averageSpeed();
    }
    @Test
    public void testIsCheaperThan(){
        FlightInfo f15 = new FlightInfo(0,"GRU-MAD",300,12,5000,1000,"LATAM Airlines","LATAM");
        FlightInfo f12 = new FlightInfo(0,"GRU-MAD",300,12,4000,1000,"LATAM Airlines","LATAM");
        assertFalse(f15.isCheaperThan(f12));

    }
    @Test
    public void testIsNotCheaperThan(){
        FlightInfo f15 = new FlightInfo(0,"GRU-MAD",300,12,5000,1000,"LATAM Airlines","LATAM");
        FlightInfo f12 = new FlightInfo(0,"GRU-MAD",300,12,4000,1000,"LATAM Airlines","LATAM");
        assertTrue(f12.isCheaperThan(f15));
    }
    @Test
    public void testIsCheaperThanSamePrice(){
        FlightInfo f15 = new FlightInfo(0,"GRU-MAD",300,12,5000,1000,"LATAM Airlines","LATAM");
        assertFalse(f15.isCheaperThan(f15));

    }
    @Test
    public void testCanBuyTicket(){
        FlightInfo f12 = new FlightInfo(0,"GRU-MAD",300,12,5000,1000,"LATAM Airlines","LATAM");
        assertTrue(f12.canBuyTicket());
    }
    @Test
    public void testCannotBuyTicket(){
        FlightInfo f12 = new FlightInfo(0,"GRU-MAD",300,12,5000,1000,"LATAM Airlines","LATAM");
        f12.setCapacity(0);
        assertFalse(f12.canBuyTicket());
    }

}
