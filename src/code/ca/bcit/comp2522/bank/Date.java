package ca.bcit.comp2522.bank;

public class Date
{
    private static final int MINIMUM_YEAR = 1800;
    private static final int CURRENT_YEAR = 2025;

    private static final int JAN = 1;
    private static final int FEB = 2;
    private static final int MAR = 3;
    private static final int APR = 4;
    private static final int MAY = 5;
    private static final int JUN = 6;
    private static final int JUL = 7;
    private static final int AUG = 8;
    private static final int SEP = 9;
    private static final int OCT = 10;
    private static final int NOV = 11;
    private static final int DEC = 12;


    private static final int MINIMUM_DAY = 0;
    private static final int MAX_DAY_SHORT_MONTH = 30;
    private static final int MAX_DAY_LONGMONTH = 31;
    private static final int MAX_DAY_FEB = 28;
    private static final int MAX_DAY_FEB_LEAP_YEAR = 29;
    private static final int CAN_DIVIDE_BY = 4;
    private static final int LEAP_YEAR_FACTOR_100 = 100;
    private static final int LEAP_YEAR_FACTOR_400 = 400;

    private final int year;
    private final int month;
    private final int day;
    private final boolean isLeapYear;

    public Date(final int year, final int month, final int day)
    {
        validateYear(year);
        validateMonth(month);
        validateDay(day, month);

        this.year = year;
        this.month = month;
        this.day = day;
    }

    public int getYear()
    {
        return this.year;
    }

    public int getMonth()
    {
        return this.month;
    }

    public int getDay()
    {
        return this.day;
    }

//    public String getYYYYMMDD()
//    {
//
//    }
//
//    public String getDayOfTheWeek()
//    {
//
//    }

    private static void validateYear(final int year)
    {
        if (year < MINIMUM_YEAR || year > CURRENT_YEAR)
        {
            throw new IllegalArgumentException("Invalid year:" + year);
        }

        isLeapYear(year);
    }

    private static void isLeapYear(final int year)
    {

    }

    private static void validateMonth(final int month)
    {

    }

    private static void validateDay(final int day, final int month)
    {

    }
}
