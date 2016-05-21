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
}