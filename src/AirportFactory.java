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
    public Company createAirline(String name)
    {
        if(name.length() < 6 && name.length() >= 1)
        {
            return new Company(name);
        }
        else
        {
            return null;
        }
    }
}