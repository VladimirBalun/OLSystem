package ru.tidstu.testingsystem.data.entity;

import lombok.*;

@Getter
@Setter
@ToString
@EqualsAndHashCode
public class Question {

    private int number;
    private String title;
    private String text;
    private String inputData;
    private String outputData;

    @Builder
    private Question(int number, String title, String text, String inputData, String outputData) {
        this.title = title;
        this.text = text;
        this.number = number;
        this.inputData = inputData;
        this.outputData = outputData;
    }

}