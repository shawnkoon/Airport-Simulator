import java.util.ArrayList;

public abstract class Company
{
    private String name;
    private ArrayList<Path> instances;

    public Company(String name)
    {
        this.name = name;
        instances = new ArrayList<Path>();
    }

    public String getName()
    {
        return this.name;
    }

    public void addPath(Path newPath)
    {
        instances.add(newPath);
    }

    public boolean idExist(String id)
    {
        boolean res = false;

        for(Path path : instances)
        {
            if(path.getID().equals(id))
            {
                res = true;
                break;
            }
        }

        return res;
    }
}