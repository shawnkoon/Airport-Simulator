public abstract class Transport {
    private String name;

    public Transport(String name)
    {
        this.name = name;
    }

    public String getName()
    {
        return this.name;
    }
}