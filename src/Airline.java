public class Airline extends Company
{
    public Airline(String name)
    {
        super(name);
    }

    @Override
    public String toString()
    {
        String output = "";

        for(Path path : super.getPathList())
        {
            output += path.toString() + "\n\t----------------------------------------\n";
        }

        return output;
    }
}