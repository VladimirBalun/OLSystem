package ru.testingsystem.data.entity;

import javax.persistence.*;

@Entity
@Table(name = "basic_data")
public class BasicData {

    @Id
    @Column(name = "name", unique = true, length = 50, nullable = false)
    private String  name;

    @Column(name = "data", length = 2000, nullable = false)
    private String  data;

    public BasicData(){

    }

    public BasicData(String name, String data) {
        this.name = name;
        this.data = data;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

}