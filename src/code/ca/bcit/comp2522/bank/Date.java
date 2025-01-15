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

    private static final int MONTH_CODE_1 = 1;
    private static final int MONTH_CODE_2 = 2;
    private static final int MONTH_CODE_3 = 3;
    private static final int MONTH_CODE_4 = 4;
    private static final int MONTH_CODE_6 = 6;
    private static final int MONTH_CODE_0 = 0;

    private static final int SATURDAY_RESULT = 0;
    private static final int SUNDAY_RESULT = 1;
    private static final int MONDAY_RESULT = 2;
    private static final int TUESDAY_RESULT = 3;
    private static final int WEDNESDAY_RESULT = 4;
    private static final int THURSDAY_RESULT = 5;
    private static final int FRIDAY_RESULT = 6;

    private static final int MINIMUM_DAY = 1;
    private static final int MAX_DAY_SHORT_MONTH = 30;
    private static final int MAX_DAY_LONG_MONTH = 31;
    private static final int MAX_DAY_FEB = 28;
    private static final int MAX_DAY_FEB_LEAP_YEAR = 29;

    private static final int LEAP_YEAR_RULE = 4;
    private static final int NON_LEAP_CENTURY_RULE = 100;
    private static final int LEAP_CENTURY_RULE = 400;
    private static final int NO_REMAINDER = 0;

    private static final int NINETEENTH_CENTURY = 1800;
    private static final int TWENTIETH_CENTURY = 1900;
    private static final int TWENTY_FIRST_CENTURY = 2000;

    private static final int NINETEENTH_CENTURY_OFFSET = 2;
    private static final int TWENTY_FIRST_CENTURY_OFFSET = 6;
    private static final int LEAP_YEAR_OFFSET = 6;

    private static final int DIVISOR_FOR_TWELVES_IN_YEAR = 12;
    private static final int DIVISOR_FOR_FOURS_IN_REMAINDER = 4;
    private static final int DIVISOR_FOR_SEVENS_IN_TOTAL = 7;

//    private static final String SEPARATE_DATE = "-";
    private static final String SPACE = " ";

    private final int year;
    private final int month;
    private final int day;

    public Date(final int year, final int month, final int day)
    {
        validateYear(year);
        validateMonth(month);
        validateDay(day, month, year);

        this.year = year;
        this.month = month;
        this.day = day;
    }

    public int getYear()
    {
        return this.year;
    }

    public String getMonth()
    {
        final String monthAsString;

        switch(this.month)
        {
            case JAN -> monthAsString = "January";
            case FEB -> monthAsString = "February";
            case MAR -> monthAsString = "March";
            case APR -> monthAsString = "April";
            case MAY -> monthAsString = "May";
            case JUN -> monthAsString = "June";
            case JUL -> monthAsString = "July";
            case AUG -> monthAsString = "August";
            case SEP -> monthAsString = "September";
            case OCT -> monthAsString = "October";
            case NOV -> monthAsString = "November";
            case DEC -> monthAsString = "December";
            default -> monthAsString = "N/A";
        }
        return monthAsString;
    }

    public int getDay()
    {
        return this.day;
    }

    public String getYYYYMMDD()
    {
        StringBuilder builder;
        final String dateFormatted;

        builder = new StringBuilder();
        builder.append(this.year)
                .append("-")
                .append(this.month)
                .append("-")
                .append(this.day);
        dateFormatted = builder.toString();

        return dateFormatted;
    }

    public String getDayOfTheWeek()
    {
        final int lastTwoDigitsOfYear;
        final int dayOfMonth;
        final int numberOfTwelvesInYear;
        final int yearRemainderAfterTwelves;
        final int numOfFoursInRemainder;
        final int thisMonthCode;
        final int totalWithoutMonthCode;
        final int totalWithMonthCode;
        final int remainderOfTotal;
        final String dayOfWeek;
        int fullYear;

//      step 1: calculate the number of twelves year
        fullYear = this.year;
        dayOfMonth = this.day;

        if (isLeapYear(this.year) && (this.month == JAN || this.month == FEB))
        {
            fullYear += LEAP_YEAR_OFFSET;
        }

        if (this.year >= NINETEENTH_CENTURY && this.year < TWENTIETH_CENTURY)
        {
            fullYear += NINETEENTH_CENTURY_OFFSET;
        }

        if (this.year >= TWENTY_FIRST_CENTURY)
         {
            fullYear += TWENTY_FIRST_CENTURY_OFFSET;
        }

        lastTwoDigitsOfYear = fullYear - TWENTIETH_CENTURY;
        numberOfTwelvesInYear = lastTwoDigitsOfYear / DIVISOR_FOR_TWELVES_IN_YEAR;

//      step 2: calculate the remainder from step 1: 77 - 12*6 = 77 - 72 =
        yearRemainderAfterTwelves = lastTwoDigitsOfYear - (DIVISOR_FOR_TWELVES_IN_YEAR *
                numberOfTwelvesInYear);

//      step 3: calculate the number of fours in step 2: 5/4 = 1.25, so
        numOfFoursInRemainder = yearRemainderAfterTwelves / DIVISOR_FOR_FOURS_IN_REMAINDER;

//      step 4: add the day of the month to each step above: 31 + 6 + 5 + 1 =
        totalWithoutMonthCode = numberOfTwelvesInYear + yearRemainderAfterTwelves + numOfFoursInRemainder + dayOfMonth;

//      step 5: add the month code (for jfmamjjasond: 144025036146): for october it is 1: 43 + 1 =
        switch (this.month)
        {
            case JAN, SEP, DEC -> thisMonthCode = MONTH_CODE_1;
            case FEB, MAR, OCT -> thisMonthCode = MONTH_CODE_4;
            case APR, JUN -> thisMonthCode = MONTH_CODE_0;
            case MAY -> thisMonthCode = MONTH_CODE_2;
            case JUL -> thisMonthCode = MONTH_CODE_3;
            case AUG, NOV -> thisMonthCode = MONTH_CODE_6;
            default -> throw new IllegalArgumentException("Inavlid month: " + this.month);
        }
        totalWithMonthCode = totalWithoutMonthCode + thisMonthCode;

//      step 6: add the previous five numbers: (44) and mod by 7: 44%7 = 2 (44/7 = 6 remainder 2)
        remainderOfTotal = totalWithMonthCode % DIVISOR_FOR_SEVENS_IN_TOTAL;

//      step 7: sat sun mon tue wed thu fri is 0 1 2 3 4 5 6; our 2 means Oct 31 1977 was monday
        switch(remainderOfTotal)
        {
            case SATURDAY_RESULT -> dayOfWeek = "Saturday";
            case SUNDAY_RESULT -> dayOfWeek = "Sunday";
            case MONDAY_RESULT -> dayOfWeek = "Monday";
            case TUESDAY_RESULT -> dayOfWeek = "Tuesday";
            case WEDNESDAY_RESULT -> dayOfWeek = "Wednesday";
            case THURSDAY_RESULT -> dayOfWeek = "Thursday";
            case FRIDAY_RESULT -> dayOfWeek = "Friday";
            default -> dayOfWeek = "N/A";
        }
        return dayOfWeek;
    }

    public String getFullDate()
    {
        StringBuilder builder;
        final String dayOfWeek;
        final String month;
        final int dayOfMonth;
        final int year;
        final String fullDate;

        builder = new StringBuilder();
        dayOfWeek = this.getDayOfTheWeek();
        month = this.getMonth();
        dayOfMonth = this.day;
        year = this.year;

        builder.append(dayOfWeek)
               .append(SPACE)
               .append(month)
               .append(SPACE)
               .append(dayOfMonth)
               .append(",")
               .append(SPACE)
               .append(year);
        fullDate = builder.toString();

        return fullDate;
    }

    private static void validateYear(final int year)
    {
        if (year < MINIMUM_YEAR || year > CURRENT_YEAR)
        {
            throw new IllegalArgumentException("Invalid year:" + year);
        }
    }

    private static boolean isLeapYear(final int year)
    {
        return (year % LEAP_YEAR_RULE == NO_REMAINDER &&
                (year % NON_LEAP_CENTURY_RULE != NO_REMAINDER || year % LEAP_CENTURY_RULE == NO_REMAINDER));
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

        if ((month == APR || month == JUN || month == SEP || month == NOV) &&
            day > MAX_DAY_SHORT_MONTH)
        {
            throw new IllegalArgumentException("Invalid day for this month: " + day);
        }

        if (month == FEB && day > (isLeapYear(year) ? MAX_DAY_FEB_LEAP_YEAR : MAX_DAY_FEB))
        {
            throw new IllegalArgumentException("Invalid day: " + day + " for month: " + month + " in year: " + year);
        }
    }
}
