package ca.bcit.comp2522.bank;

/**
 * Class represents a name object.
 * <p>
 * This class encapsulates a name with a first name and last name,
 * providing methods to retrieve initials, formatted full name,
 * and reversed name.
 * </p>
 * Example usage:
 * <pre>
 *     Name name = new Name("John", "Doe");
 *     String initials = name.getInitials();  // Output: J.D.
 * </pre>
 *
 * @author Nathan Oloresisimo
 * @version 1.0
 */
public class Name
{
    private static final int MAX_NAME_LENGTH = 45;
    private static final int FIRST_LETTER = 0;
    private static final int SECOND_LETTER = 1;

    private static final String INVALID_NAME = "admin";

    private final String firstName;
    private final String lastName;

    /**
     * Constructs a Name object with the specified first and last name.
     *
     * @param firstName the first name of the individual.
     * @param lastName the last name of the individual.
     * @throws IllegalArgumentException if the first or last name is invalid.
     */
    public Name(final String firstName,
                final String lastName)
    {
        validateName(firstName);
        validateName(lastName);

        this.firstName = firstName;
        this.lastName = lastName;
    }

    /**
     * Retrieves the first name of the individual.
     *
     * @return the first name as a String.
     */
    public String getFirstName()
    {
        return this.firstName;
    }

    /**
     * Retrieves the last name of the individual.
     *
     * @return the last name as a String.
     */
    public String getLastName()
    {
        return this.lastName;
    }

    /**
     * Retrieves the initials of the individual's name.
     *
     * Example usage:
     * <pre>
     *     Name name = new Name("John", "Doe");
     *     String initials = name.getInitials();  // Output: J.D.
     * </pre>
     *
     * @return the initials in the format "F.L."
     */
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
     * Returns the full name of the individual in a formatted style.
     * <p>
     * The first letters of the first and last names are capitalized,
     * and the rest are in lowercase.
     * </p>
     * Example usage:
     * <pre>
     *     Name name = new Name("john", "doe");
     *     String fullName = name.getFullName();  // Output: John Doe
     * </pre>
     *
     * @return the formatted full name as a String.
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
                .append(" ")
                .append(lastNameInitial)
                .append(lastNameBody);
        fullNameFormatted = builder.toString();

        return fullNameFormatted;
    }

    /**
     * Retrieves the reversed full name.
     *
     * Example usage:
     * <pre>
     *     Name name = new Name("John", "Doe");
     *     String reversedName = name.getReverseName();  // Output: eoD nhoJ
     * </pre>
     *
     * @return the reversed full name as a String.
     */
    public String getReverseName()
    {
        final StringBuilder builder;
        final String reversedFullName;

        builder = new StringBuilder();
        builder.append(firstName)
               .append(" ")
               .append(lastName);
        builder.reverse();

        reversedFullName = builder.toString();
        return reversedFullName;
    }

    /*
     * Validates the name string to ensure it meets criteria:
     * - Cannot be null or blank.
     * - Cannot exceed the maximum length.
     * - Cannot contain the invalid substring "admin".
     *
     * @param name the name to validate.
     * @throws IllegalArgumentException if the name is invalid.
     */
    private static void validateName(final String name)
    {
        if (name == null || name.isBlank())
        {
            throw new IllegalArgumentException("Name cannot be null or blank.");
        }
        if (name.length() > MAX_NAME_LENGTH)
        {
            throw new IllegalArgumentException("Name exceeds maximum length of " +
                                               MAX_NAME_LENGTH +
                                               " characters.");
        }
        if (name.toLowerCase().contains(INVALID_NAME))
        {
            throw new IllegalArgumentException("Name cannot contain the word 'admin'.");
        }
    }
}
