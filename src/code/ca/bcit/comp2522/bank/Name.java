package ca.bcit.comp2522.bank;

/**
 * Class represents a name object.
 *
 * @author Nathan Oloresisimo
 * @version 1.0
 */
public class Name
{
    private static final int MAX_NAME_LENGTH = 45;
    private static final int FIRST_LETTER = 0;
    private static final int SECOND_LETTER = 1;
    private static final String SPACE = " ";
    private static final String INVALID_NAME = "admin";

    private final String firstName;
    private final String lastName;

    public Name(final String firstName, final String lastName)
    {
        validateName(firstName);
        validateName(lastName);

        this.firstName = firstName;
        this.lastName = lastName;
    }

    public String getFirstName()
    {
        return this.firstName;
    }

    public String getLastName()
    {
        return this.lastName;
    }

    public String getInitials()
    {
        final char firstNameInitial;
        final char lastNameInitial;
        final String fullInitials;

        final StringBuilder builder;

        firstNameInitial = this.firstName.charAt(FIRST_LETTER);
        lastNameInitial = this.lastName.charAt(FIRST_LETTER);
        builder = new StringBuilder();
        builder.append(firstNameInitial)
                .append(".")
                .append(lastNameInitial)
                .append(".");
        fullInitials = builder.toString();

        return fullInitials;
    }

    /**
     * Returns full name as a String.
     * @return full name as a String.
     */
    public String getFullName()
    {
        final String firstNameInitial;
        final String lastNameInitial;
        final String firstNameBody;
        final String lastNameBody;
        final String fullNameFormatted;

        final StringBuilder builder;

        firstNameInitial = firstName.substring(FIRST_LETTER, SECOND_LETTER)
                                    .toUpperCase();
        lastNameInitial = lastName.substring(FIRST_LETTER, SECOND_LETTER)
                                  .toUpperCase();
        firstNameBody = firstName.substring(SECOND_LETTER)
                                 .toLowerCase();
        lastNameBody = lastName.substring(SECOND_LETTER)
                               .toLowerCase();

        builder = new StringBuilder();
        builder.append(firstNameInitial)
                .append(firstNameBody)
                .append(SPACE)
                .append(lastNameInitial)
                .append(lastNameBody);
        fullNameFormatted = builder.toString();

        return fullNameFormatted;
    }

    public String getReverseName()
    {
        final StringBuilder builder;
        final String reversedFullName;

        builder = new StringBuilder();
        builder.append(firstName)
                .append(SPACE)
                .append(lastName);
        builder.reverse();

        reversedFullName = builder.toString();
        return reversedFullName;
    }

    private static void validateName(final String name)
    {
        if (name == null || name.isBlank())
        {
            throw new IllegalArgumentException("Name cannot be null or blank.");
        }
        if (name.length() > MAX_NAME_LENGTH)
        {
            throw new IllegalArgumentException("Name exceeds maximum length of " + MAX_NAME_LENGTH + " characters.");
        }
        if (name.toLowerCase().contains(INVALID_NAME))
        {
            throw new IllegalArgumentException("Name cannot contain the word 'admin'.");
        }
    }
}
