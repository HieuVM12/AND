package com.example.apppbc.model;

import java.io.Serializable;
import java.util.List;

public class Schedule implements Serializable {
    private Long id;

    private List<Date> date;

    private List<Theater> theater;

    public Schedule(Long id, List<Date> date, List<Theater> theater) {
        this.id = id;
        this.date = date;
        this.theater = theater;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<Date> getDate() {
        return date;
    }

    public void setDate(List<Date> date) {
        this.date = date;
    }

    public List<Theater> getTheater() {
        return theater;
    }

    public void setTheater(List<Theater> theater) {
        this.theater = theater;
    }
}
