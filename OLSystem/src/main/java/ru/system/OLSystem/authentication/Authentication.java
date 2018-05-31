package ru.system.OLSystem.authentication;

public interface Authentication {

    UserRole authenticate(String login, String password);

    boolean register(String name, String login, String password);

}
