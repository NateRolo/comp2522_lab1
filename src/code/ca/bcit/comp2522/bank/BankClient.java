package ca.bcit.comp2522.bank;

/**
 * Represents a bank client.
 * <p>
 * This class encapsulates information about a bank client, including their name,
 * birth date, death date (if applicable), sign-up date, and client ID. It also provides
 * methods to retrieve the client's details and full name, and to check if the client is alive.
 * </p>
 * Example usage:
 * <pre>
 *     Name clientName = new Name("John", "Doe");
 *     Date birthDate = new Date(1990, 1, 1);
 *     Date signUpDate = new Date(2020, 5, 15);
 *     BankClient client = new BankClient(clientName, birthDate, signUpDate, "C12345");
 *     System.out.println(client.getDetails());
 * </pre>
 *
 * @author Haider Al-Sudani
 * @author Arsh Mokha
 * @author Nathan Oloresisimo
 * @version 1.0
 */
public class BankClient
{
    private static final String aliveMessage = "(alive)";
    private static final String notAliveMessage = "(not alive)";

    private final Name name;
    private final Date birthDate;
    private final Date deathDate;

    private final Date signUpDate;
    private final String clientID;

    /**
     * Constructs a BankClient with all details, including a death date.
     *
     * @param name the client's name.
     * @param birthDate the client's birth date.
     * @param deathDate the client's death date, or null if the client is alive.
     * @param signUpDate the date the client signed up with the bank.
     * @param clientID the unique identifier for the client.
     */
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

    /**
     * Constructs a BankClient who is still alive.
     *
     * @param name the client's name.
     * @param birthDate the client's birth date.
     * @param signUpDate the date the client signed up with the bank.
     * @param clientID the unique identifier for the client.
     */
    public BankClient(final Name name,
                      final Date birthDate,
                      final Date signUpDate,
                      final String clientID)
    {
        this(name, birthDate, null, signUpDate, clientID);
    }

    /**
     * Retrieves the details of the bank client.
     * <p>
     * The details include the client's full name, client ID, their alive status,
     * and the date they joined the bank.
     * </p>
     * Example usage:
     * <pre>
     *     BankClient client = new BankClient(name, birthDate, signUpDate, "C12345");
     *     String details = client.getDetails();
     *     System.out.println(details);
     * </pre>
     *
     * @return a formatted String containing the client's details.
     */
    public String getDetails() {

        final StringBuilder detailsBuilder;
        final String fullName;

        final String clientID;
        final String isAliveStatus;

        final String dayOfWeek;
        final String month;
        final int day;
        final int year;

        fullName = this.name.getFullName();
        clientID = this.clientID;
        isAliveStatus = this.isAlive();

        dayOfWeek = signUpDate.getDayOfTheWeek();
        month = signUpDate.getMonth();
        day = signUpDate.getDay();
        year = signUpDate.getYear();

        detailsBuilder = new StringBuilder();


        detailsBuilder.append(fullName)
                      .append(" client ")
                      .append(clientID)
                      .append(" ")
                      .append(isAliveStatus)
                      .append(" joined the bank on ")
                      .append(dayOfWeek)
                      .append(", ")
                      .append(month)
                      .append(" ")
                      .append(day)
                      .append(", ")
                      .append(year)
                      .append(".");


        return detailsBuilder.toString();
    }

    /**
     * Retrieves the full name of the client.
     * <p>
     * Example usage:
     * <pre>
     *     BankClient client = new BankClient(name, birthDate, signUpDate, "C12345");
     *     String fullName = client.getFullName();
     *     System.out.println(fullName);
     * </pre>
     * </p>
     *
     * @return the full name of the client as a String.
     */
    public String getFullName()
    {
        final String fullName;

        fullName = this.name.getFullName();

        return fullName;
    }

    /*
     * Checks if the object is considered "alive" based on its `deathDate`.
     *
     * @return A message indicating whether the object is alive or not:
     *         - Returns `aliveMessage` if `deathDate` is null.
     *         - Returns `notAliveMessage` otherwise.
     */
    private String isAlive()
    {
        if (this.deathDate == null)
        {
            return aliveMessage;
        }

        return notAliveMessage;
    }

}
