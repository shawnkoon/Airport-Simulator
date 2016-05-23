import java.util.ArrayList;

public abstract class Path
{
    private String company;
    private String departure;
    private String destination;
    private int year;
    private int month;
    private int day;
    private String ticketID;
    private ArrayList<Section> sections;

    public Path(String company, String departure, String destination, int year, int month, int day, String ticketID)
    {
        this.company = company;
        this.departure = departure;
        this.destination = destination;
        this.year = year;
        this.month = month;
        this.day = day;
        this.ticketID = ticketID;

        this.sections = new ArrayList<Section>();
    }

    protected String getCompany()
    {
        return this.company;
    }

    protected int getDay()
    {
        return this.day;
    }

    protected String getDeparture()
    {
        return this.departure;
    }

    protected String getDestination()
    {
        return this.destination;
    }

    protected String getID()
    {
        return this.ticketID;
    }

    protected int getMonth()
    {
        return this.month;
    }

    public Section getSection(String seatClass)
    {
        Section currentSection = null;

        if(sections.size() == 0)
        {
            return currentSection;
        }

        for(Section section : sections)
        {
            if(section.getSeatClass().equals(seatClass))
            {
                return section;
            }
        }

        return currentSection;
    }

    protected int getYear()
    {
        return this.year;
    }

    protected void addSection(Section newSection)
    {
        this.sections.add(newSection);
    }

    protected boolean hasSection(String sectionName)
    {
        boolean result = false;

        if(sections.size() == 0)
        {
            return result;
        }

        for(Section section : sections)
        {
            if(section.getSeatClass().equals(sectionName))
            {
                result = true;
                break;
            }
        }

        return result;
    }

    @Override
    public String toString()
    {
        return "\t" + this.getCompany() + "\t\t" + this.getDeparture() + "\t\t\t\t" + this.getDestination();
    }
}
