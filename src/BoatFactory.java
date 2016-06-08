public class BoatFactory implements TransportationFactory
{
    public BoatFactory()
    {

    }

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

    public Path createPath(String company, String depart, String destination, int year, int month, int day, String ticketID)
    {
        return new Flight(company, depart, destination, year, month, day, ticketID);
    }

    public Seat createSeat(int row, char col)
    {
        return new Seat(row, col);
    }

    public Section createSection(String company, String ticketID, int row, int col, String seatClass)
    {
        return new FlightSection(company, ticketID, row, col, seatClass);
    }

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
}