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
    private static final int FIRST_INDEX = 0;
    private static final int SECOND_INDEX = 1;
    private static final String SPACE = " ";
    private static final String INVALID_NAME = "admin";

    private static StringBuilder builder;

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

        firstNameInitial = this.firstName.charAt(FIRST_INDEX);
        lastNameInitial = this.lastName.charAt(FIRST_INDEX);
        builder = new StringBuilder();
        builder.append(firstNameInitial);
        builder.append(".");
        builder.append(lastNameInitial);
        builder.append(".");
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

        firstNameInitial = firstName.substring(FIRST_INDEX, SECOND_INDEX);
        lastNameInitial = lastName.substring(FIRST_INDEX, SECOND_INDEX);
        firstNameBody = firstName.substring(SECOND_INDEX);
        lastNameBody = lastName.substring(SECOND_INDEX);

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
        if (name == null || name.isBlank() || name.length() > MAX_NAME_LENGTH || name.contains(INVALID_NAME))
        {
            throw new IllegalArgumentException("bad name: " + name);
        }
    }
}
