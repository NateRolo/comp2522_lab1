package ca.bcit.comp2522.bank;

public class Main2 {

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
                100
                                   );

        setupAndPrintAccountDetails(
                new Name("Nelson", "Mandela"),
                new Date(1918, 7, 18),
                new Date(2013, 12, 5),
                "#654321",
                new Date(1994, 5, 10),
                null, // Account is still open
                4664,
                2000,
                200
                                   );

        setupAndPrintAccountDetails(
                new Name("Frida", "Kahlo"),
                new Date(1907, 7, 6),
                new Date(1954, 7, 13),
                "#frd123",
                new Date(1940, 1, 1),
                new Date(1954, 7, 13),
                1907,
                500,
                50
                                   );

        setupAndPrintAccountDetails(
                new Name("Jackie", "Chan"),
                new Date(1954, 4, 7),
                null, // Still alive
                "#chan789",
                new Date(1980, 10, 1),
                null, // Account is still open
                1954,
                3000,
                500
                                   );
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
