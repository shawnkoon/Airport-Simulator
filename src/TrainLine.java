/**
 * Created by wade on 6/7/2016.
 */
public class TrainLine extends Company
{
    public TrainLine(String name)
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
