public class FlightSection extends Section
{
   private String flightClass;
   private boolean[][] seats;
   private boolean seatOpen;
   
   public FlightSection(String company, String ticketID, int row, int col, String seatClass)
   {
      super(company, ticketID, row, col, seatClass);

      this.flightClass = flightClass;
      this.seats = new boolean[row][col];
      this.seatOpen = true;
   }
   
   public void bookSeat(int row, int col)
   {
      this.seats[row][col] = true;
      
      /*if(seatsAreFull)
      {
         this.openSeats = false;
      }
      */
   }
   
   public boolean hasAvailableSeat()
   {
      return this.seatOpen;
   }
}
