public class Seat 
{
   private int row;
   private char col;
   private boolean isBooked;
   
   public Seat(int row, char col)
   {
      this.row = row;
      this.col = col;
      this.isBooked = false;
   }

   public boolean isBooked()
   {
      return this.isBooked;
   }
   
   public void setBookedStatus(boolean flag)
   {
      this.isBooked = flag;
   }

   public int getRow()
   {
      return this.row;
   }

   public char getCol()
   {
      return this.col;
   }
}