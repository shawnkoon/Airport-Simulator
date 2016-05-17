import java.util.ArrayList;

public class SystemManager 
{
   private ArrayList<Airport> airportList;
   private ArrayList<Airline> airlineList;

   public SystemManager()
   {
      this.airportList = new ArrayList<Airport>();
      this.airlineList = new ArrayList<Airline>();
   }
   
   private void createAirport(String code)
   {
      /*Airport airport = new Airport(...);
      airportList.add(airport);
      */
   }
   
   private void createAirline(String name)
   {
      /*Airline airline = new Airline(...);
      airlineList.add(airline);
      */
   }
   
   private void createFlight(String airportName, String orig, String dest, 
                             int year, int month, int day, String id
                             )
   {
      
   }
   
   private void createSection(String airline, String flightID, int row, int col, Seat s)
   {
   
   }
   
   private void findAvailableFlights(String orig, String dest)
   {
      /*for(Airport airport : airportList) { } */
   }
   
   private void bookSeat(String airline, String flight, Seat seat, int row, char col)
   {
      /*Airline air = airlineList.get(airline);*/
   }
   
   private void displaySystemDetails()
   {
      
   }
}
