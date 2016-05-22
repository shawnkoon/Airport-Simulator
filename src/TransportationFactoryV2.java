public interface TransportationFactoryV2
{
    //method sig to create a boarding station
    Transport createTransport(String name);

    //method sig to create travel company (i.e. Delta, Royal, etc.)
    Company createCompany(String name);

    //method sig to create a section
    Section createSection(String company, String ticketID, int row, int col, String seatClass);

    //method sig to create a travel path (FROM - TO)
    Path createPath(String company, String depart, String destination, int year, int month, int day, String ticketID);
}
