package ru.system.OLSystem.data.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "programming_languages")
public class ProgLanguage {

    @Id
    @Column(name = "name", unique = true, length = 100, nullable = false)
    private String name;

    public ProgLanguage() {}

    public ProgLanguage(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
