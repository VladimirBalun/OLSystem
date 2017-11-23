package ru.tidstu.testingsystem.models;

/**
 * @author Balun Vladimir
 */
public class Question {

    /**
     *
     */
    private int number;
    private String title;
    private String text;
    private String inputData;
    private String outputDate;

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
     *
     * @return
     */
    public String getInputData() {
        return inputData;
    }

    /**
     *
     * @return
     */
    public String getOutputDate() {
        return outputDate;
    }

}
