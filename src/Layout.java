public enum Layout
{
    EMPTY(0),
    SMALL(3),
    MEDIUM(4),
    WIDE(10);

    private final int result;

    public int getValue()
    {
        return this.result;
    }

    Layout(int value)
    {
        this.result = value;
    }
}
