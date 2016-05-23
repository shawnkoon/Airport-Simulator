public class SampleClient {
    public static void main(String[] args)
    {
        SystemManager res = new SystemManager();
        res.createAirport("DEN");
        res.createAirport("DFW");
        res.createAirport("LON");
        res.createAirport("DEN");//invalid
        res.createAirport("DENW");//invalid


        res.createAirline("DELTA");
        res.createAirline("AMER");
        res.createAirline("FRONT");
        res.createAirline("FRONTIER"); //invalid
        res.createAirline("FRONT"); //invalid


        res.createFlight("DELTA", "DEN", "LON", 2013, 10, 10, "123");
        res.createFlight("DELTA", "DEN", "LON", 2012, 1, 20, "123");//invalid id.
        res.createFlight("DELTA", "DEN", "DFW", 2013, 8, 8, "567abc");
        res.createFlight("FRONT", "DFW", "DEN", 2011, 10, 10, "123");
        res.createFlight("AMER", "DEN", "LON", 2013, 10, 10, "123");
        res.createFlight("DEL", "DEN", "LON", 2013, 9, 8, "567"); //invalid airline
        res.createFlight("DELTA", "LON33", "DEN33", 2013, 5, 7, "123");//invalid airports
        res.createFlight("AMER", "DEN", "LON", 2010, 40, 100, "123abc");//invalid date

        res.findAvailableFlights("DEN", "LON");

    }
}
