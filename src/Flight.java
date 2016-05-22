public class Flight extends Path
{
    public Flight(String company, String depart, String destination, int year, int month, int day, String ticketID)
    {
        super(company, depart, destination, year, month, day, ticketID);
    }

    public String getDeparture()
    {
        return super.getDeparture();
    }

    public String getDestination()
    {
        return super.getDestination();
    }
}