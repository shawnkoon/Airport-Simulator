public class AirportFactory implements TransportationFactory
{
    public AirportFactory()
    {

    }

    // Creates Airport object only if name is == 3 characters long.
    public Transport createTransport(String name)
    {
        if(name.length() == 3)
        {
            return new Airport(name);
        }
        else
        {
            return null;
        }
    }

    // Checks to see if name is 1 ~ 5 characters.
    public Company createCompany(String name)
    {
        if(name.length() < 6 && name.length() >= 1)
        {
            return new Airline(name);
        }
        else
        {
            return null;
        }
    }

    public Section createSection(String company, String ticketID, int row, int col, String seatClass)
    {
        return new FlightSection(company, ticketID, row, col, seatClass);
    }
}