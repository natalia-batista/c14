import org.example.airport.Airport;
import org.junit.Test;

import static org.junit.Assert.*;

public class AirportTest {

    @Test
    public void testDistanceTo(){
        Airport a1 = new Airport("GRU","Guarulhos","Brasil",-23.4325,-46.4694,14.5);
        Airport a2 = new Airport("/Confins –Tancredo Neves (CNF)","Confins","Brasil",-19,-43,0.132);
        double x = a1.getLatitude() - a2.getLatitude();
        double y = a1.getLongitude() - a2.getLongitude();
        double distance = Math.sqrt(x * x + y * y);
        assertEquals(a1.distanceTo(a2),distance,0.001);
    }
    @Test
    public void testDistanceToIsReciprocal(){
        Airport a1 = new Airport("GRU","Guarulhos","Brasil",-23.4325,-46.4694,14.5);
        Airport a2 = new Airport("/Confins –Tancredo Neves (CNF)","Confins","Brasil",-19,-43,0.132);
        assertEquals(a2.distanceTo(a1),a1.distanceTo(a2),0.001);
    }
    @Test
    public void testIsSameCountry(){
        Airport a1 = new Airport("GRU","Guarulhos","Brasil",-23.4325,-46.4694,14.5);
        Airport a2 = new Airport("/Confins –Tancredo Neves (CNF)","Confins","Brasil",-19,-43,0.132);
        assertTrue(a1.isSameCountry(a2));
    }
    @Test
    public void testIsNotSameCountry(){
        Airport a1 = new Airport("Viracopos (VCP)","Campinas","Brasil",-23.626667,-46.657778,0.064579);
        Airport a2 = new Airport("Heathrow (LHR)", "Londres","Inglaterra",51.47,0.45,12.14);
        assertFalse(a2.isSameCountry(a1));
    }

}
