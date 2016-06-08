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
    private double price;

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

    public Section(String company, String ticketID, int row, int col, String seatClass, double price)
    {
        this.company = company;
        this.ticketID = ticketID;
        this.row = row;
        this.col = col;
        this.seatClass = seatClass;
        this.totalSeats = row * col;
        this.seatList = new ArrayList<Seat>();
        this.price = price;

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

        UtilManager utility = new UtilManager();

        if(this.layout == 's')
        {
            int count = 0;

            for(Seat seat : seatList)
            {
                if(utility.toInt(seat.getCol()) <= Layout.SMALL.getValue())
                {
                    if((utility.toInt(seat.getCol()) == 1 || utility.toInt(seat.getCol()) == Layout.SMALL.getValue()) && preference.toLowerCase().equals("window"))
                    {
                        count++;
                    }
                    else if(( utility.toInt(seat.getCol()) == 1 || utility.toInt(seat.getCol()) == Layout.SMALL.getValue()-1) && preference.toLowerCase().equals("aisle"))
                    {
                        count++;
                    }
                }
            }

            int windows = this.row * (Layout.SMALL.getValue()-1);

            if(count == windows)
            {
                return false;
            }
        }
        else if(this.layout == 'm')
        {
            int count = 0;

            for(Seat seat : seatList)
            {
                if(utility.toInt(seat.getCol()) <= Layout.MEDIUM.getValue())
                {
                    if((utility.toInt(seat.getCol()) == 1 || utility.toInt(seat.getCol()) == Layout.MEDIUM.getValue()) && preference.toLowerCase().equals("window"))
                    {
                        count++;
                    } else if((utility.toInt(seat.getCol()) == Layout.MEDIUM.getValue() - 2 || utility.toInt(seat.getCol()) == Layout.MEDIUM.getValue() - 1) && preference.toLowerCase().equals("aisle"))
                    {
                        count++;
                    }
                }
            }

            int windows = this.row * (Layout.MEDIUM.getValue() - 2);

            if(count == windows)
            {
                return false;
            }
        }
        else if(this.layout == 'w')
        {
            int count = 0;

            for(Seat seat : seatList)
            {
                if(utility.toInt(seat.getCol()) <= Layout.WIDE.getValue())
                {
                    if((utility.toInt(seat.getCol()) == 1 || utility.toInt(seat.getCol()) == Layout.WIDE.getValue()) && preference.toLowerCase().equals("window"))
                    {
                        count++;
                    } else if( ((utility.toInt(seat.getCol()) == Layout.WIDE.getValue() - 7) || (utility.toInt(seat.getCol()) == Layout.WIDE.getValue() - 6) ||
                            (utility.toInt(seat.getCol()) == Layout.WIDE.getValue() - 3) || (utility.toInt(seat.getCol()) == Layout.WIDE.getValue() - 2)) && preference.toLowerCase().equals("aisle"))
                    {
                        count++;
                    }
                }
            }

            int windows = this.row * (Layout.WIDE.getValue() - 6);

            if(count == windows)
            {
                return false;
            }
        }
        return true;
    }

    /*private int toInt(char col)
    {
        int result = -1;

        switch(Character.toLowerCase(col))
        {
            case 'a':
                result = 1;
            break;

            case 'b':
                result = 2;
            break;

            case 'c':
                result = 3;
            break;

            case 'd':
                result = 4;
            break;

            case 'e':
                result = 5;
            break;

            case 'f':
                result = 6;
            break;

            case 'g':
                result = 7;
            break;

            case 'h':
                result = 8;
            break;

            case 'i':
                result = 9;
            break;

            case 'j':
                result = 10;
            break;
        }

        return result;
    }*/

    protected int[] getAvailablePreference(String preference)
    {
        int[] result = new int[2];
        result[0] = -1;
        result[1] = -1;

        if(isPreferenceAvailable(preference) == false)
        {
            return result;
        }

        UtilManager utility = new UtilManager();

        if(this.layout == 's')
        {
            if(preference.toLowerCase().equals("window"))
            {
                if(this.seatList.size() < 1)
                {
                    result[0] = 1;
                    result[1] = 1;
                }

                for(int c = 1; c <= Layout.SMALL.getValue(); c += 2)
                {
                    for(int r = 1; r <= this.row; r++)
                    {
                        boolean check = false;

                        for(Seat seat : seatList)
                        {
                            if(utility.toInt(seat.getCol()) == c && seat.getRow() == r)
                            {
                                check = true;
                            }
                        }

                        if(check != true)
                        {
                            result[0] = r;
                            result[1] = c;

                            return result;
                        }
                    }
                }
            }
            else if(preference.toLowerCase().equals("aisle"))
            {
                if(this.seatList.size() < 1)
                {
                    result[0] = 1;
                    result[1] = 1;
                }

                for(int c = 1; c <= (Layout.SMALL.getValue()-1); c++)
                {
                    for(int r = 1; r <= this.row; r++)
                    {
                        boolean check = false;

                        for(Seat seat : seatList)
                        {
                            if(utility.toInt(seat.getCol()) == c && seat.getRow() == r)
                            {
                                check = true;
                            }
                        }

                        if(check != true)
                        {
                            result[0] = r;
                            result[1] = c;

                            return result;
                        }
                    }
                }
            }
        }
        else if(this.layout == 'm')
        {
            if(preference.toLowerCase().equals("window"))
            {
                if(this.seatList.size() < 1)
                {
                    result[0] = 1;
                    result[1] = 1;
                }

                for(int c = 1; c <= Layout.MEDIUM.getValue(); c += 3)
                {
                    for(int r = 1; r <= this.row; r++)
                    {
                        boolean check = false;

                        for(Seat seat : seatList)
                        {
                            if(utility.toInt(seat.getCol()) == c && seat.getRow() == r)
                            {
                                check = true;
                            }
                        }

                        if(check != true)
                        {
                            result[0] = r;
                            result[1] = c;

                            return result;
                        }
                    }
                }
            }
            else if(preference.toLowerCase().equals("aisle"))
            {
                if(this.seatList.size() < 1)
                {
                    result[0] = 2;
                    result[1] = 1;
                }

                for(int c = 2; c <= (Layout.MEDIUM.getValue()-1); c++)
                {
                    for(int r = 1; r <= this.row; r++)
                    {
                        boolean check = false;

                        for(Seat seat : seatList)
                        {
                            if(utility.toInt(seat.getCol()) == c && seat.getRow() == r)
                            {
                                check = true;
                            }
                        }

                        if(check != true)
                        {
                            result[0] = r;
                            result[1] = c;

                            return result;
                        }
                    }
                }
            }
        }
        else if(this.layout == 'w')
        {
            if(preference.toLowerCase().equals("window"))
            {
                if(this.seatList.size() < 1)
                {
                    result[0] = 1;
                    result[1] = 1;
                }

                for(int c = 1; c <= Layout.WIDE.getValue(); c += 9)
                {
                    for(int r = 1; r <= this.row; r++)
                    {
                        boolean check = false;

                        for(Seat seat : seatList)
                        {
                            if(utility.toInt(seat.getCol()) == c && seat.getRow() == r)
                            {
                                check = true;
                            }
                        }

                        if(check != true)
                        {
                            result[0] = r;
                            result[1] = c;

                            return result;
                        }
                    }
                }
            }
            else if(preference.toLowerCase().equals("aisle"))
            {
                if(this.seatList.size() < 1)
                {
                    result[0] = 3;
                    result[1] = 1;
                }

                for(int c = 3; c <= (Layout.WIDE.getValue()-2); c++)
                {
                    if(c == 3 || c == Layout.WIDE.getValue() - 6 || c == Layout.WIDE.getValue() - 3 || c == Layout.WIDE.getValue() - 2)
                    {
                        for(int r = 1; r <= this.row; r++)
                        {
                            boolean check = false;

                            for(Seat seat : seatList)
                            {
                                if(utility.toInt(seat.getCol()) == c && seat.getRow() == r)
                                {
                                    check = true;
                                }
                            }

                            if(check != true)
                            {
                                result[0] = r;
                                result[1] = c;

                                return result;
                            }
                        }
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

        UtilManager utility = new UtilManager();

        for(int c = 1; c <= this.col; c++)
        {
            for(int r = 1; r <= this.row; r++)
            {
                boolean check = false;

                for(Seat seat : seatList)
                {
                    if(utility.toInt(seat.getCol()) == c && seat.getRow() == r)
                    {
                        check = true;
                    }
                }

                if(check != true)
                {
                    result[0] = r;
                    result[1] = c;

                    return result;
                }
            }
        }

        return result;
    }
}