package ru.tidstu.testingsystem.models;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Balun Vladimir
 */
public class FactoryModels {

    private final static Logger log = LogManager.getLogger(FactoryModels.class);

    /**
     * Single objects for this application.
     */
    private static User user = new User();
    private static ArrayList<Question> listQuestions = new ArrayList<Question>();

    /**
     * Method run query on the choice of questions. Before data add in
     * class Question and class Question add in list Questions.
     * @param query request for select data of questions
     */
    public static void setDataOfQuestions(String query){
        ResultSet result = FirebirdDB.getInstance().execSelect(query);
        ResultSet tmp;
        try {
            while (result.next()){
                tmp = result;
                int id = result.getInt("ID");
                int number = result.getInt("NUMBER");
                String title = result.getString("TITLE");
                String text = result.getString("TEXT");
                Question question = new Question(number, title, text);
                setInOutData(question, id);
                listQuestions.add(question);
                result = tmp;
            }
        } catch (SQLException e) {
            log.error("Error is reading dates from table \"Questions\".");
        }
    }

    /**
     * Method run query on yhe choice of user. Before data add in
     * class User.
     * @param query request for select user
     */
    public static void setDataOfUser(String query){
        ResultSet result = FirebirdDB.getInstance().execSelect(query);
        try {
            while (result.next()){
                user.setLogin(result.getString("LOGIN"));
                user.setPassword(result.getString("PASSWORD"));
                user.setName(result.getString("FULL_NAME"));
                user.setGroup(result.getString("NAME_GROUP"));
            }
        } catch (SQLException e) {
            log.error("Error is reading dates from table \"Users\".");
        }
    }

    /**
     * Getter returns count of questions in the test.
     * @return count of questions.
     */
    public static int getCountQuestions(){
        int countQuestions = 0;
        String query = "SELECT COUNT(id) FROM questions";
        ResultSet result = FirebirdDB.getInstance().execSelect(query);
        try {
            result.next();
            countQuestions = result.getInt(1);
        } catch (SQLException e) {
            log.error("Error is reading count of questions from table \"Questions\".");
        }
        return countQuestions;
    }

    /**
     * Getter returns right question.
     * @param number number of question
     * @return right question
     */
    public static Question getQuestion(int number){
        for (Question curQuestion : listQuestions) {
            if(curQuestion.getNumber() == number){
                return curQuestion;
            }
        }
        log.warn("Not found right question");
        return null;
    }

    /**
     * Getter returns of user.
     * @return user
     */
    public static User getUser(){
        return user;
    }

    /**
     * Getter returns list of questions.
     * @return list of questions
     */
    public static ArrayList<Question> getQuestions(){
        return listQuestions;
    }

    /**
     *
     * @param question
     * @param id
     * @throws SQLException
     */
    private static void setInOutData(Question question, int id) throws SQLException {
        String query = "SELECT * FROM in_out_dates WHERE id_question = '" + id + "'";
        ResultSet result = FirebirdDB.getInstance().execSelect(query);
        while (result.next()){
            question.addInputData(result.getString("IN_DATE"));
            question.addOutputData(result.getString("OUT_DATE"));
        }
        result.close();
    }

}
