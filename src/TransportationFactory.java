public interface TransportationFactory
{
   //method sig to create a boarding station
    Transport createTransport(String name);
   
   //method sig to create travel company (i.e. Delta, Royal, etc.)
    Company createCompany(String name);
   
   //method sig to create a section
    Section createSection(String company, String ticketID, int row, int col, String seatClass);

   //method sig to create a travel path (FROM - TO)
   
   //method sig to display system details
   
   //method sig to find all available seats

}