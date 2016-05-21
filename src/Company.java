// This class maintains information about airlines. An airline can have 0 or more flights associated with it.
// When created an airline is not associated with any flights. All flights for a given airline must have unique flight ids.
public abstract class Company
{
    private String name;

    public Company(String name)
    {
        this.name = name;
    }
}