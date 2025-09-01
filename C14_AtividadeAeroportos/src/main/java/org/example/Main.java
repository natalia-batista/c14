package org.example;
import com.google.common.graph.*;

//https://github.com/google/guava/wiki/GraphsExplained#definitions.
//https://www.geeksforgeeks.org/software-engineering/class-diagram-for-airport-management-system/
public class Main {
    public static void main(String[] args) {

        MutableValueGraph<Airport, FlightInfo> graph = ValueGraphBuilder.undirected().allowsSelfLoops(true).build();
        Airport a1 = new Airport("GRU","Guarulhos","Brasil",-23.4325,-46.4694,14.5);
        Airport a2 = new Airport("CGH","Sao Paulo","Brasil",-23.626667,-46.657778,0.064579);
        Airport a3 = new Airport("Viracopos","Campinas","Brasil",-23.626667,-46.657778,0.064579);
        FlightInfo f12 = new FlightInfo(0,"Guarulhos-Congonhas", 35.6);
        FlightInfo f13 = new FlightInfo(1,"Guarulhos-Viracopos", 60);
        graph.addNode(a1);
        graph.putEdgeValue(a1,a2,f12);
        graph.putEdgeValue(a1,a3,f13);

        System.out.println("Airports: " + graph.nodes());
        System.out.println("Flights from GRU: " + graph.successors(a1));

    }
}