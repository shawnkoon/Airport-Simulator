public interface TransportationFactory
{
    Company createCompany(String name);

    Path createPath(String company, String depart, String destination, int year, int month, int day, String ticketID);

    Seat createSeat(int row, char col);

    Section createSection(String company, String ticketID, int row, int col, String seatClass);

    Transport createTransport(String name);
}