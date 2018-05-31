package ru.system.OLSystem.data.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "settings_olympiad")
public class SettingsOlympiad {

    @Id
    @Column(name = "name", unique = true, length = 100, nullable = false)
    private String name;

    @Column(name = "property", length = 2000, nullable = false)
    private String property;

    public SettingsOlympiad() {}

    public SettingsOlympiad(String name, String property) {
        this.name = name;
        this.property = property;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getProperty() {
        return property;
    }

    public void setProperty(String data) {
        this.property = data;
    }

}