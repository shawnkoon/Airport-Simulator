public class FlightSection extends Section
{
   private String flightClass;
   private boolean[][] seats;
   private boolean openSeats;
   
   public FlightSection(String company, String ticketID, int row, int col, String seatClass)
   {
      super(company, ticketID, row, col, seatClass);

      this.flightClass = flightClass;
      this.seats = new boolean[row][col];
      this.openSeats = true;
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
   
   public boolean hasAvailableSeats()
   {
      return this.openSeats;
   }
}
