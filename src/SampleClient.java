/*
 * Airport-Simulator V1.0.0
 * Java 1.8 SDK required
 * TEAM PROJECT by (ABC order):
 *
 * C H
 * K S
 *
 */

import java.io.File;
import java.util.*;

public class SampleClient {
    public static void main(String[] args)
    {
        int choice = 0;

        SystemManager res = new SystemManager();

/*
        res.createAirport("DEN");
        res.createAirport("DFW");
        res.createAirport("LON");
        res.createAirport("DEN");//invalid
        res.createAirport("DENW");//invalid

        System.out.println("\n=====About to create Airlines.=====\n");

        res.createAirline("DELTA");
        res.createAirline("AMER");
        res.createAirline("FRONT");
        res.createAirline("FRONTIER"); //invalid
        res.createAirline("FRONT"); //invalid

        System.out.println("\n=====About to create Flights.=====\n");

        res.createFlight("DELTA", "DEN", "LON", 2016, 10, 10, "123");
        res.createFlight("DELTA", "DEN", "LON", 2012, 1, 20, "123");//invalid id.
        res.createFlight("DELTA", "DEN", "DFW", 2016, 8, 8, "567abc");
        res.createFlight("FRONT", "DEN", "LON", 2016, 10, 10, "132");
        res.createFlight("FRONT", "DFW", "DEN", 2016, 10, 10, "123");
        res.createFlight("AMER", "DEN", "LON", 2016, 2, 15, "123");
        res.createFlight("AMER", "DEN", "LON", 2016, 2, 30, "12322");
        res.createFlight("DEL", "DEN", "LON", 2013, 9, 8, "567"); //invalid airline
        res.createFlight("DELTA", "LON33", "DEN33", 2013, 5, 7, "123");//invalid airports
        res.createFlight("AMER", "DEN", "LON", 2010, 40, 100, "123abc");//invalid date

        System.out.println("\n=====About to create Section.=====\n");

        res.createSection("DELTA","123", 's', 2, SeatClass.economy, 100.00); //s layout
        res.createSection("FRONT", "132", 's', 2, SeatClass.economy, 100.00);
        //res.createSection("DELTA","123", 2, 2, SeatClass.economy);
        res.createSection("DELTA","123", 'm', 3, SeatClass.first, 250.00);
        res.createSection("DELTA","123", 2, 3, SeatClass.first);//Invalid seat,
        res.createSection("DELTA","123", 'w', 7, SeatClass.business, 500.00);
        res.createSection("SWSERTT","123", 5, 5, SeatClass.economy);//Invalid airline
        res.createSection("FRONT", "123", 6, 2, SeatClass.economy);
        res.createSection("DELTA", "567abc", 2, 2, SeatClass.economy);
        res.createSection("AMER", "12", 9, 9, SeatClass.first);//Invalid ID.

        System.out.println("\n=====About to print Available Flights.=====\n");

        res.findAvailableFlights("DEN", "LON");

        System.out.println("\n=====About to book some seats.=====\n");

        res.bookSeat("DELTA", "123", SeatClass.first, 1, 'A');
        //res.bookSeat("DELTA", "123", SeatClass.economy, 1, 'A');
        res.bookSeat("DELTA", "123", SeatClass.economy, "aisle");
        res.bookSeat("DELTA", "123", SeatClass.economy, "aisle");
        res.bookSeat("DELTA", "123", SeatClass.economy, "aisle");
        res.bookSeat("DELTA", "123", SeatClass.economy, "aisle");
        res.bookSeat("DELTA", "123", SeatClass.first, "aisle");
        res.bookSeat("DELTA", "123", SeatClass.first, "aisle");
        res.bookSeat("DELTA", "123", SeatClass.first, "aisle");
        res.bookSeat("DELTA", "123", SeatClass.first, "aisle");
        res.bookSeat("DELTA", "123", SeatClass.first, "aisle");
        res.bookSeat("DELTA", "123", SeatClass.first, "aisle");
        res.bookSeat("DELTA", "123", SeatClass.first, "aisle");
        res.bookSeat("DELTA", "123", SeatClass.first, "aisle");
        res.bookSeat("DELTA", "123", SeatClass.first, "aisle");
        res.bookSeat("DELTA", "123", SeatClass.first, "aisle");
        res.bookSeat("DELTA", "123", SeatClass.first, "aisle");
        System.out.println("M should be full....");
        res.bookSeat("DELTA", "123", SeatClass.first, "aisle");
        res.bookSeat("DELTA", "123", SeatClass.first, "aisle");
        //col c will be filled
        res.bookSeat("DELTA", "123", SeatClass.business, "aisle");
        res.bookSeat("DELTA", "123", SeatClass.business, "aisle");
        res.bookSeat("DELTA", "123", SeatClass.business, "aisle");
        res.bookSeat("DELTA", "123", SeatClass.business, "aisle");
        res.bookSeat("DELTA", "123", SeatClass.business, "aisle");
        res.bookSeat("DELTA", "123", SeatClass.business, "aisle");
        res.bookSeat("DELTA", "123", SeatClass.business, "aisle");
        //col d will be filled
        res.bookSeat("DELTA", "123", SeatClass.business, "aisle");
        res.bookSeat("DELTA", "123", SeatClass.business, "aisle");
        res.bookSeat("DELTA", "123", SeatClass.business, "aisle");
        res.bookSeat("DELTA", "123", SeatClass.business, "aisle");
        res.bookSeat("DELTA", "123", SeatClass.business, "aisle");
        res.bookSeat("DELTA", "123", SeatClass.business, "aisle");
        res.bookSeat("DELTA", "123", SeatClass.business, "aisle");
        //col a is next available in this section
        res.bookSeat("DELTA", "123", SeatClass.business, "aisle");
        res.bookSeat("DELTA", "123", SeatClass.business, "aisle");
        res.bookSeat("DELTA", "123", SeatClass.business, "aisle");
        res.bookSeat("DELTA", "123", SeatClass.business, "aisle");
        res.bookSeat("DELTA", "123", SeatClass.business, "aisle");
        res.bookSeat("DELTA", "123", SeatClass.business, "aisle");
        res.bookSeat("DELTA", "123", SeatClass.business, "aisle");
        //col b...
        res.bookSeat("DELTA", "123", SeatClass.business, "aisle");
        res.bookSeat("DELTA", "123", SeatClass.business, "aisle");
        res.bookSeat("DELTA", "123", SeatClass.business, "aisle");
        res.bookSeat("DELTA", "123", SeatClass.business, "aisle");
        res.bookSeat("DELTA", "123", SeatClass.business, "aisle");
        res.bookSeat("DELTA", "123", SeatClass.business, "aisle");
        res.bookSeat("DELTA", "123", SeatClass.business, "aisle");
        //col e
        res.bookSeat("DELTA", "123", SeatClass.business, "aisle");
        res.bookSeat("DELTA", "123", SeatClass.business, "aisle");
        res.bookSeat("DELTA", "123", SeatClass.business, "aisle");
        res.bookSeat("DELTA", "123", SeatClass.business, "aisle");
        res.bookSeat("DELTA", "123", SeatClass.business, "aisle");
        res.bookSeat("DELTA", "123", SeatClass.business, "aisle");
        res.bookSeat("DELTA", "123", SeatClass.business, "aisle");
        //col f
        res.bookSeat("DELTA", "123", SeatClass.business, "aisle");
        res.bookSeat("DELTA", "123", SeatClass.business, "aisle");
        res.bookSeat("DELTA", "123", SeatClass.business, "aisle");
        res.bookSeat("DELTA", "123", SeatClass.business, "aisle");
        res.bookSeat("DELTA", "123", SeatClass.business, "aisle");
        res.bookSeat("DELTA", "123", SeatClass.business, "aisle");
        res.bookSeat("DELTA", "123", SeatClass.business, "aisle");
        //col g
        res.bookSeat("DELTA", "123", SeatClass.business, "aisle");
        res.bookSeat("DELTA", "123", SeatClass.business, "aisle");
        res.bookSeat("DELTA", "123", SeatClass.business, "aisle");
        res.bookSeat("DELTA", "123", SeatClass.business, "aisle");
        res.bookSeat("DELTA", "123", SeatClass.business, "aisle");
        res.bookSeat("DELTA", "123", SeatClass.business, "aisle");
        res.bookSeat("DELTA", "123", SeatClass.business, "aisle");
        //col h
        res.bookSeat("DELTA", "123", SeatClass.business, "aisle");
        res.bookSeat("DELTA", "123", SeatClass.business, "aisle");
        res.bookSeat("DELTA", "123", SeatClass.business, "aisle");
        res.bookSeat("DELTA", "123", SeatClass.business, "aisle");
        res.bookSeat("DELTA", "123", SeatClass.business, "aisle");
        res.bookSeat("DELTA", "123", SeatClass.business, "aisle");
        res.bookSeat("DELTA", "123", SeatClass.business, "aisle");
        //col i
        res.bookSeat("DELTA", "123", SeatClass.business, "aisle");
        res.bookSeat("DELTA", "123", SeatClass.business, "aisle");
        res.bookSeat("DELTA", "123", SeatClass.business, "aisle");
        res.bookSeat("DELTA", "123", SeatClass.business, "aisle");
        res.bookSeat("DELTA", "123", SeatClass.business, "aisle");
        res.bookSeat("DELTA", "123", SeatClass.business, "aisle");
        res.bookSeat("DELTA", "123", SeatClass.business, "aisle");
        //col j
        res.bookSeat("DELTA", "123", SeatClass.business, "aisle");
        res.bookSeat("DELTA", "123", SeatClass.business, "aisle");
        res.bookSeat("DELTA", "123", SeatClass.business, "aisle");
        res.bookSeat("DELTA", "123", SeatClass.business, "aisle");
        res.bookSeat("DELTA", "123", SeatClass.business, "aisle");
        res.bookSeat("DELTA", "123", SeatClass.business, "aisle");
        res.bookSeat("DELTA", "123", SeatClass.business, "aisle");

        System.out.println("Layout w should be full......................");
        res.bookSeat("DELTA", "123", SeatClass.business, "window");
        res.bookSeat("DELTA", "123", SeatClass.business, "window");


        //res.bookSeat("DELTA", "123", SeatClass.economy, 1, 'B');
        res.bookSeat("DELTA888", "123", SeatClass.business, 1, 'A'); //Invalid airline
        res.bookSeat("DELTA", "123haha7", SeatClass.business, 1, 'A'); //Invalid flightId
        //res.bookSeat("DELTA", "123", SeatClass.economy, 1, 'A'); //

        // already booked

        res.displaySystemDetails();

        System.out.println("\n\n" + Layout.SMALL.getValue());

        res.changePriceSeats(SeatClass.economy.toString(), 50000.0);

        res.displaySystemDetails();
*/

        while(choice != 9)
        {
            // 1. Create an airport system by using information provided in an input file.
            // 2. Change the price associated with seats in a flight section. (What is the difference between #4?)
            // 3. Query the system for flights with available seats in a given class that leave from a specified airport and arrive
            //    at specified airport on a particular date. The query operation should list all the available flights found
            //    and its prices.
            // 4. Change the seat class pricing for an origin and destination for a given airline. (What is the difference between #2?)
            // 5. Book a seat given a specific seat on a flight.
            // 6. Book a seat on a flight given only a seating preference: The program should allow a user to book
            //    a seat on a particular flight using only a seating preference and a flight class. There will only be
            //    two seating preferences: Window and Aisle. This booking service will look for an available seat
            //    in the flight section with the seating preference. If one is found then the seat is booked. If one is
            //    not found, then the system will book any available seat in the specified section, if any.
            // 7. Display details of the airport system.
            // 8. Store information about the airport system in a specified file.
            // 9. Quit.

            choice = showMenu();
            if(choice == 1)
            {
                readFromFile(res);
            }
            else if(choice == 2)
            {
                System.out.println("\nPlease choose a Seat Class to update:\n\t1. ECONOMY\n\t2. FIRST\n\t3. BUSINESS\n\t4. QUIT");
                System.out.print("Please enter your choice : ");

                boolean check = false;

                int result = -1;

                while(check == false)
                {
                    try
                    {
                        Scanner kb = new Scanner(System.in);
                        result = kb.nextInt();

                        if(result >= 1 && result <= 4)
                        {
                            check = true;
                        }
                    }
                    catch(Exception e)
                    {

                    }

                    if(check == false)
                    {
                        System.out.print("Please enter a number between [1-3] : ");
                    }
                }

                if(result != 4)
                {
                    String seatClass = "";
                    double seatPrice = 0.0;

                    switch(result)
                    {
                        case 1:
                            seatClass = "ECONOMY";
                        break;
                        case 2:
                            seatClass = "FIRST";
                        break;
                        case 3:
                            seatClass = "BUSINESS";
                        break;
                    }

                    check = false;

                    while(check == false)
                    {
                        System.out.print("\nPlease enter a new price or Q to quit : ");

                        try
                        {
                            Scanner kb = new Scanner(System.in);
                            String price = kb.nextLine();

                            if(!price.toUpperCase().equals("Q"))
                            {
                                seatPrice = Double.parseDouble(price);
                                check = true;
                            }
                            else
                            {
                                check = true;
                            }

                        }
                        catch(Exception e)
                        {

                        }
                    }

                    if(!seatClass.equals("") && seatPrice != 0.0)
                    {
                        res.changePriceSeats(seatClass, seatPrice);
                        System.out.println("Prices for Seat Classes [" + seatClass + "] have been updated to: $" + seatPrice);
                    }
                }
            }
            else if(choice == 3)
            {
                String origin = "";
                boolean check = false;


                while(check == false)
                {
                    try
                    {
                        Scanner kb = new Scanner(System.in);
                        System.out.print("Please enter an origin : ");
                        origin = kb.nextLine();

                        if (res.hasAirport(origin))
                        {
                            check = true;
                        }
                        else
                        {
                            System.out.println("Origin not found!");
                        }
                    }
                    catch(Exception e)
                    {

                    }
                }

                String destination = "";
                check = false;

                while(check == false)
                {
                    try
                    {
                        Scanner kb = new Scanner(System.in);
                        System.out.print("Please enter a destination : ");
                        destination = kb.nextLine();

                        if (res.hasAirport(destination))
                        {
                            check = true;
                        }
                        else
                        {
                            System.out.println("Destination not found!");
                        }
                    }
                    catch(Exception e)
                    {

                    }
                }

                int year = -1;
                check = false;

                while(check == false)
                {
                    try
                    {
                        Scanner kb = new Scanner(System.in);
                        System.out.print("Please enter year of departure : ");
                        year = kb.nextInt();

                        if(year >= 2016)
                        {
                            check = true;
                        }
                        else
                        {
                            System.out.print("Please enter a valid year of departure : ");
                        }
                    }
                    catch(Exception e)
                    {
                        System.out.print("Please enter a valid year of departure : ");
                    }
                }

                int month = -1;
                check = false;

                while(check == false)
                {
                    try
                    {
                        Scanner kb = new Scanner(System.in);
                        System.out.print("Please enter month of departure : ");
                        month = kb.nextInt();

                        if(month >= 1 && month <= 12)
                        {
                            check = true;
                        }
                        else
                        {
                            System.out.print("Please enter a valid month of departure : ");
                        }
                    }
                    catch(Exception e)
                    {
                        System.out.print("Please enter a valid month of departure : ");
                    }
                }

                int day = -1;
                check = false;

                while(check == false)
                {
                    try
                    {
                        Scanner kb = new Scanner(System.in);
                        System.out.print("Please enter day of departure : ");
                        day = kb.nextInt();

                        if(day >= 1 && day <= 31)
                        {
                            check = true;
                        }
                        else
                        {
                            System.out.print("Please enter a valid day of departure : ");
                        }
                    }
                    catch(Exception e)
                    {
                        System.out.print("Please enter a valid day of departure : ");
                    }
                }

                System.out.println("\nPlease choose a Seat Class of interest\n\t1. ECONOMY\n\t2. FIRST\n\t3. BUSINESS\n\t4. QUIT");
                System.out.print("Please enter your choice : ");

                check = false;
                int result = -1;

                while(check == false)
                {
                    try
                    {
                        Scanner kb = new Scanner(System.in);
                        result = kb.nextInt();

                        if(result >= 1 && result <= 4)
                        {
                            check = true;
                        }
                    }
                    catch(Exception e)
                    {

                    }

                    if(check == false)
                    {
                        System.out.print("Please enter a number between [1-3] : ");
                    }
                }

                if(result != 4)
                {
                    String seatClass = "";

                    switch (result) {
                        case 1:
                            seatClass = "ECONOMY";
                            break;
                        case 2:
                            seatClass = "FIRST";
                            break;
                        case 3:
                            seatClass = "BUSINESS";
                            break;
                    }

                    if(!origin.equals("") && !destination.equals("") && year != -1 && month != -1 && day != -1 && !seatClass.equals(""))
                    {
                        res.findAvailableFlights(origin, destination, year, month, day, seatClass);
                    }
                }

            }
            else if(choice == 4)
            {
                String airline = "";
                boolean check = false;


                while(check == false)
                {
                    try
                    {
                        Scanner kb = new Scanner(System.in);
                        System.out.println("Please enter an airline : ");
                        airline = kb.nextLine();

                        if (res.hasAirline(airline))
                        {
                            check = true;
                        }
                        else
                        {
                            System.out.println("Airline not found!");
                        }
                    }
                    catch(Exception e)
                    {

                    }
                }

                String origin = "";
                check = false;

                while(check == false)
                {
                    try
                    {
                        Scanner kb = new Scanner(System.in);
                        System.out.println("Please enter an origin : ");
                        origin = kb.nextLine();

                        if (res.hasAirport(origin))
                        {
                            check = true;
                        }
                        else
                        {
                            System.out.println("Origin not found!");
                        }
                    }
                    catch(Exception e)
                    {

                    }
                }

                String destination = "";
                check = false;

                while(check == false)
                {
                    try
                    {
                        Scanner kb = new Scanner(System.in);
                        System.out.println("Please enter a destination : ");
                        destination = kb.nextLine();

                        if (res.hasAirport(destination))
                        {
                            check = true;
                        }
                        else
                        {
                            System.out.println("Destination not found!");
                        }
                    }
                    catch(Exception e)
                    {

                    }
                }



                System.out.println("\nPlease choose a Seat Class to update:\n\t1. ECONOMY\n\t2. FIRST\n\t3. BUSINESS\n\t4. QUIT");
                System.out.print("Please enter your choice : ");

                check = false;
                int result = -1;

                while(check == false)
                {
                    try
                    {
                        Scanner kb = new Scanner(System.in);
                        result = kb.nextInt();

                        if(result >= 1 && result <= 4)
                        {
                            check = true;
                        }
                    }
                    catch(Exception e)
                    {

                    }

                    if(check == false)
                    {
                        System.out.print("Please enter a number between [1-3] : ");
                    }
                }

                if(result != 4)
                {
                    String seatClass = "";

                    switch(result)
                    {
                        case 1:
                            seatClass = "ECONOMY";
                            break;
                        case 2:
                            seatClass = "FIRST";
                            break;
                        case 3:
                            seatClass = "BUSINESS";
                            break;
                    }

                    check = false;
                    double seatPrice = 0.0;

                    while(check == false)
                    {
                        System.out.print("\nPlease enter a new price or Q to quit : ");

                        try
                        {
                            Scanner kb = new Scanner(System.in);
                            String price = kb.nextLine();

                            if(!price.toUpperCase().equals("Q"))
                            {
                                seatPrice = Double.parseDouble(price);
                                check = true;
                            }
                            else
                            {
                                check = true;
                            }

                        }
                        catch(Exception e)
                        {

                        }
                    }

                    if(!seatClass.equals("") && seatPrice != 0.0)
                    {
                        res.changePriceSeat(airline, origin, destination, seatClass, seatPrice);
                        System.out.println("All flights from [" + origin + "] to [" + destination + "] at airline [" + airline + "] in a seat class of [" + seatClass + "] have been updated to: $" + seatPrice);
                    }
                }

            }
            else if(choice == 5)
            {
                bookSeatPrompt(res);
            }
            else if(choice == 6)
            {
                String airline = "";
                boolean check = false;

                while(check == false)
                {
                    try
                    {
                        Scanner kb = new Scanner(System.in);
                        System.out.print("Please enter an airline : ");
                        airline = kb.nextLine();


                        if (res.hasAirline(airline))
                        {
                            check = true;
                        }
                        else
                        {
                            System.out.println("Airline not found!");
                        }
                    }
                    catch(Exception e)
                    {

                    }
                }

                String id = "";
                check = false;

                while(check == false)
                {
                    try
                    {
                        Scanner kb = new Scanner(System.in);
                        System.out.print("Please enter a flight ID : ");
                        id = kb.nextLine();

                        check = true;
                    }
                    catch(Exception e)
                    {

                    }
                }

                System.out.println("\nPlease choose a preferred Seat Class:\n\t1. ECONOMY\n\t2. FIRST\n\t3. BUSINESS\n\t4. QUIT");
                System.out.print("Please enter your choice : ");

                check = false;

                int result = -1;
                SeatClass seatClass = SeatClass.economy;

                while(check == false)
                {
                    try
                    {
                        Scanner kb = new Scanner(System.in);
                        result = kb.nextInt();

                        if(result >= 1 && result <= 4)
                        {
                            check = true;
                        }
                    }
                    catch(Exception e)
                    {

                    }

                    if(check == false)
                    {
                        System.out.print("Please enter a number between [1-3] : ");
                    }
                }

                if(result != -1 && result != 4)
                {
                    switch(result)
                    {
                        case 1:
                            seatClass = SeatClass.economy;
                            break;
                        case 2:
                            seatClass = SeatClass.first;
                            break;
                        case 3:
                            seatClass = SeatClass.business;
                            break;
                    }

                    String preference = "";
                    result = -1;
                    check = false;

                    while(check == false)
                    {
                        try
                        {
                            Scanner kb = new Scanner(System.in);
                            System.out.println("Please choose a preference:\n\t1. WINDOW\n\t2. AISLE\n\t3. QUIT");
                            System.out.print("Please enter your choice : ");

                            result = kb.nextInt();

                            if(result >= 1 && result <= 3)
                            {
                                check = true;
                            }
                        }
                        catch(Exception e)
                        {

                        }
                    }

                    if(result != 3 && result != -1)
                    {
                        switch(result)
                        {
                            case 1:
                                preference = "window";
                                break;
                            case 2:
                                preference = "aisle";
                                break;
                        }

                        res.bookSeat(airline, id, seatClass, preference);
                    }
                }
            }
            else if(choice == 7)
            {
                res.displaySystemDetails();
            }
            else if(choice == 8)
            {
                writeToFile(res);
            }
        }
    }

    public static int showMenu()
    {
        int choice = 0;
        Scanner kb = new Scanner(System.in);

        while(choice < 1 || choice > 9)
        {
            System.out.println("===================================================\n");
            System.out.println("Options.");
            System.out.println("1. Create an airport FROM File.");
            System.out.println("2. Change the price associated with seats in a flight section.");
            System.out.println("3. Query Flights With Available Seats.");
            System.out.println("4. Change the Seat class price of path in Airline.");
            System.out.println("5. Book a seat on a flight.");
            System.out.println("6. Book a seat on a flight by seat preference.");
            System.out.println("7. Display Detailed Airport System.");
            System.out.println("8. Save information about the Airport System in a specified file.");
            System.out.println("9. Quit.\n");
            System.out.print("Please Enter your choice : ");

            try
            {
                choice = kb.nextInt();
            }
            catch (Exception e)
            {
                System.out.println("Error : Please Type an Integer.");
                choice = 0;
            }

            kb.nextLine();

            if(choice < 1 || choice > 9)
            {
                System.out.println("Error : Type a Number between 1 and 9.");
            }
        }
        return choice;
    }

    public static void bookSeatPrompt(SystemManager res)
    {
        Scanner kb = new Scanner(System.in);

        System.out.print("\nPlease Enter the Airline Name to Book Seat : ");
        String airline = kb.nextLine();

        System.out.print("Please Enter the FlightID for that Airline : ");
        String flightID = kb.nextLine();

        System.out.print("Please Enter the SeatClass < ex) first, business, economy > : ");
        String seatClass = kb.nextLine().toLowerCase();

        int rowNumb = 0;
        while(rowNumb < 1)
        {
            try
            {
                System.out.print("Please Enter the Row Number of the Seat : ");
                rowNumb = kb.nextInt();
            }
            catch (Exception e)
            {
                System.out.println("Error : Please Type a Number Greater than 0.\n");
                rowNumb = 0;
            }
            kb.nextLine();
        }

        System.out.print("Please Enter the Column Character of the Seat : ");
        String column = kb.nextLine().toUpperCase();
        char columnChar = column.charAt(0);

        System.out.println("");

        if(seatClass.equals("first"))
        {
            res.bookSeat(airline, flightID, SeatClass.first, rowNumb, columnChar);
        }
        else if(seatClass.equals("business"))
        {
            res.bookSeat(airline, flightID, SeatClass.business, rowNumb, columnChar);
        }
        else if(seatClass.equals("economy"))
        {
            res.bookSeat(airline, flightID, SeatClass.economy, rowNumb, columnChar);
        }
        else
        {
            System.out.println("The seatClass ["+seatClass+"] is not valid.");
        }

        System.out.println("\nFinished.");
    }

    public static void readFromFile(SystemManager res)
    {
        Scanner kb = new Scanner(System.in);

        System.out.print("\nPlease Enter the FileName to import information From : ");
        String filename = kb.nextLine();
        System.out.println("");

        res.readFile(filename);

        System.out.println("\nFinished.");
    }

    public static void writeToFile(SystemManager res)
    {
        Scanner kb = new Scanner(System.in);

        System.out.print("\nPlease Enter the File name to export : ");
        String filename = kb.nextLine();
        System.out.println("");

        // I am overriding the old file if same filename is given.

        res.writeFile(filename);

        System.out.println("\nFinished.");
    }
}