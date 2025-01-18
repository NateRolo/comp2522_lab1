package ca.bcit.comp2522.bank;

/**
 * Represents a bank account belonging to a client.
 * <p>
 * This class encapsulates details about a bank account, including the client,
 * account number, opening and closing dates, a PIN, and the balance in USD.
 * It provides functionality for depositing and withdrawing funds,
 * as well as retrieving account details.
 * </p>
 * Example usage:
 * <pre>
 *     BankAccount account = new BankAccount(client, "abc123", new Date(), 1234, 500.0);
 *     account.deposit(200.0, 1234);
 *     account.withdraw(100.0, 1234);
 * </pre>
 *
 * @author Haider Al-Sudani
 * @author Arsh Mokha
 * @author Nathan Oloresisimo
 * @version 1.0
 */
public class BankAccount
{
    private final BankClient client;
    private final String accountNumber;
    private final Date accountOpened;
    private final Date accountClosed;
    private final int pin;

    private double balanceUsd;

    /**
     * Constructs a BankAccount with all details, including a closing date.
     * <p>
     * This constructor initializes a BankAccount with complete information
     * about the client, account details, and account status.
     * </p>
     * @param client the client who owns the account.
     * @param accountNumber the unique account number.
     * @param accountOpened the date the account was opened.
     * @param accountClosed the date the account was closed.
     * @param pin the personal identification number.
     * @param balanceUsd the initial balance in USD.
     */
    public BankAccount(final BankClient client,
                       final String accountNumber,
                       final Date accountOpened,
                       final Date accountClosed,
                       final int pin,
                       final double balanceUsd)
    {
        this.client = client;
        this.accountNumber = accountNumber;
        this.accountOpened = accountOpened;
        this.accountClosed = accountClosed;
        this.pin = pin;
        this.balanceUsd = balanceUsd;
    }

    /**
     * Constructs a BankAccount with no closing date.
     *
     * @param client the client who owns the account.
     * @param accountNumber the unique account number.
     * @param accountOpened the date the account was opened.
     * @param pin the personal identification number.
     * @param balanceUsd the initial balance in USD.
     */
    public BankAccount(final BankClient client,
                       final String accountNumber,
                       final Date accountOpened,
                       final int pin,
                       final double balanceUsd)
    {
        this(client,
             accountNumber,
             accountOpened,
             null,
             pin,
             balanceUsd);
    }

    /**
     * Deposits a specified amount into the account if the PIN is correct.
     *
     * @param depositUsd the amount to deposit in USD.
     * @param pinToMatch the PIN for verification.
     */
    public void deposit(final double depositUsd, final int pinToMatch)
    {
        if (pinToMatch != pin)
        {
            throw new IllegalArgumentException("Incorrect pin: " + pinToMatch);
        }

        if (depositUsd < 0)
        {
            throw new IllegalArgumentException("Cannot deposit negative amount.");
        }

        balanceUsd += depositUsd;

    }
    /*
     * Withdraws a specified amount from the account without PIN verification.
     */
    private void withdraw(final double amountUsd)
    {
        balanceUsd -= amountUsd;
    }

    /**
     * Withdraws a specified amount from the account if the PIN is correct.
     *
     * @param amountUsd the amount to withdraw in USD.
     * @param pinToMatch the PIN for verification.
     */
    public void withdraw(final double amountUsd, final int pinToMatch)
    {
        if (pinToMatch != pin)
        {
            throw new IllegalArgumentException("Incorrect pin: " + pinToMatch);
        }

        if (amountUsd > balanceUsd)
        {
            throw new IllegalArgumentException("Withdrawal failed, insufficient funds.");
        }

        withdraw(amountUsd);
    }

    /*
     * Retrieves the current balance in USD without PIN verification.
     */
    public double getBalance(final int pinToMatch)
    {
        if (pinToMatch != pin)
        {
            throw new IllegalArgumentException("Incorrect pin: " + pinToMatch);
        }
        return balanceUsd;
    }

    /**
     * <p>
     * Retrieves the details of the bank account, including balance, account number,
     * opening and closing dates, and the client name.
     * </p>
     * Example:
     * <pre>
     *     BankAccount account = new BankAccount(client, "abc123", new Date(), 1234, 500.0);
     *     String details = account.getDetails();
     *     System.out.println(details);
     * </pre>
     *
     * @return a formatted String containing account details.
     */
    public String getDetails()
    {
        final StringBuilder builder;
        final String fullName;
        final String fullDetails;

        fullName = client.getFullName();
        builder = new StringBuilder();

        builder.append(fullName)
               .append(" had $")
               .append(balanceUsd)
               .append(" USD in account ")
               .append(accountNumber)
               .append(" which he opened on ")
               .append(accountOpened.getFullDate());

        if (accountClosed != null)
        {
            builder.append(" and closed on ")
                   .append(accountClosed.getFullDate())
                   .append(".");
        } else
        {
            builder.append(" and is still open.");
        }

        fullDetails = builder.toString();

        return fullDetails;
    }

}
