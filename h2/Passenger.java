package Homework09.h2;

public class Passenger {

    public String name;
    public int planned;
    public int visited;
    public boolean ticket;

    public Passenger(String name, int planned, boolean ticket) {
        this.name = name;
        this.planned = planned;
        this.ticket = ticket;
        this.visited = 0;
    }

}
