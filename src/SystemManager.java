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

   private int findCompanyIndex(String name)
   {
      int res = -1;

      for(Company cmp : this.airlineList)
      {
         res++;
         if(cmp.getName().equals(name))
         {
            break;
         }
      }

      return res;
   }
   
   public void createFlight(String company, String depart, String destination, int year, int month, int day, String ticketID)
   {
      if(hasAirline(company))
      {
         if(hasAirport(depart))
         {
            if(hasAirport(destination))
            {
               if(year > 0)
               {
                  if(month >= 1 && month <= 12)
                  {
                     // Sorry but we need to Advance not Enhance. So, I will be making Day cap to be 31.
                     if(day >= 1 && day <= 31)
                     {
                        if(airlineList.get(findCompanyIndex(company)).idExist(ticketID) == false)
                        {
                           airlineList.get(findCompanyIndex(company)).addPath(this.airportFactory.createPath(company, depart, destination, year, month, day, ticketID));
                        }
                        else
                           System.out.println("Request Error: ID ["+ticketID+"] already Exists.");
                     }
                     else
                        System.out.println("Request Error: Day ["+year+"] is not valid.");
                  }
                  else
                     System.out.println("Request Error: Month ["+month+"] is not valid.");
               }
               else
                  System.out.println("Request Error: Year ["+year+"] is not valid.");
            }
            else
               System.out.println("Request Error: Airport Name ["+destination+"] Doesn't Exists.");
         }
         else
            System.out.println("Request Error: Airport Name ["+depart+"] Doesn't Exists.");
      }
      else
         System.out.println("Request Error: Airline Name ["+company+"] Doesn't Exists.");
   }
   
   public void createSection(String airline, String flightID, int row, int col, String seatClass)
   {
      this.airportFactory.createSection(airline, flightID, row, col, seatClass);
   }
   
   public void findAvailableFlights(String departure, String destination)
   {
      if(hasAirport(departure) && hasAirport(destination))
      {
         for(Company airLine : this.airlineList)
         {
             ArrayList<Path> flightList = airLine.getInstances();

             for(Path flight : flightList)
             {
                 if (flight.getDeparture().equals(departure) && flight.getDestination().equals(destination))
                 {
                     System.out.println("==================== AVAILABLE FLIGHT ====================\n" + flight.toString());
                     System.out.println("\n==========================================================\n");
                 }
             }
         }
      }
      else
      {
        System.out.println("No available flights from " + departure.toUpperCase() + " to " + destination.toUpperCase());
      }
   }
   
   public void bookSeat(String airline, String flight, Seat seat, int row, String col)
   {
      /*Airline air = airlineList.get(airline);*/
   }
   
   public void displaySystemDetails()
   {
      
   }
}
