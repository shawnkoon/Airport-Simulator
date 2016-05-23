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

      if(this.airportList.size() == 0)
         return res;

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

      if(this.airlineList.size() == 0)
         return res;

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

      if(this.airlineList.size() == 0)
         return res;

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

    public void createSection(String airline, String flightID, int row, int col, SeatClass seatClass)
    {

      if(hasAirline(airline))
      {
         if(airlineList.get(findCompanyIndex(airline)).idExist(flightID))
         {
            if(airlineList.get(findCompanyIndex(airline)).getPath(flightID).hasSection(seatClass.toString()) == false)
            {
               airlineList.get(findCompanyIndex(airline)).getPath(flightID).addSection(this.airportFactory.createSection(airline, flightID, row, col, seatClass.toString()));
            }
            else
            {
               System.out.println("Request Error: Seat Class ["+seatClass+"] Already Exists.");
            }
         }
         else
         {
            System.out.println("Request Error: ID ["+flightID+"] Doesn't Exists.");
         }
      }
      else
      {
         System.out.println("Request Error: Airline Name ["+airline+"] Doesn't Exists.");
      }
    }

    public void findAvailableFlights(String departure, String destination)
    {
        boolean selectAll = false;

        if(departure.equals("*") && destination.equals("*"))
        {
            selectAll = true;
        }

        if (( hasAirport(departure) && hasAirport(destination) ) || selectAll == true)
        {
            for (Company airLine : this.airlineList)
            {
                ArrayList<Path> flightList = airLine.getInstances();

                for (Path flight : flightList)
                {
                    if ((flight.getDeparture().equals(departure) && flight.getDestination().equals(destination)) || selectAll == true)
                    {
                        System.out.println("==================== AVAILABLE FLIGHT ====================\n" + ((Flight) flight).printInfo());
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

    public void bookSeat(String airline, String flightID, SeatClass seatClass, int row, char col)
    {
        if(hasAirline(airline))
        {
            if(airlineList.get(findCompanyIndex(airline)).idExist(flightID))
            {
                Path currentPath = airlineList.get(findCompanyIndex(airline)).getPath(flightID);

                if(currentPath.hasSection(seatClass.toString()))
                {
                    if(currentPath.getSection(seatClass.toString()).isSeatAvailable(row, col))
                    {
                        Section currentSection = currentPath.getSection(seatClass.toString());

                        currentSection.bookSeat(this.airportFactory.createSeat(row, col));
                    }
                    else
                    {
                        System.out.println("Request Error: The Seat ["+row+","+col+"] is currently Unavailable.");
                    }
                }
                else
                {
                    System.out.println("Request Error: Seat Class ["+seatClass+"] Doesn't Exists.");
                }
            }
            else
            {
                System.out.println("Request Error: ID ["+flightID+"] Doesn't Exists.");
            }
        }
        else
        {
            System.out.println("Request Error: Airline Name ["+airline+"] Doesn't Exists.");
        }
    }

    public void displaySystemDetails()
    {
        System.out.println("==================== AIRPORTS ====================\n");

        for(Transport airport : airportList)
        {
            String name = airport.getName();
            System.out.println("* " + name);
        }

        System.out.println("==================================================\n");

        System.out.println("==================== AIRLINES ====================\n");

        for(Company airline : airlineList)
        {
            Airline currentAirline = (Airline) airline;
            System.out.println(currentAirline.toString());
        }

        System.out.println("==================================================\n");

        this.findAvailableFlights("*", "*");
    }
}