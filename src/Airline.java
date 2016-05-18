// This class maintains information about airlines. An airline can have 0 or more flights associated with it.
// When created an airline is not associated with any flights. All flights for a given airline must have unique flight ids.
public class Airline {

    private String name;

    private Airline(String name)
    {
        this.name = name;
    }

    // Checks to see if name is 1 ~ 5 characters.
    public Airline createAirline(String name)
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
}
