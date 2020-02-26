package com.repository;

import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

import com.model.CustomDate;

public class DateCalculator {

    Map<String, Integer> myMap;
    String allMonths[] = {"JAN", "FEB", "MAR", "APR", "MAY", "JUN", "JUL", "AUG", "SEP", "OCT", "NOV", "DEC"};

    public DateCalculator() {
        this.myMap = new HashMap<>();
        for (int i = 0; i < this.allMonths.length; i++) {
            this.myMap.put(this.allMonths[i], i);
        }
    }

    public CustomDate calculateDate(final CustomDate myDate, final int addMonth, final int addYear) {
        int currentDay = myDate.getDay();
        int currentYear = myDate.getYear();
        String currentMonthString = myDate.getMonth();
        int currentMonth = this.myMap.get(currentMonthString);
        // now adding code for finding new date
        Calendar calendar = Calendar.getInstance();
        calendar.set(currentYear, currentMonth, currentDay);
        calendar.add(Calendar.YEAR, addYear);
        calendar.add(Calendar.MONTH, addMonth);
        CustomDate newDate =
            new CustomDate(calendar.get(Calendar.DATE), this.allMonths[calendar.get(Calendar.MONTH)], calendar.get(Calendar.YEAR));
        return newDate;
    }

}
