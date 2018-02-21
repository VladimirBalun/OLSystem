package ru.tidstu.testingsystem.data.entity;

import lombok.*;

@Getter
@Setter
@ToString
@EqualsAndHashCode
public class User {

    private String login;
    private String name;
    private String password;
    private String group;
    private String bestResult;
    private int countTrueQuestions;

    @Builder
    private User(String login, String name, String password, String group, String bestResult){
        this.login = login;
        this.name = name;
        this.password = password;
        this.group = group;
        this.bestResult = bestResult;
        countTrueQuestions = 0;
    }

    public void addTrueAnswer(){
        countTrueQuestions++;
    }

}
