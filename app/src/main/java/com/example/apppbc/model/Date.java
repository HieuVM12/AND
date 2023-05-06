package com.example.apppbc.model;

import java.io.Serializable;

public class Date implements Serializable {
    private Long id;
    private String date;
    private String month;
    private String year;

    public Date(Long id, String date, String month, String year) {
        this.id = id;
        this.date = date;
        this.month = month;
        this.year = year;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getMonth() {
        return month;
    }

    public void setMonth(String month) {
        this.month = month;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }
}
