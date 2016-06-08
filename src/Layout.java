public enum Layout
{
    EMPTY(0),
    SMALL(3),
    MEDIUM(4),
    WIDE(10);

    private final int result;

    Layout(int value)
    {
        this.result = value;
    }
}
