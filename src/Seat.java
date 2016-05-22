public class Seat 
{
   private int row;
   private String col;
   private boolean isBooked;
   
   public Seat(int row, String col)
   {
      this.row = row;
      this.col = col;
      this.isBooked = false;
   }

   public boolean isBooked()
   {
      return this.isBooked;
   }
   
   public void bookSeat(boolean flag)
   {
      this.isBooked = flag;
   }
}