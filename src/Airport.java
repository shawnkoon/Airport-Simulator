/**
 * Created by shawnkoon on 5/16/2016.
 */
// Objects of this class represent airports.
// The only information maintained is the name, which must be exactly 3 characters in length.
public class Airport {
    private String name;

    private Airport(String name)
    {
        this.name = name;
    }

    // Creates Airport object only if name is == 3 characters long.
    public Airport createAirport(String name)
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
