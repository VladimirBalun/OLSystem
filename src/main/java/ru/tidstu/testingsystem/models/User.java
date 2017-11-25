package ru.tidstu.testingsystem.models;

import sun.swing.SwingUtilities2;

import java.util.ArrayList;

/**
 * Class implements model of the user. The class stores
 * data about user(login, password, name, group).
 * @author Balun Vladimir
 */
public class User {

    /**
     * Common data about user.
     */
    private String login;
    private String name;
    private String password;
    private String group;
    private int countTrueQuestions;

    /**
     * Default constructor this class. Here initilize
     * count true answer of user.
     */
    public User(){
        countTrueQuestions = 0;
    }

    /**
     * Method add count true questions
     * of user.
     */
    public void addTrueAnswer(){
        countTrueQuestions++;
    }

    /**
     * Setter sets login of user.
     * @param login login of user
     */
    public void setLogin(String login) {
        this.login = login;
    }

    /**
     * Setter sets full name of user.
     * @param name full name of user
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Setter sets password of user.
     * @param password password of user
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * Setter sets group of user.
     * @param group group of user
     */
    public void setGroup(String group) {
        this.group = group;
    }

    /**
     * Getter returns count true answers of user.
     * @return count true answers of user.
     */
    public int getCountTrueQuestions(){
        return countTrueQuestions;
    }

    /**
     * Getter returns name of the user.
     * @return name of the user
     */
    public String getName() {
        return name;
    }

    /**
     * Getter returns password of the user.
     * @return password of the user
     */
    public String getPassword() {
        return password;
    }

    /**
     * Getter returns group of the user.
     * @return group of the user
     */
    public String getGroup() {
        return group;
    }

    /**
     * Getter returns login of the user.
     * @return login of the user
     */
    public String getLogin() {
        return login;
    }

    @Override
    public String toString() {
        return "User{" +
                "login='" + login + '\'' +
                ", name='" + name + '\'' +
                ", password='" + password + '\'' +
                ", group='" + group + '\'' +
                '}';
    }

}
