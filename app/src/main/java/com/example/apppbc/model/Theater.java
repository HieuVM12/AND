package com.example.apppbc.model;

import java.io.Serializable;

public class Theater implements Serializable {
    private Long id;
    private String nameTheater;

    public Theater(Long id, String nameTheater) {
        this.id = id;
        this.nameTheater = nameTheater;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNameTheater() {
        return nameTheater;
    }

    public void setNameTheater(String nameTheater) {
        this.nameTheater = nameTheater;
    }
}
