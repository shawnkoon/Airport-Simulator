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

        if(col <= Layout.SMALL.getValue())
        {
            this.layout = 's';
        }
        else if(col > Layout.SMALL.getValue() && col <= Layout.MEDIUM.getValue())
        {
            this.layout = 'm';
        }
        else if(col > Layout.MEDIUM.getValue() && col <= Layout.WIDE.getValue())
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
                if(seat.getCol() <= Layout.SMALL.getValue())
                {
                    if(seat.getCol() == 1 && preference.toLowerCase().equals("window"))
                    {
                        return true;
                    }
                    else if(seat.getCol() == Layout.SMALL.getValue() && preference.toLowerCase().equals("aisle"))
                    {
                        return true;
                    }
                }
            }

            return true;
        }

        return false;
    }

    protected int[] getAvailablePreference(String preference)
    {
        int[] result = new int[2];
        result[0] = -1;
        result[1] = -1;

        if(isPreferenceAvailable(preference) == false)
        {
            return result;
        }

        if(this.layout == 's')
        {
            for(Seat seat : seatList)
            {
                if(seat.getCol() <= Layout.SMALL.getValue())
                {
                    if((seat.getCol() == 1 || seat.getCol() == Layout.SMALL.getValue()) && preference.toLowerCase().equals("window"))
                    {
                        result[0] = seat.getRow();
                        result[1] = seat.getCol();

                        return result;
                    }
                    else if((seat.getCol() == Layout.SMALL.getValue()-1 || seat.getCol() == Layout.SMALL.getValue()) && preference.toLowerCase().equals("aisle"))
                    {
                        result[0] = seat.getRow();
                        result[1] = seat.getCol();

                        return result;
                    }
                }
            }
        }
        else if(this.layout == 'm')
        {
            for(Seat seat : seatList)
            {
                if(seat.getCol() <= Layout.MEDIUM.getValue())
                {
                    if((seat.getCol() == 1 || seat.getCol() == Layout.MEDIUM.getValue()) && preference.toLowerCase().equals("window"))
                    {
                        result[0] = seat.getRow();
                        result[1] = seat.getCol();

                        return result;
                    }
                    else if((seat.getCol() == Layout.MEDIUM.getValue()-2 || seat.getCol() == Layout.MEDIUM.getValue()-1) && preference.toLowerCase().equals("aisle"))
                    {
                        result[0] = seat.getRow();
                        result[1] = seat.getCol();

                        return result;
                    }
                }
            }
        }
        else if(this.layout == 'w')
        {
            for(Seat seat : seatList)
            {
                if(seat.getCol() <= Layout.WIDE.getValue())
                {
                    if((seat.getCol() == 1 || seat.getCol() == Layout.WIDE.getValue()) && preference.toLowerCase().equals("window"))
                    {
                        result[0] = seat.getRow();
                        result[1] = seat.getCol();

                        return result;
                    }
                    else if((seat.getCol() == Layout.WIDE.getValue()-7 || seat.getCol() == Layout.WIDE.getValue()-6 ||
                             seat.getCol() == Layout.WIDE.getValue()-3 || seat.getCol() == Layout.WIDE.getValue()-2) && preference.toLowerCase().equals("aisle"))
                    {
                        result[0] = seat.getRow();
                        result[1] = seat.getCol();

                        return result;
                    }
                }
            }
        }

        return result;
    }

    protected int[] getAvailableSeat()
    {
        int[] result = new int[2];
        result[0] = -1;
        result[1] = -1;

        for(Seat seat : seatList)
        {
            if(seat.getBookStatus() == false)
            {
                result[0] = seat.getRow();
                result[1] = seat.getCol();

                return result;
            }
        }

        return result;
    }
}