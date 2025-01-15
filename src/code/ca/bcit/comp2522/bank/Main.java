package ca.bcit.comp2522.bank;

/**
 * The Main class serves as the entry point for the banking system simulation.
 * It sets up and prints account details for various bank clients using
 * the {@link Name}, {@link Date}, {@link BankClient}, and {@link BankAccount} classes.
 * Each client's account is created, detailed information is printed, and a withdrawal operation is performed.
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
public class Main
{
    /**
     * The main method is the entry point for the banking system simulation.
     * It calls methods to set up and print account details for each client.
     * <p>
     * The clients and their details are:
     * <ul>
     *     <li>Albert Einstein (account closed)</li>
     *     <li>Nelson Mandela (account still open)</li>
     *     <li>Frida Kahlo (account closed)</li>
     *     <li>Jackie Chan (account still open)</li>
     * </ul>
     * </p>
     * @param args command-line arguments (not used).
     */
    public static void main(final String[] args)
    {
        einsteinSetupAndPrintAccountDetails();
        mandelaSetupAndPrintAccountDetails();
        kahloSetupAndPrintAccountDetails();
        chanSetupAndPrintAccountDetails();
    }
    // Albert Einstein's account details
    private static void einsteinSetupAndPrintAccountDetails()
    {
        final Name        albertEinstein;
        final Date        aeBirthDate;
        final Date        aeDeathDate;
        final Date        aeAccountOpenedDate;
        final Date        aeAccountClosedDate;
        final int         aePin;
        final int         aeBalanceUsd;
        final String      aeAccountNumber;
        final BankClient  aeClientInfo;
        final BankAccount aeBankAccount;

        final String initials;
        final String fullName;
        final String reverseName;
        final String clientDetails;
        final String accountDetails;

        final StringBuilder outputBuilder;
        final String aeFullDetails;

        final int    withdrawalAmount;

        albertEinstein      = new Name("Albert", "Einstein");
        aeBirthDate         = new Date(1879, 3, 14);
        aeDeathDate         = new Date(1955, 4, 18);
        aeAccountOpenedDate = new Date(1900, 1, 1);
        aeAccountClosedDate = new Date(1950, 10, 14);
        aePin               = 3141;
        aeBalanceUsd        = 1000;
        aeAccountNumber     = "#abc123";

        aeClientInfo  = new BankClient(albertEinstein,
                                       aeBirthDate,
                                       aeDeathDate,
                                       aeAccountOpenedDate,
                                       aeAccountNumber);
        aeBankAccount = new BankAccount(aeClientInfo,
                                        aeAccountNumber,
                                        aeAccountOpenedDate,
                                        aeAccountClosedDate,
                                        aePin,
                                        aeBalanceUsd);

        initials       = albertEinstein.getInitials();
        fullName       = albertEinstein.getFullName();
        reverseName    = albertEinstein.getReverseName();
        clientDetails  = aeClientInfo.getDetails();
        accountDetails = aeBankAccount.getDetails();

        withdrawalAmount = 100;



        outputBuilder = new StringBuilder();

        outputBuilder.append(initials).append("\n")
                     .append(fullName).append("\n")
                     .append(reverseName).append("\n")
                     .append(clientDetails).append("\n")
                     .append(accountDetails).append("\n");

        aeFullDetails = outputBuilder.toString();

        System.out.println(aeFullDetails);


        aeBankAccount.withdraw(withdrawalAmount, aePin);
    }
    // Nelson Mandela's Account Details
    private static void mandelaSetupAndPrintAccountDetails() {
        final Name nelsonMandela;
        final Date nmBirthDate;
        final Date nmDeathDate;
        final Date nmAccountOpenedDate;
        final Date nmAccountClosedDate;
        final int nmPin;
        final int nmBalanceUsd;
        final String nmAccountNumber;
        final BankClient nmClientInfo;
        final BankAccount nmBankAccount;

        final String nmInitials;
        final String nmFullName;
        final String nmReverseName;
        final String nmClientDetails;
        final String nmAccountDetails;

        final StringBuilder outputBuilder;
        final String nmFullDetails;

        final int withdrawalAmount;

        nelsonMandela      = new Name("Nelson", "Mandela");
        nmBirthDate        = new Date(1918, 7, 18);
        nmDeathDate        = new Date(2013, 12, 5);
        nmAccountOpenedDate = new Date(1994, 5, 10);
        nmAccountClosedDate = null;
        nmPin              = 4664;
        nmBalanceUsd       = 2000;
        nmAccountNumber    = "#654321";

        nmClientInfo  = new BankClient(nelsonMandela,
                                       nmBirthDate,
                                       nmDeathDate,
                                       nmAccountOpenedDate,
                                       nmAccountNumber);

        nmBankAccount = new BankAccount(nmClientInfo,
                                        nmAccountNumber,
                                        nmAccountOpenedDate,
                                        nmAccountClosedDate,
                                        nmPin,
                                        nmBalanceUsd);

        nmInitials       = nelsonMandela.getInitials();
        nmFullName       = nelsonMandela.getFullName();
        nmReverseName    = nelsonMandela.getReverseName();
        nmClientDetails  = nmClientInfo.getDetails();
        nmAccountDetails = nmBankAccount.getDetails();

        withdrawalAmount = 200;

        outputBuilder = new StringBuilder();

        outputBuilder.append(nmInitials).append("\n")
                     .append(nmFullName).append("\n")
                     .append(nmReverseName).append("\n")
                     .append(nmClientDetails).append("\n")
                     .append(nmAccountDetails).append("\n");

        nmFullDetails = outputBuilder.toString();

        System.out.println(nmFullDetails);


        nmBankAccount.withdraw(withdrawalAmount, nmPin);
    }

    // Frida Kahlo's Account Details
    private static void kahloSetupAndPrintAccountDetails()
    {
        final Name fridaKahlo;
        final Date fkBirthDate;
        final Date fkDeathDate;
        final Date fkAccountOpenedDate;
        final Date fkAccountClosedDate;
        final int fkPin;
        final int fkBalanceUsd;
        final String fkAccountNumber;
        final BankClient fkClientInfo;
        final BankAccount fkBankAccount;

        final String fkInitials;
        final String fkFullName;
        final String fkReverseName;
        final String fkClientDetails;
        final String fkAccountDetails;

        final StringBuilder outputBuilder;
        final String fkFullDetails;

        final int withdrawalAmount;


        fridaKahlo        = new Name("Frida", "Kahlo");
        fkBirthDate       = new Date(1907, 7, 6);
        fkDeathDate       = new Date(1954, 7, 13);
        fkAccountOpenedDate = new Date(1940, 1, 1);
        fkAccountClosedDate = new Date(1954, 7, 13);
        fkPin             = 1907;
        fkBalanceUsd      = 500;
        fkAccountNumber   = "#frd123";

        fkClientInfo  = new BankClient(fridaKahlo,
                                       fkBirthDate,
                                       fkDeathDate,
                                       fkAccountOpenedDate,
                                       fkAccountNumber);

        fkBankAccount = new BankAccount(fkClientInfo,
                                        fkAccountNumber,
                                        fkAccountOpenedDate,
                                        fkAccountClosedDate,
                                        fkPin,
                                        fkBalanceUsd);

        fkInitials       = fridaKahlo.getInitials();
        fkFullName       = fridaKahlo.getFullName();
        fkReverseName    = fridaKahlo.getReverseName();
        fkClientDetails  = fkClientInfo.getDetails();
        fkAccountDetails = fkBankAccount.getDetails();

        withdrawalAmount = 50;

        outputBuilder = new StringBuilder();

        outputBuilder.append(fkInitials).append("\n")
                     .append(fkFullName).append("\n")
                     .append(fkReverseName).append("\n")
                     .append(fkClientDetails).append("\n")
                     .append(fkAccountDetails).append("\n");

        fkFullDetails = outputBuilder.toString();
        System.out.println(fkFullDetails);


        fkBankAccount.withdraw(withdrawalAmount, fkPin);
    }

    // Jackie Chan's Account Details
    private static void chanSetupAndPrintAccountDetails()
    {
        final Name jackieChan;
        final Date jcBirthDate;
        final Date jcAccountOpenedDate;
        final Date jcAccountClosedDate;
        final int jcPin;
        final int jcBalanceUsd;
        final String jcAccountNumber;
        final BankClient jcClientInfo;
        final BankAccount jcBankAccount;

        final String jcInitials;
        final String jcFullName;
        final String jcReverseName;
        final String jcClientDetails;
        final String jcAccountDetails;

        final StringBuilder outputBuilder;
        final String jcFullDetails;

        final int withdrawalAmount;


        jackieChan        = new Name("Jackie", "Chan");
        jcBirthDate       = new Date(1954, 4, 7);
        jcAccountOpenedDate = new Date(1980, 10, 1);
        jcAccountClosedDate = null;
        jcPin             = 1954;
        jcBalanceUsd      = 3000;
        jcAccountNumber   = "#chan789";

        jcClientInfo  = new BankClient(jackieChan,
                                       jcBirthDate,
                                       jcAccountOpenedDate,
                                       jcAccountNumber);

        jcBankAccount = new BankAccount(jcClientInfo,
                                        jcAccountNumber,
                                        jcAccountOpenedDate,
                                        jcAccountClosedDate,
                                        jcPin,
                                        jcBalanceUsd);

        jcInitials       = jackieChan.getInitials();
        jcFullName       = jackieChan.getFullName();
        jcReverseName    = jackieChan.getReverseName();
        jcClientDetails  = jcClientInfo.getDetails();
        jcAccountDetails = jcBankAccount.getDetails();

        withdrawalAmount = 500;

        outputBuilder = new StringBuilder();

        outputBuilder.append(jcInitials).append("\n")
                     .append(jcFullName).append("\n")
                     .append(jcReverseName).append("\n")
                     .append(jcClientDetails).append("\n")
                     .append(jcAccountDetails).append("\n");

        jcFullDetails = outputBuilder.toString();

        System.out.println(jcFullDetails);

        jcBankAccount.withdraw(withdrawalAmount, jcPin);
    }
}
