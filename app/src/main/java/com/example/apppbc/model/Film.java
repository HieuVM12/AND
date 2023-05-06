package com.example.apppbc.model;

import java.io.Serializable;

public class Film implements Serializable {
    private Long id;
    private String title;
    private String des;
    private String director;
    private String time;
    private String category;
    private int srcImg;
    private String age;
    private Schedule schedule;
    public Film(Long id, String title, String des, String director, String time, String category, int srcImg, String age,Schedule schedule) {
        this.id = id;
        this.title = title;
        this.des = des;
        this.director = director;
        this.time = time;
        this.category = category;
        this.srcImg = srcImg;
        this.age = age;
        this.schedule =schedule;
    }

    public Schedule getSchedule() {
        return schedule;
    }

    public void setSchedule(Schedule schedule) {
        this.schedule = schedule;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDes() {
        return des;
    }

    public void setDes(String des) {
        this.des = des;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public int getSrcImg() {
        return srcImg;
    }

    public void setSrcImg(int srcImg) {
        this.srcImg = srcImg;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }
}
