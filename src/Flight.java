public class Flight extends Path
{
    public Flight(String company, String depart, String destination, int year, int month, int day, String ticketID)
    {
        super(company, depart, destination, year, month, day, ticketID);
    }

    public Flight(String company, String depart, String destination, int year, int month, int day, int hour, int min, String ticketID)
    {
        super(company, depart, destination, year, month, day, hour, min, ticketID);
    }

    public String printInfo()
    {
        String output = "\tCOMPANY\t\tDEPARTURE\t\tDESTINATION\t\tYEAR\t\tMONTH\t\tDAY\t\tTICKET ID\n\n"
                + "\t" + super.getCompany() + "\t\t" + super.getDeparture() + "\t\t\t\t" + super.getDestination()
                + "\t\t\t\t" + super.getYear() + "\t\t" + super.getMonth() + "\t\t\t" + super.getDay() + "\t\t"
                + super.getID();

        return output;
    }
}