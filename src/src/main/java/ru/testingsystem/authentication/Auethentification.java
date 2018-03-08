package ru.testingsystem.authentication;

public interface Auethentification {

    RoleUser authenticate(String login, String password);

    boolean register(String login, String password, String name, String group);

}
