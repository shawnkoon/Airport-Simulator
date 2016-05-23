public class Airline extends Company
{
    public Airline(String name)
    {
        super(name);
    }

    @Override
    public String toString()
    {
        String output = "\tCOMPANY\t\tDEPARTURE\t\tDESTINATION\n";

        for(Path path : super.getInstances())
        {
            output += path.toString() + "\n\n";
        }

        return output;
    }
}