package ca.bcit.comp2522.bank;

public class BankAccount
{
    private final BankClient client;
    private final String accountNumber;
    private final Date accountOpened;
    private final Date accountClosed;
    private final int pin;

    private double balanceUsd;

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

    public void deposit(final double depositUsd, final int pinToMatch)
    {
        if (pinToMatch != pin)
        {
            throw new IllegalArgumentException("Incorrect pin: " + pinToMatch);
        }
        balanceUsd += depositUsd;
    }

    private void withdraw(final double amountUsd)
    {
        balanceUsd -= amountUsd;
    }

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

    private double getBalance()
    {
        return balanceUsd;
    }
    // refactor
    /* Albert Einstein had $900 USD in account #abc123 which he
     * opened on Monday January 1, 1900 and closed Saturday October 14, 1950.
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
