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

            }
            else if(choice == 4)
            {

            }
            else if(choice == 5)
            {

            }
            else if(choice == 6)
            {

            }
            else if(choice == 7)
            {

            }
            else if(choice == 8)
            {

            }

        }
        /*
        System.out.println("===================================================\n");

        System.out.println("=====About to create Airports.=====\n");

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
        res.createFlight("FRONT", "DFW", "DEN", 2016, 10, 10, "123");
        res.createFlight("AMER", "DEN", "LON", 2016, 2, 15, "123");
        res.createFlight("AMER", "DEN", "LON", 2016, 2, 30, "12322");
        res.createFlight("DEL", "DEN", "LON", 2013, 9, 8, "567"); //invalid airline
        res.createFlight("DELTA", "LON33", "DEN33", 2013, 5, 7, "123");//invalid airports
        res.createFlight("AMER", "DEN", "LON", 2010, 40, 100, "123abc");//invalid date

        System.out.println("\n=====About to create Section.=====\n");

        res.createSection("DELTA","123", 's', 2, SeatClass.economy, 100.00); //s layout
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
        res.bookSeat("DELTA", "123", SeatClass.economy, "aisle");
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

        res.displaySystemDetails();*/
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

    public static void readFromFile(SystemManager res)
    {
        Scanner kb = new Scanner(System.in);

        System.out.print("\nPlease Enter the FileName to import information From : ");
        String filename = kb.nextLine();
        
        res.readFile(filename);

        System.out.println("\nFinished.");
    }
}