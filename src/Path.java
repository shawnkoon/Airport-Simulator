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

    protected String getID()
    {
        return this.ticketID;
    }

    protected String getCompany()
    {
        return this.company;
    }

    protected String getDeparture()
    {
        return this.departure;
    }

    protected String getDestination()
    {
        return this.destination;
    }

    protected int getYear()
    {
        return this.year;
    }

    protected int getMonth()
    {
        return this.month;
    }

    protected int getDay()
    {
        return this.day;
    }
}
