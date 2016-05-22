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
   
   private boolean getStatus()
   {
      return this.isBooked;
   }
   
   private void setStatus(boolean flag)
   {
      this.isBooked = flag;
   }
}