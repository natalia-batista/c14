package org.example;
import com.google.common.graph.*;
import org.example.airport.Airport;
import org.example.flight.FlightInfo;

//https://github.com/google/guava/wiki/GraphsExplained#definitions.
//https://www.geeksforgeeks.org/software-engineering/class-diagram-for-airport-management-system/
public class Main {
    public static void main(String[] args) {

        MutableValueGraph<Airport, FlightInfo> graph = ValueGraphBuilder.undirected().allowsSelfLoops(true).build();
        Airport a1 = new Airport("GRU","Guarulhos","Brasil",-23.4325,-46.4694,14.5);
        Airport a2 = new Airport("/Confins –Tancredo Neves (CNF)","Confins","Brasil",-19,-43,0.132);
        Airport a3 = new Airport("Viracopos (VCP)","Campinas","Brasil",-23.626667,-46.657778,0.064579);
        Airport a4 = new Airport("Heathrow (LHR)", "Londres","Inglaterra",51.47,0.45,12.14);
        Airport a5 = new Airport("Adolfo Suárez/Madrid-Barajas (MAD)","Madrid","Espanha",40.4839361, -3.5679515,10);

        FlightInfo f15 = new FlightInfo(0,"GRU-MAD",300,12,5000,a1.distanceTo(a5),"LATAM Airlines","LATAM");
        FlightInfo f23 = new FlightInfo(1,"CNF-VCP",200, 2, 900, a3.distanceTo(a2),"Azul Linhas Aereas Brasileiras","Azul");
        FlightInfo f14 = new FlightInfo(2, "GRU-LHR",300,11,4000,a1.distanceTo(a4),"LATAM Airlines","LATAM");

        graph.addNode(a1);
        graph.addNode(a2);
        graph.addNode(a3);
        graph.addNode(a4);
        graph.addNode(a5);
        graph.putEdgeValue(a1,a2,f15);
        graph.putEdgeValue(a2,a3,f23);
        graph.putEdgeValue(a1,a4,f14);

        System.out.println("Airports: " + graph.nodes());
        System.out.println("Flights from GRU: " + graph.successors(a1));

    }
}