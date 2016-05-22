public abstract class Path
{
    private String company;
    private String depart;
    private String destination;
    private int year;
    private int month;
    private int day;
    private String ticketID;

    public Path(String company, String depart, String destination, int year, int month, int day, String ticketID)
    {
        this.company = company;
        this.depart = depart;
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
}
