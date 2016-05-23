import java.util.ArrayList;

public abstract class Company
{
    private String name;
    private ArrayList<Path> pathList;

    public Company(String name)
    {
        this.name = name;
        this.pathList = new ArrayList<Path>();
    }

    protected String getName()
    {
        return this.name;
    }

    protected Path getPath(String id)
    {
        Path res = null;

        if(this.pathList.size() == 0)
        {
            return res;
        }

        for(Path path : pathList)
        {
            if(path.getID().equals(id))
            {
                res = path;
                break;
            }
        }

        return res;
    }

    protected ArrayList<Path> getPathList()
    {
        return this.pathList;
    }

    protected void addPath(Path newPath)
    {
        this.pathList.add(newPath);
    }

    protected boolean idExist(String id)
    {
        boolean res = false;

        if(this.pathList.size() == 0)
        {
            return res;
        }

        for(Path path : pathList)
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