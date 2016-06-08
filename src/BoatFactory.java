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

    public Path createPath(String company, String depart, String destination, int year, int month, int day, int hour, int min, String ticketID)
    {
        return new Flight(company, depart, destination, year, month, day, hour, min, ticketID);
    }

    public Seat createSeat(int row, char col)
    {
        return new Seat(row, col);
    }

    public Section createSection(String company, String ticketID, int row, int col, String seatClass)
    {
        return new FlightSection(company, ticketID, row, col, seatClass);
    }

    public Section createSection2(String company, String ticketID, char layout, int row, String seatClass, double price)
    {
        layout = Character.toLowerCase(layout);

        if(layout == 's')
        {
            return new FlightSection(company, ticketID, row, Layout.SMALL.ordinal(), seatClass);
        }
        else if(layout == 'm')
        {
            return new FlightSection(company, ticketID, row, Layout.MEDIUM.ordinal(), seatClass);
        }
        else if(layout == 'w')
        {
            return new FlightSection(company, ticketID, row, Layout.WIDE.ordinal(), seatClass);
        }
        else
        {
            return new FlightSection(company, ticketID, row, Layout.EMPTY.ordinal(), seatClass);
        }
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
