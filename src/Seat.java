public class Seat 
{
   private int row;
   private char col;
   private boolean isBooked;
   
   public Seat(int row, char col)
   {
      this.row = row;
      this.col = col;
   }
   
   private boolean getStatus()
   {
      return this.isBooked;
   }
   
   private boolean setStatus(boolean flag)
   {
      this.isBooked = flag;
   }
}
