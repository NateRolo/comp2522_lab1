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
    private static final int MAX_DAY_LONG_MONTH = 31;
    private static final int MAX_DAY_FEB = 28;
    private static final int MAX_DAY_FEB_LEAP_YEAR = 29;

    private static final int DIVIDE_FOUR = 4;
    private static final int DIVIDE_ONEHUNDRED = 100;
    private static final int DIVIDE_FOURHUNDRED = 400;

    private static final int NINETEENTH_CENTURY = 1800;
    private static final int TWENTIETH_CENTURY = 1900;
    private static final int TWENTYFIRST_CENTURY = 2000;

    private static final int DIVISOR_FOR_TWELVES_IN_YEAR = 12;
    private static final int DIVISOR_FOR_FOURS_IN_REMAINDER = 4;
    private static final int DIVISOR_FOR_SEVENS_IN_TOTAL = 7;


    private static final String SEPARATE_DATE = "-";

    private static StringBuilder builder;
    private final int year;
    private final int month;
    private final int day;
    private final boolean isLeapYear;

    public Date(final int year, final int month, final int day)
    {
        validateYear(year);
        validateMonth(month);
        validateDay(day, month, year);

        this.year = year;
        this.month = month;
        this.day = day;

        this.isLeapYear = validateLeapYear(year);
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

    public String getYYYYMMDD()
    {
        final String dateFormatted;

        builder = new StringBuilder();
        builder.append(this.year)
                .append(SEPARATE_DATE)
                .append(this.month)
                .append(SEPARATE_DATE)
                .append(this.day);
        dateFormatted = builder.toString();

        return dateFormatted;
    }

    public String getDayOfTheWeek()
    {
        final int yearWithCentury;
        final int yearWithoutCentury;
        final int numOfTwelvesInYear;
        final int remainderOfYears;
        final int numOfFoursInRemainder;
        final int thisMonthCode;
        final int totalWithoutMonthCode;
        final int totalWithMonthCode;
        final int remainderOfTotal;
        final String dayOfWeek;

//      step 1: calculate the number of twelves in 77:
        yearWithCentury = this.year;
        yearWithoutCentury = yearWithCentury - TWENTIETH_CENTURY;
        numOfTwelvesInYear = yearWithoutCentury / DIVISOR_FOR_TWELVES_IN_YEAR;

//      step 2: calculate the remainder from step 1: 77 - 12*6 = 77 - 72 =
        remainderOfYears = yearWithoutCentury - (DIVISOR_FOR_TWELVES_IN_YEAR *
                numOfTwelvesInYear);

//      step 3: calculate the number of fours in step 2: 5/4 = 1.25, so
        numOfFoursInRemainder = remainderOfYears / DIVISOR_FOR_FOURS_IN_REMAINDER;

//      step 4: add the day of the month to each step above: 31 + 6 + 5 + 1 =
        totalWithoutMonthCode = numOfTwelvesInYear + remainderOfYears + numOfFoursInRemainder + this.day;

//      step 5: add the month code (for jfmamjjasond: 144025036146): for october it is 1: 43 + 1 =
        switch (this.month)
        {
            case 1 -> thisMonthCode = 1;
            case 2 -> thisMonthCode = 4;
            case 3 -> thisMonthCode = 4;
            case 4 -> thisMonthCode = 0;
            case 5 -> thisMonthCode = 2;
            case 6 -> thisMonthCode = 0;
            case 7 -> thisMonthCode = 3;
            case 8 -> thisMonthCode = 6;
            case 9 -> thisMonthCode = 1;
            case 10 -> thisMonthCode = 4;
            case 11 -> thisMonthCode = 6;
            case 12 -> thisMonthCode = 1;
            default -> thisMonthCode = 0;
        }
        totalWithMonthCode = totalWithoutMonthCode + thisMonthCode;

//      step 6: add the previous five numbers: (44) and mod by 7: 44%7 = 2 (44/7 = 6 remainder 2)
        remainderOfTotal = totalWithMonthCode / DIVISOR_FOR_SEVENS_IN_TOTAL;

//      step 7: sat sun mon tue wed thu fri is 0 1 2 3 4 5 6; our 2 means Oct 31 1977 was monday
        switch(remainderOfTotal)
        {
            case 1 -> dayOfWeek = "Monday";
            case 2 -> dayOfWeek = "Tuesday";
            case 3 -> dayOfWeek = "Wednesday";
            case 4 -> dayOfWeek = "Thursday";
            case 5 -> dayOfWeek = "Friday";
            case 6 -> dayOfWeek = "Saturday";
            case 7 -> dayOfWeek = "Sunday";
            default -> dayOfWeek = "N/A";
        }
        return dayOfWeek;
    }

    private static void validateYear(final int year)
    {
        if (year < MINIMUM_YEAR || year > CURRENT_YEAR)
        {
            throw new IllegalArgumentException("Invalid year:" + year);
        }
    }

    private static boolean validateLeapYear(final int year)
    {
        return (year % DIVIDE_FOUR == 0 &&
                (year % DIVIDE_ONEHUNDRED != 0 && year % DIVIDE_FOURHUNDRED == 0));
    }

    private static void validateMonth(final int month)
    {
        if (month < JAN || month > DEC)
        {
            throw new IllegalArgumentException("Invalid month: " + month);
        }
    }

    private static void validateDay(final int day, final int month, final int year)
    {
        if (day < MINIMUM_DAY || day > MAX_DAY_LONG_MONTH)
        {
            throw new IllegalArgumentException("Invalid day:" + day);
        }

        if (month == APR || month == JUN || month == SEP || month == NOV &&
            day > MAX_DAY_SHORT_MONTH)
        {
            throw new IllegalArgumentException("Invalid day for this month: " + day);
        }

        if (month == FEB && month > MAX_DAY_FEB_LEAP_YEAR && validateLeapYear(year))
        {
            throw new IllegalArgumentException("Invalid day");
        }
    }


}
