package ru.testingsystem.data.entity;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "programming_languages")
public class ProgrammingLanguage {

    @Id
    @Column(name = "name", unique = true,  length = 45, nullable = false)
    private String name;

    ProgrammingLanguage(){}

    ProgrammingLanguage(String name) {
        this.name = name;
    }

}
