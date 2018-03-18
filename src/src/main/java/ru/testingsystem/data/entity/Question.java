package ru.testingsystem.data.entity;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
@Getter
@Setter
@Table(name = "questions")
public class Question {

    @Id
    @GeneratedValue(generator = "increment")
    @GenericGenerator(name= "increment", strategy= "increment")
    @Column(name = "id", unique = true, nullable = false)
    private long id;

    @Column(name = "title", length = 300, nullable = false)
    private String title;

    @Column(name = "text", length = 5000, nullable = false)
    private String text;

    @Transient
    private String inputData;

    @Transient
    private String outputData;

    public Question(){

    }

    public Question(String title){
        this.title = title;
    }

    public Question(String title, String text) {
        this.title = title;
        this.text = text;
    }

}
