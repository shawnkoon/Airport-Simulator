public abstract class Section
{
    private String compnay;
    private String ticketID;
    private int row;
    private int col;
    private String seatClass;

    public Section (String company, String ticketID, int row, int col, String seatClass)
    {
        this.compnay = company;
        this.ticketID = ticketID;
        this.row = row;
        this.col = col;
        this.seatClass = seatClass;
    }
}
