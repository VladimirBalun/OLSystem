package ru.testingsystem.data.entity;

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

    public TestData(String inputData, String outputData){
        this.inputData = inputData;
        this.outputData = outputData;
    }

}