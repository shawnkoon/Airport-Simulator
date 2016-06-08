import java.io.File;
import java.io.FileNotFoundException;
import java.time.YearMonth;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Scanner;

public class SystemManager
{
    private TransportationFactory airportFactory;
    private ArrayList<Transport> airportList;
    private ArrayList<Company> airlineList;
    private UtilManager utility;

    public SystemManager()
    {
        this.airportList = new ArrayList<Transport>();
        this.airlineList = new ArrayList<Company>();
        this.airportFactory = new AirportFactory();

        this.utility = new UtilManager();
        

    }

    public void readFile(String filename)
    {
        String AMS;

        ArrayList<String> airport_names = new ArrayList<String>();
        ArrayList<String> list_of_airlines = new ArrayList<String>();
        ArrayList<String> airline_names = new ArrayList<String>();

        try
        {
            File fopen = new File(filename);
            Scanner kb = new Scanner(fopen);

            AMS = kb.nextLine(); //[list-of-airport-codes] {list-of-airlines}

            airport_names = extractAirport_names(strip( ( AMS.split("\\]"))[0] )); // ex) DEN, NYC, ...
            storeAirports(airport_names); // Stores into this.airportList

            list_of_airlines = extractAirLines(AMS.split("\\{")[1].split("\\}")[0]); // ex) AMER[...], UNTD[...] ...

            airline_names = extractAirLine_Names(list_of_airlines); // ex) AMER, UNTD ...
            storeAirlines(airline_names); // Stores into this.airlineList

            createFlightinfo_List(list_of_airlines);


        }
        catch (FileNotFoundException e)
        {
            System.out.println("The File '"+filename+"' was not found.");
        }
    }

    public void createFlightinfo_List(ArrayList<String> list) // for each airline, it will try to create flights.
    {
        for(String airline : list)
        {
            int index = 0;
            String cleanAirline = "";
            String airline_name = "";

            for(int i = 0; i < airline.length(); i++)
            {
                if(index == 0)
                {
                    if(airline.charAt(i) == '[')
                    {
                        index = i;
                        break;
                    }
                }
            }
            airline_name = airline.substring(0, index);
            cleanAirline = airline.substring(index + 1, airline.length() - 1);

            ArrayList<String> flights = extractFlightInfo(cleanAirline);

            createFlight(airline_name, flights);
        }
    }

    public void createFlight(String airline_name, ArrayList<String> flightString)
    {
        for(String flightInfo : flightString) // ex) AA1|2011, 10, 8, 16, 30|DEN|LAX[E:200:S:4,F:500:S:2]
        {
            // break flightInfo into := String depart, String destination, int year, int month, int day, String ticketID
            // then call createFlight() method.
            String[] s = flightInfo.split("\\|");
            String depart = s[2];
            String destination = s[3].split("\\[")[0];
            int year = Integer.parseInt(s[1].split(", ")[0]);
            int month = Integer.parseInt(s[1].split(", ")[1]);
            int day = Integer.parseInt(s[1].split(", ")[2]);
            String ticketID = s[0];
            String sectionList =s[3].split("\\[")[1].substring(0,s[3].split("\\[")[1].length() - 1);

            this.createFlight(airline_name, depart, destination, year, month, day, ticketID);

            createSection(airline_name, ticketID, sectionList);
        }

    }

    public void createSection(String airline_name, String flightID, String sectionList)
    {
        String[] sectionInfo = sectionList.split(",");
        for(String sectioninfo : sectionInfo)
        {
            String section;
            if(sectioninfo.charAt(0) == ' ')
            {
                section = sectioninfo.substring(1, sectioninfo.length());
            }
            else
            {
                section = sectioninfo;
            }

            String[] s = section.split(":"); // break up. ex) E , 200(price), S(layout), 4(max rowz)
            if(s[0].equals("E"))
            {
                // call createSection with "SeatClass.economy"
                this.createSection(airline_name, flightID, s[2].charAt(0), Integer.parseInt(s[3]) ,SeatClass.economy, Double.parseDouble(s[1]));
            }
            else if(s[0].equals("B"))
            {
                // call createSection with "SeatClass.business"
                this.createSection(airline_name, flightID, s[2].charAt(0), Integer.parseInt(s[3]) ,SeatClass.business, Double.parseDouble(s[1]));
            }
            else if(s[0].equals("F"))
            {
                // call createSection with "SeatClass.first"
                this.createSection(airline_name, flightID, s[2].charAt(0), Integer.parseInt(s[3]) ,SeatClass.first, Double.parseDouble(s[1]));
            }
        }

    }

    public ArrayList<String> extractFlightInfo(String s)
    {
        ArrayList<String> res = new ArrayList<String>();

        String[] flights =  s.split("\\], ");

        for(int i = 0; i < flights.length; i++)
        {
            if(i < flights.length - 1)
            {
                res.add(flights[i] + "]");
            }
            else
            {
                res.add(flights[i]);
            }
        }


        return res;
    }

    public void storeAirlines(ArrayList<String> list)
    {
        for(String name : list)
        {
            this.createAirline(name);
        }
    }

    public void storeAirports(ArrayList<String> list)
    {
        for(String code : list)
        {
            this.createAirport(code);
        }
    }

    public ArrayList<String> extractAirLine_Names(ArrayList<String> list)
    {
        ArrayList<String> res = new ArrayList<String>();

        for(String s : list)
        {
            res.add(s.split("\\[")[0]);
        }

        return res;
    }

    public ArrayList<String> extractAirLines(String string)
    {
        String[] s = string.split("\\]\\], ");
        ArrayList<String> res = new ArrayList<String>();

        for(int i = 0; i < s.length; i++)
        {
            if(i < s.length - 1)
            {
                res.add(s[i]+"]]");
            }
            else
            {
                res.add(s[i]);
            }
        }

        return res;
    }

    public ArrayList<String> extractAirport_names(String string)
    {
        String[] s = string.split(", ");
        ArrayList<String> res = new ArrayList<String>();

        for(int i = 0; i < s.length; i++)
        {
            res.add(s[i]);
        }

        return res;
    }

    // Strips off [,],{,} symbols.
    public String strip(String messyString)
    {
        String res = "";

        for(int i = 0; i < messyString.length(); i++)
        {
            if(messyString.charAt(i) == '[' || messyString.charAt(i) == ']' || messyString.charAt(i) == '{' || messyString.charAt(i) == '}')
            {
                // do nothing.
            }
            else
            {
                res += messyString.charAt(i);
            }
        }

        return res; // return string without ' [ , ] , { , } '
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

    /*private char toChar(int col)
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
    }*/

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
                            currentSection.bookSeat(this.airportFactory.createSeat(opening[0], this.utility.toChar(opening[1])));
                        }
                        else
                        {
                            currentSection.bookSeat(this.airportFactory.createSeat(1, 'A'));
                        }
                    }
                    else
                    {
                        Section currentSection = currentPath.getSection(seatClass.toString());

                        int[] opening = currentPath.getSection(seatClass.toString()).getAvailableSeat();

                        if(opening[0] != -1 && opening[1] != -1)
                        {
                            currentSection.bookSeat(this.airportFactory.createSeat(opening[0], this.utility.toChar(opening[1])));
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

    public void createSection(String airline, String flightID, char layout, int row, SeatClass seatClass, double price)
    {
        layout = Character.toLowerCase(layout);

        if(hasAirline(airline))
        {
            if(airlineList.get(findCompanyIndex(airline)).idExist(flightID))
            {
                if(airlineList.get(findCompanyIndex(airline)).getPath(flightID).hasSection(seatClass.toString()) == false)
                {
                    //this.airportFactory.createSection2(airline, flightID, layout, row, seatClass.toString());
                    //airlineList.get(findCompanyIndex(airline)).getPath(flightID).addSection(this.airportFactory.createSection2(airline, flightID, layout, row, seatClass.toString()));

                    airlineList.get(findCompanyIndex(airline)).getPath(flightID).addSection(this.airportFactory.createSection2(airline, flightID, layout, row, seatClass.toString(), price));
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

    public void changePriceSeats(String seatClass, double price)
    {
        for(Company airLine : this.airlineList)
        {
            ArrayList<Path> flightList = airLine.getPathList();

            for(Path flight : flightList)
            {
                ArrayList<Section> sectionList = flight.getSections();

                for(Section section : sectionList)
                {
                    String currentSeatClass = section.getSeatClass();

                    if(currentSeatClass.equals(seatClass))
                    {
                        section.setPrice(price);
                    }
                }
            }
        }
    }

    public void changePriceSeat(String airline, String origin, String destination, String seatClass, double price)
    {
        for(Company air : this.airlineList)
        {
            if(air.getName().equals(airline))
            {
                ArrayList<Path> flightList = air.getPathList();

                for(Path flight : flightList)
                {
                    if(flight.getDeparture().equals(origin) && flight.getDestination().equals(destination))
                    {
                        ArrayList<Section> sectionList = flight.getSections();

                        for(Section section : sectionList)
                        {
                            String currentSeatClass = section.getSeatClass();

                            if(currentSeatClass.equals(seatClass))
                            {
                                section.setPrice(price);
                            }
                        }
                    }
                }
            }
        }
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

    public boolean hasAirline(String name)
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

    public boolean hasAirport(String code)
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