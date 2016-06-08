public interface TransportationFactory
{
    Company createCompany(String name);

    Path createPath(String company, String depart, String destination, int year, int month, int day, String ticketID);

    Seat createSeat(int row, char col);

    Section createSection(String company, String ticketID, int row, int col, String seatClass);

    Section createSection2(String company, String ticketID, char layout, int row, String seatClass, double price);

    Transport createTransport(String name);
}