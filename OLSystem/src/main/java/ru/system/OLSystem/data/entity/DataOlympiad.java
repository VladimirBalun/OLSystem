package ru.system.OLSystem.data.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "data_olympiad")
public class DataOlympiad {

    @Id
    @Column(name = "name", unique = true, length = 100, nullable = false)
    private String name;

    @Column(name = "data", length = 2000, nullable = false)
    private String data;

    public DataOlympiad() {}

    public DataOlympiad(String name, String data) {
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
