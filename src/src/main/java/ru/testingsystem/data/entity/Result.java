package ru.testingsystem.data.entity;

import lombok.*;

import java.sql.Timestamp;

@Getter
@Setter
@ToString
@EqualsAndHashCode
public class Result {

    String name;
    String group;
    Timestamp dateOfResult;
    String result;

    @Builder
    private Result(String name, String group, Timestamp dateOfResult, String result){
        this.name = name;
        this.group = group;
        this.dateOfResult = dateOfResult;
        this.result = result;
    }

}
