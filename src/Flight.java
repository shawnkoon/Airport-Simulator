/**
 * Created by shawnkoon on 5/16/2016.
 */
//  This class maintains information about Flights.
//  A flight can be associated with 0 or more flight sections.
//  There can only be one flight section of particular seat class in flight.
//  e.g., only one business class and only one first class.
//  The seat classes are defined by the enumerator type SeatClass,
//  which defines the values, first, business, and economy.
public class Flight {

    private String name;
    private String orig;
    private String dest;
    private int year;
    private int month;
    private int day;
    private String id;

    public Flight(String name, String orig, String dest, int year, int month, int day, String id)
    {
        this.name = name;
        this.orig = orig;
        this.dest = dest;
        this.year = year;
        this.month = month;
        this.day = day;
        this.id = id;
    }

}
