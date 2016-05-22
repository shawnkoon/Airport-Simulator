import java.util.ArrayList;

public class SystemManager 
{
   private TransportationFactory airportFactory;
   private ArrayList<Transport> airportList;
   private ArrayList<Company> airlineList;

   public SystemManager()
   {
      this.airportList = new ArrayList<Transport>();
      this.airlineList = new ArrayList<Company>();
      this.airportFactory = new AirportFactory();
   }
   
   public void createAirport(String code)
   {
      if(hasAirport(code) == false)
      {
         Transport airport = this.airportFactory.createTransport(code);

         if(airport == null)
         {
            System.out.println("Request Error : Airport name has to be Three Characters long.");
         }
         else
         {
            airportList.add(airport);
         }
      }
      else
      {
         System.out.println("Request Error : Airport Name ["+code+"] Already Exists.");
      }
   }

   private boolean hasAirport(String code)
   {
      boolean res = false;

      for(Transport tp : this.airportList)
      {
         if(tp.getName().equals(code))
         {
            res = true;
            break;
         }
      }

      return res;
   }
   
   public void createAirline(String name)
   {
      if(hasAirline(name) == false)
      {
         Company comp = this.airportFactory.createCompany(name);

         if(comp == null)
         {
            System.out.println("Request Error : Airline name has to be One to Five Characters long.");
         }
         else
         {
            airlineList.add(comp);
         }
      }
      else
      {
         System.out.println("Request Error: Airline Name ["+name+"] Already Exists.");
      }
   }

   private boolean hasAirline(String name)
   {
      boolean res = false;

      for(Company cmp : this.airlineList)
      {
         if(cmp.getName().equals(name))
         {
            res = true;
            break;
         }
      }

      return res;
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
   
   public void bookSeat(String airline, String flight, Seat seat, int row, String col)
   {
      /*Airline air = airlineList.get(airline);*/
   }
   
   public void displaySystemDetails()
   {
      
   }
}
