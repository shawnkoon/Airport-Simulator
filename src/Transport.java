public abstract class Transport {
    private String name;

    public Transport(String name)
    {
        this.name = name;
    }

    protected String getName()
    {
        return this.name;
    }
}