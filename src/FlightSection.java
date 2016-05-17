public class FlightSection 
{
   private String flightClass;
   private boolean[][] seats;
   private boolean openSeats;
   
   public FlightSection(String flightClass, int row, int col)
   {
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
