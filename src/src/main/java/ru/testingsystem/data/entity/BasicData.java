package ru.testingsystem.data.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
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

}