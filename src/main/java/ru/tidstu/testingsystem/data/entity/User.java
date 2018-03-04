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
    private int countTrueAnswers;
    private int countQuestions;

    @Builder
    private User(String login, String name, String password, String group, String bestResult, int countTrueAnswers, int countQuestions){
        this.login = login;
        this.name = name;
        this.password = password;
        this.group = group;
        this.bestResult = bestResult;
        this.countTrueAnswers = countTrueAnswers;
        this.countQuestions = countQuestions;
    }

    public void addTrueAnswer(){
        countTrueAnswers++;
    }

}
