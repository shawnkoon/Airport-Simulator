public class SampleClient {
    public static void main(String[] args)
    {
        SystemManager res = new SystemManager();

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

        res.createFlight("DELTA", "DEN", "LON", 2013, 10, 10, "123");
        res.createFlight("DELTA", "DEN", "LON", 2012, 1, 20, "123");//invalid id.
        res.createFlight("DELTA", "DEN", "DFW", 2013, 8, 8, "567abc");
        res.createFlight("FRONT", "DFW", "DEN", 2011, 10, 10, "123");
        res.createFlight("AMER", "DEN", "LON", 2013, 10, 10, "123");
        res.createFlight("DEL", "DEN", "LON", 2013, 9, 8, "567"); //invalid airline
        res.createFlight("DELTA", "LON33", "DEN33", 2013, 5, 7, "123");//invalid airports
        res.createFlight("AMER", "DEN", "LON", 2010, 40, 100, "123abc");//invalid date

        System.out.println("\n=====About to create Section.=====\n");

        res.createSection("DELTA","123", 2, 2, SeatClass.economy);
        res.createSection("DELTA","123", 2, 3, SeatClass.first);
        res.createSection("DELTA","123", 2, 3, SeatClass.first);//Invalid seat,
        res.createSection("DELTA","123", 3, 7, SeatClass.business);
        res.createSection("SWSERTT","123", 5, 5, SeatClass.economy);//Invalid airline
        res.createSection("FRONT", "123", 6, 2, SeatClass.economy);
        res.createSection("DELTA", "567abc", 2, 2, SeatClass.economy);
        res.createSection("AMER", "12", 9, 9, SeatClass.first);//Invalid ID.


        //res.findAvailableFlights("DEN", "LON");


    }
}
