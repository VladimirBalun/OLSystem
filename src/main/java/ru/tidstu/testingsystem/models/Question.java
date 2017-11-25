package ru.tidstu.testingsystem.models;

import java.util.ArrayList;

/**
 * Class implements model of the question. The class stores
 * data about question(number, title, text, input and
 * output data).
 * @author Balun Vladimir
 */
public class Question {

    /**
     * Common data of question.
     */
    private int number;
    private String title;
    private String text;
    private ArrayList<String> inData;
    private ArrayList<String> outData;

    /**
     *
     * @param number serial number of question
     * @param title title of question
     * @param text text of question
     */
    public Question(int number, String title, String text) {
        this.title = title;
        this.text = text;
        this.number = number;
        inData = new ArrayList<String>();
        outData = new ArrayList<String>();
    }

    /**
     * Getter returns serial number of question.
     * @return number of question
     */
    public int getNumber() {
        return number;
    }

    /**
     * Getter returns title of question.
     * @return title of question
     */
    public String getTitle() {
        return title;
    }

    /**
     * Getter returns text of question.
     * @return text of question
     */
    public String getText() {
        return text;
    }

    /**
     * Method add input data for question.
     * @param value input data for question
     */
    public void addInputData(String value){
       inData.add(value);
    }

    /**
     * Method add output data for question.
     * @param value output data for question
     */
    public void addOutputData(String value){
        outData.add(value);
    }

    /**
     * Getter returns list of inputs data.
     * @return list of inputs data
     */
    public ArrayList<String> getInData() {
        return inData;
    }

    /**
     * Getter returns list of outputs data.
     * @return list of outputs data
     */
    public ArrayList<String> getOutData() {
        return outData;
    }

}
