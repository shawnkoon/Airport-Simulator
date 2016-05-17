import java.util.ArrayList;

public class SystemManager 
{
   private TransportationFactory airportFactory;
   private ArrayList<Airport> airportList;
   private ArrayList<Airline> airlineList;

   public SystemManager()
   {
      this.airportList = new ArrayList<Airport>();
      this.airlineList = new ArrayList<Airline>();
      this.airportFactory = new AirportFactory();
   }
   
   private void createAirport(String code)
   {
      /* Call Airport.createAirport(code). - will return null if not satisfied.
      airportList.add(airport);
      */
   }
   
   private void createAirline(String name)
   {
      /* Call Airline.createAirline(name). - will return null if not satisfied.
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
