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
   
   public void createAirport(String code)
   {
      this.airportFactory.createTransport(code);
   }
   
   public void createAirline(String name)
   {
      this.airportFactory.createCompany(name);
   }
   
   public void createFlight(String company, String depart, String destination, int year, int month, int day, String ticketID)
   {
      this.airportFactory.createPath(company, depart, destination, year, month, day, ticketID);
   }
   
   public void createSection(String airline, String flightID, int row, int col, String seatClass)
   {
      this.airportFactory.createSection(airline, flightID, row, col, seatClass);
   }
   
   public void findAvailableFlights(String orig, String dest)
   {
      this.airportFactory.findAvailableSeats(orig, dest);
   }
   
   public void bookSeat(String airline, String flight, Seat seat, int row, char col)
   {
      /*Airline air = airlineList.get(airline);*/
   }
   
   public void displaySystemDetails()
   {
      
   }
}
