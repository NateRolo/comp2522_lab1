package ca.bcit.comp2522.bank;

public class NameDriver
{
    public static void main(final String[] args)
    {
        Name name1 = new Name("George", "Bloggs");

        Date date1 = new Date(2000, 2, 29);

        String name1initials = name1.getInitials();
        String name1fullname = name1.getFullName();
        String name1reversed = name1.getReverseName();
        String name1FirstName = name1.getFirstName();
        String name1LastName = name1.getLastName();

        System.out.println(date1.getFullDate());

        System.out.println(name1initials);
        System.out.println(name1reversed);
        System.out.println(name1fullname);
        System.out.println(name1FirstName);
        System.out.println(name1LastName);
    }
}
