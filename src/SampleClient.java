public class SampleClient {
    public static void main(String[] args)
    {
        SystemManager res = new SystemManager();
        res.createAirport("DEN");

        res.createAirline("DELTA");

        System.out.println(SeatClass.business);

        //res.createSection("DELTA", "123", 2, 2, SeatClass.economy);
    }
}
