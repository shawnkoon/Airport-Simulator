import java.util.ArrayList;

public abstract class Section
{
    private String company;
    private String ticketID;
    private int row;
    private int col;
    private char layout;
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

        if(col <= Layout.SMALL.ordinal())
        {
            this.layout = 's';
        }
        else if(col > Layout.SMALL.ordinal() && col <= Layout.MEDIUM.ordinal())
        {
            this.layout = 'm';
        }
        else if(col > Layout.MEDIUM.ordinal() && col <= Layout.WIDE.ordinal())
        {
            this.layout = 'w';
        }
        else
        {
            this.layout = 'e';
        }
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

    protected boolean isPreferenceAvailable(String preference)
    {
        if(hasAvailableSeat() == false)
        {
            return false;
        }

        if(this.layout == 's')
        {
            for(Seat seat : seatList)
            {
                if(seat.getCol() <= Layout.SMALL.ordinal())
                {
                    if(seat.getCol() == 1 && preference.toLowerCase().equals("window"))
                    {
                        return true;
                    }
                    else if(seat.getCol() == Layout.SMALL.ordinal() && preference.toLowerCase().equals("aisle"))
                    {
                        return true;
                    }
                }
            }
        }

        return false;
    }
}