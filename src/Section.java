import java.util.ArrayList;

public abstract class Section
{
    private String company;
    private String ticketID;
    private int row;
    private int col;
    private String seatClass;
    private int totalSeats;
    private ArrayList<Seat> seatList;

    public Section(String company, String ticketID, int row, int col, String seatClass)
    {
        this.company = company;
        this.ticketID = ticketID;
        this.row = row;
        this.col = col;
        this.seatClass = seatClass;
        this.totalSeats = row * col;
        this.seatList = new ArrayList<Seat>();
    }

    protected String getSeatClass()
    {
        return this.seatClass;
    }

    protected void bookSeat(Seat seat)
    {
        this.seatList.add(seat);
    }

    protected boolean hasAvailableSeat()
    {
        return (seatList.size() != this.totalSeats);

    }

    protected boolean isSeatAvailable(int row, char col)
    {
        if(hasAvailableSeat() == false)
        {
            return false;
        }
        else
        {
            for(Seat seat : seatList)
            {
                if(seat.getRow() == row && seat.getCol() == col)
                {
                    return false;
                }
            }

            return true;
        }
    }
}