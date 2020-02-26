package com.model;

public class CustomDate {

    private int day;
    private String month;
    private int year;

    public CustomDate() {
        super();
        // TODO Auto-generated constructor stub
    }

    public CustomDate(final int day, final String month, final int year) {
        this.day = day;
        this.month = month.toUpperCase();
        this.year = year;
    }

    public int getDay() {
        return this.day;
    }

    public void setDay(final int day) {
        this.day = day;
    }

    public String getMonth() {
        return this.month;
    }

    public void setMonth(final String month) {
        this.month = month;
    }

    public int getYear() {
        return this.year;
    }

    public void setYear(final int year) {
        this.year = year;
    }


}
