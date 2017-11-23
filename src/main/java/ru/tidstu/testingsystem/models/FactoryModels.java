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
     * Method run query on the choice of questions. Before data add in
     * class Question and class Question add in list Questions.
     * @return list questions
     */
    public static ArrayList<Question> getQuestions(){
        ArrayList<Question> listQuestion = new ArrayList<Question>();
        ResultSet result = FirebirdDB.getInstance().execSelect("SELECT * FROM questions");
        try {
            while (result.next()){
                String title = result.getString("TITLE");
                String text = result.getString("TEXT");
                int number = result.getInt("NUMBER");
                Question question = new Question(number, title, text);
                listQuestion.add(question);
            }
        } catch (SQLException e) {
            log.error("Error is reading dates from table \"Questions\".");
        }
        return listQuestion;
    }

    /**
     * Method run query on yhe choice of user. Before data add in
     * class User and return instance of class User.
     * @param query request for select user
     * @return user
     */
    public static User getUser(String query){
        User user = new User();
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
        return user;
    }

}
