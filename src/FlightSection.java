public class FlightSection extends Section
{
    public FlightSection(String company, String ticketID, int row, int col, String seatClass)
    {
        super(company, ticketID, row, col, seatClass);
    }

    public FlightSection(String company, String ticketID, int row, int col, String seatClass, double price)
    {
        super(company, ticketID, row, col, seatClass, price);
    }
}