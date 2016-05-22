public abstract class Path
{
    private String company;
    private String departure;
    private String destination;
    private int year;
    private int month;
    private int day;
    private String ticketID;

    public Path(String company, String departure, String destination, int year, int month, int day, String ticketID)
    {
        this.company = company;
        this.departure = departure;
        this.destination = destination;
        this.year = year;
        this.month = month;
        this.day = day;
        this.ticketID = ticketID;
    }

    public String getID()
    {
        return this.ticketID;
    }

    public String getDeparture()
    {
        return this.departure;
    }

    public String getDestination()
    {
        return this.destination;
    }
}
