package ru.testingsystem.data.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Log {

    private String description;
    private String time;

    public Log(String description, String time) {
        this.description = description;
        this.time = time;
    }

}
