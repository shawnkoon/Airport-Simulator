/**
 * Created by wade on 6/7/2016.
 */
public class BoatLine extends Company
{
    public BoatLine(String name)
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
