package ru.tidstu.testingsystem.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.extern.log4j.Log4j;

@Log4j
@Getter
@Setter
@ToString
public class TestData {

    String inputData;
    String outputData;
    String nameQuestion;

    @Builder
    public TestData(String inputData, String outputData, String nameQuestion){
        this.inputData = inputData;
        this.outputData = outputData;
        this.nameQuestion = nameQuestion;
    }

}