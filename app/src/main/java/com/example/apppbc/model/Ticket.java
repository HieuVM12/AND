package com.example.apppbc.model;

public class Ticket {
    private Long id;
    private String name;
    private String film;
    private String day;
    private String month;
    private String hour;


    public Ticket(Long id, String name, String film, String day, String month, String hour) {
        this.id = id;
        this.name = name;
        this.film = film;
        this.day = day;
        this.month = month;
        this.hour = hour;

    }
    public Ticket() {


    }

    @Override
    public String toString() {
        return "Ticket{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", film='" + film + '\'' +
                ", day='" + day + '\'' +
                ", month='" + month + '\'' +
                ", hour='" + hour + '\'' +
                '}';
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFilm() {
        return film;
    }

    public void setFilm(String film) {
        this.film = film;
    }

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public String getMonth() {
        return month;
    }

    public void setMonth(String month) {
        this.month = month;
    }

    public String getHour() {
        return hour;
    }

    public void setHour(String hour) {
        this.hour = hour;
    }


}
