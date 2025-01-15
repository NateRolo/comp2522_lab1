package ca.bcit.comp2522.bank;

/**
 * The Main2 class demonstrates a banking system simulation by setting up and printing
 * details for various bank clients using the {@link Name}, {@link Date}, {@link BankClient},
 * and {@link BankAccount} classes. Each client’s account is initialized, detailed information
 * is printed to the console, and a withdrawal operation is performed.
 * <p>
 * The class includes four distinct client setups:
 * <ul>
 *     <li>Albert Einstein</li>
 *     <li>Nelson Mandela</li>
 *     <li>Frida Kahlo</li>
 *     <li>Jackie Chan</li>
 * </ul>
 * </p>
 *
 * @author Nathan Oloresisimo
 * @version 1.0
 */
public class Main2 {

    /**
     * <p>
     * The main method serves as the entry point for the banking system simulation.
     * It sets up and prints account details for various clients by calling the
     * {@link #setupAndPrintAccountDetails(Name, Date, Date, String, Date, Date, int, double, int)} method.
     * </p>
     * <p>
     * Each client's setup includes their name, birth date, death date (if applicable), account number,
     * account opening and closing dates, PIN, initial balance, and a withdrawal amount.
     * </p>
     *
     * The clients and their details are:
     * <ul>
     *     <li>Albert Einstein - Account closed in 1950</li>
     *     <li>Nelson Mandela - Account still open</li>
     *     <li>Frida Kahlo - Account closed in 1954</li>
     *     <li>Jackie Chan - Account still open</li>
     * </ul>
     *
     * @param args command-line arguments (not used).
     */
    public static void main(final String[] args) {
        setupAndPrintAccountDetails(
                new Name("Albert", "Einstein"),
                new Date(1879, 3, 14),
                new Date(1955, 4, 18),
                "#abc123",
                new Date(1900, 1, 1),
                new Date(1950, 10, 14),
                3141,
                1000,
                100);

        setupAndPrintAccountDetails(
                new Name("Nelson", "Mandela"),
                new Date(1918, 7, 18),
                new Date(2013, 12, 5),
                "#654321",
                new Date(1994, 5, 10),
                null, // Account is still open
                4664,
                2000,
                200);

        setupAndPrintAccountDetails(
                new Name("Frida", "Kahlo"),
                new Date(1907, 7, 6),
                new Date(1954, 7, 13),
                "#frd123",
                new Date(1940, 1, 1),
                new Date(1954, 7, 13),
                1907,
                500,
                50);

        setupAndPrintAccountDetails(
                new Name("Jackie", "Chan"),
                new Date(1954, 4, 7),
                null, // Still alive
                "#chan789",
                new Date(1980, 10, 1),
                null, // Account is still open
                1954,
                3000,
                500);
    }


    private static void setupAndPrintAccountDetails(
            final Name name,
            final Date birthDate,
            final Date deathDate,
            final String accountNumber,
            final Date accountOpenedDate,
            final Date accountClosedDate,
            final int pin,
            final double balanceUsd,
            final int withdrawalAmount)
    {
        final StringBuilder outputBuilder;
        final String outputMessage;

        outputBuilder = new StringBuilder();

        BankClient client = new BankClient(name,
                                           birthDate,
                                           deathDate,
                                           accountOpenedDate,
                                           accountNumber);
        BankAccount account = new BankAccount(client,
                                              accountNumber,
                                              accountOpenedDate,
                                              accountClosedDate,
                                              pin,
                                              balanceUsd);


        outputBuilder.append(name.getInitials()).append("\n")
                     .append(name.getFullName()).append("\n")
                     .append(name.getReverseName()).append("\n")
                     .append(client.getDetails()).append("\n")
                     .append(account.getDetails()).append("\n");

        outputMessage = outputBuilder.toString();

        System.out.println(outputMessage);

        // Withdrawal
        account.withdraw(withdrawalAmount, pin);
    }
}
