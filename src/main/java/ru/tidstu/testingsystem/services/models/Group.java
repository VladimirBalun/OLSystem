package ru.tidstu.testingsystem.services.models;

import lombok.*;

@Setter
@Getter
@ToString
@EqualsAndHashCode
public class Group{


    private final String name;
    private final int countUsers;

    @Builder
    private Group(String name, int countUsers) {
        this.name = name;
        this.countUsers = countUsers;
    }

}
