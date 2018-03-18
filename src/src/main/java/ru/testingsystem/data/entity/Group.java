package ru.testingsystem.data.entity;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
@Getter
@Setter
@Table(name = "groups")
public class Group {

    @Id
    @GeneratedValue(generator = "increment")
    @GenericGenerator(name= "increment", strategy= "increment")
    @Column(name = "id", unique = true, nullable = false)
    private long id;

    @Column(name = "name", length = 20, nullable = false)
    private String name;

    public Group() {
    }

    public Group(String name) {
        this.name = name;
    }

}
