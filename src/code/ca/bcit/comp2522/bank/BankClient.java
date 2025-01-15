package ca.bcit.comp2522.bank;

public class BankClient
{
    private static final String aliveMessage = "(alive)";
    private static final String notAliveMessage = "(not alive)";

    private final Name name;
    private final Date birthDate;
    private final Date deathDate;

    private final Date signUpDate;
    private final String clientID;

    public BankClient(final Name name,
                      final Date birthDate,
                      final Date deathDate,
                      final Date signUpDate,
                      final String clientID)
    {
        this.name = name;
        this.birthDate = birthDate;
        this.deathDate = deathDate;
        this.signUpDate = signUpDate;
        this.clientID = clientID;
    }

    public BankClient(final Name name,
                      final Date birthDate,
                      final Date signUpDate,
                      final String clientID)
    {
        this(name, birthDate, null, signUpDate, clientID);
    }

    // Tiger Woods client #12345 (alive) joined the bank on thursday, September 3, 2020"
    public String getDetails() {

        final StringBuilder detailsBuilder;
        final String fullName;
        final String client;
        final String clientID;
        final String isAliveStatus;
        final String joinedMessage;
        final String dayOfWeek;
        final String month;
        final int day;
        final int year;

        fullName = this.name.getFullName();
        client = " client ";
        clientID = this.clientID;
        isAliveStatus = this.isAlive();
        joinedMessage = " joined the bank on ";
        dayOfWeek = signUpDate.getDayOfTheWeek();
        month = signUpDate.getMonth();
        day = signUpDate.getDay();
        year = signUpDate.getYear();

        detailsBuilder = new StringBuilder();

        // StringBuilder usage
        detailsBuilder.append(fullName)
                      .append(client)
                      .append(clientID)
                      .append(" ")
                      .append(isAliveStatus)
                      .append(joinedMessage)
                      .append(dayOfWeek)
                      .append(", ")
                      .append(month)
                      .append(" ")
                      .append(day)
                      .append(", ")
                      .append(year)
                      .append(".");

        // Return the final string
        return detailsBuilder.toString();
    }


    public String getFullName()
    {
        final String fullName;

        fullName = this.name.getFullName();

        return fullName;
    }

    private String isAlive()
    {
        if (this.deathDate == null)
        {
            return aliveMessage; // refactor
        } else
        {
            return notAliveMessage; // refactor
        }

    }

}
