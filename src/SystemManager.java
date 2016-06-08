import java.time.YearMonth;
import java.util.ArrayList;
import java.util.Calendar;

public class SystemManager
{
    private TransportationFactory airportFactory;
    private ArrayList<Transport> airportList;
    private ArrayList<Company> airlineList;
    private FileUtilManager fileManager;

    public SystemManager()
    {
        this.airportList = new ArrayList<Transport>();
        this.airlineList = new ArrayList<Company>();
        this.airportFactory = new AirportFactory();

        this.fileManager = new FileUtilManager();
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
                        System.out.println("The seat is currently unavailable.");
                    }
                }
                else
                {
                    System.out.println("The section does not exist.");
                }
            }
            else
            {
                System.out.println("No matching flight ID found.");
            }
        }
        else
        {
            System.out.println("No such flight exists.");
        }
    }

    private char toChar(int col)
    {
        char result = 'k';

        switch(col)
        {
            case 1:
                result = 'a';
            break;

            case 2:
                result = 'b';
            break;

            case 3:
                result = 'c';
            break;

            case 4:
                result = 'd';
            break;

            case 5:
                result = 'e';
            break;

            case 6:
                result = 'f';
            break;

            case 7:
                result = 'g';
            break;

            case 8:
                result = 'h';
            break;

            case 9:
                result = 'i';
            break;

            case 10:
                result = 'j';
            break;
        }

        return result;
    }

    public void bookSeat(String airline, String flightID, SeatClass seatClass, String preference)
    {
        if(hasAirline(airline))
        {
            if(airlineList.get(findCompanyIndex(airline)).idExist(flightID))
            {
                Path currentPath = airlineList.get(findCompanyIndex(airline)).getPath(flightID);

                if(currentPath.hasSection(seatClass.toString()))
                {
                    if(currentPath.getSection(seatClass.toString()).isPreferenceAvailable(preference))
                    {
                        Section currentSection = currentPath.getSection(seatClass.toString());

                        int[] opening = currentPath.getSection(seatClass.toString()).getAvailablePreference(preference);

                        if(opening[0] != -1 && opening[1] != -1)
                        {
                            currentSection.bookSeat(this.airportFactory.createSeat(opening[0], this.toChar(opening[1])));
                        }
                        else
                        {
                            System.out.println("The seat is currently unavailable.");
                        }
                    }
                    else
                    {
                        Section currentSection = currentPath.getSection(seatClass.toString());

                        int[] opening = currentPath.getSection(seatClass.toString()).getAvailableSeat();

                        if(opening[0] != -1 && opening[1] != -1)
                        {
                            currentSection.bookSeat(this.airportFactory.createSeat(opening[0], this.toChar(opening[1])));
                            System.out.println("Could not find your preference, but there was an open seat in the section!");
                        }
                        else
                        {
                            System.out.println("There are no seats available in this section.");
                        }
                    }
                }
                else
                {
                    System.out.println("The section does not exist.");
                }
            }
            else
            {
                System.out.println("No matching flight ID found.");
            }
        }
        else
        {
            System.out.println("No such flight exists.");
        }
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
            System.out.println("Request Error: Airline Name [" + name + "] Already Exists.");
        }
    }

    public void createAirport(String code)
    {
        if(hasAirport(code) == false)
        {
            Transport airport = this.airportFactory.createTransport(code);

            if (airport == null)
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
            System.out.println("Request Error : Airport Name [" + code + "] Already Exists.");
        }
    }

    private boolean isValidDate(int year, int month, int day)
    {
        boolean res = true;

        int curYear = Calendar.getInstance().get(Calendar.YEAR);
        int curMonth = Calendar.getInstance().get(Calendar.MONTH);
        int curDay = Calendar.getInstance().get(Calendar.DATE);

        if(year < curYear)
        {
            res = false;
        }
        else
        {
            if(year == curYear) // current year.
            {
                if(month < curMonth || month > 12) // month is already past or over 12.
                {
                    res = false;
                }
                else
                {
                    if(month == curMonth) // current month.
                    {
                        if(day < curDay || day > YearMonth.of(curYear, curMonth).lengthOfMonth())
                        {
                            res = false;
                        }
                    }
                    else // month > curMonth (future)
                    {
                        if(day < 1 || day > YearMonth.of(curYear, month).lengthOfMonth())
                        {
                            res = false;
                        }
                    }
                }
            }
            else // year > curYear (future)
            {
                if(month < 1 || month > 12)
                {
                    res = false;
                }
                else
                {
                    if(day < 1 || day > YearMonth.of(year, month).lengthOfMonth())
                    {
                        res = false;
                    }
                }
            }
        }

        return res;
    }

    public void createFlight(String company, String depart, String destination, int year, int month, int day, String ticketID)
    {
        if(hasAirline(company) && hasAirport(depart) && hasAirport(destination))
        {
            if(year > 0 && (month >= 1 && month <= 12) && (day >= 1 && day <= 31))
            {
                if(hasAirport(destination))
                {
                    if(isValidDate(year, month, day))
                    {
                        if(airlineList.get(findCompanyIndex(company)).idExist(ticketID) == false)
                        {
                            airlineList.get(findCompanyIndex(company)).addPath(this.airportFactory.createPath(company, depart, destination, year, month, day, ticketID));
                        }
                    }
                    else
                    {
                        System.out.println("Request Error: Date [" + year + "/" + month +"/"+ day +"] is not valid.");
                    }
                }
                else
                {
                    System.out.println("Request Error: Airport Name [" + destination + "] Doesn't Exists.");
                }
            }
            else
            {
                System.out.println("Request Error: Airport Name [" + depart + "] Doesn't Exists.");
            }
        }
        else
        {
            System.out.println("Request Error: Airline Name [" + company + "] Doesn't Exists.");
        }
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
                    System.out.println("Request Error: Seat Class [" + seatClass + "] Already Exists.");
                }
            }
            else
            {
                System.out.println("Request Error: ID [" + flightID + "] Doesn't Exists.");
            }
        }
        else
        {
            System.out.println("Request Error: Airline Name [" + airline + "] Doesn't Exists.");
        }
    }

    public void displaySystemDetails()
    {
        System.out.println("\nDisplaying system details...\n\n[+] All systems go!\n\n");

        System.out.println("==================== AIRPORTS ====================\n\n");

        for (Transport airport : airportList)
        {
            String name = airport.getName();
            System.out.println("* " + name);
        }

        System.out.println("\nTotal number of AIRPORTS: " + airportList.size() + "\n\n");
        System.out.println("==================================================\n");

        System.out.println("==================== AIRLINES ====================\n\n");

        for (Company airline : airlineList)
        {
            Airline currentAirline = (Airline) airline;
            System.out.println("* " + currentAirline.getName());
        }

        System.out.println("\nTotal number of unique AIRLINES: " + airlineList.size() + "\n\n");
        System.out.println("==================================================\n");

        System.out.println("============== AIRLINES w/ FLIGHTS ===============\n\n");

        System.out.println("\tCOMPANY\t\tDEPARTURE\t\tDESTINATION\n");

        for (Company airline : airlineList)
        {
            Airline currentAirline = (Airline) airline;
            String output = currentAirline.toString();

            if (output.equals("") == false)
            {
                System.out.println(currentAirline.toString());
            }
        }

        System.out.println("==================================================\n");

        this.findAvailableFlights("*", "*");
    }

    private int findCompanyIndex(String name)
    {
        int res = -1;

        if (this.airlineList.size() == 0)
        {
            return res;
        }

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

    public void findAvailableFlights(String departure, String destination)
    {
        boolean selectAll = false;
        int total = 0;

        if (departure.equals("*") && destination.equals("*"))
        {
            selectAll = true;
        }

        if((hasAirport(departure) && hasAirport(destination)) || selectAll == true)
        {
            for(Company airLine : this.airlineList)
            {
                ArrayList<Path> flightList = airLine.getPathList();

                for(Path flight : flightList)
                {
                    if((flight.getDeparture().equals(departure) && flight.getDestination().equals(destination)) || selectAll == true)
                    {
                        total++;
                        System.out.println("==================== AVAILABLE FLIGHT ====================\n\n" + ((Flight) flight).printInfo());
                        System.out.println("\n==========================================================\n");
                    }
                }
            }

            System.out.println("Total number of AVAILABLE FLIGHTS: " + total + "\n");
        }
        else
        {
            System.out.println("No available flights from " + departure.toUpperCase() + " to " + destination.toUpperCase());
        }
    }

    private boolean hasAirline(String name)
    {
        boolean res = false;

        if(this.airlineList.size() == 0)
        {
            return res;
        }

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

    private boolean hasAirport(String code)
    {
        boolean res = false;

        if(this.airportList.size() == 0)
        {
            return res;
        }

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
}