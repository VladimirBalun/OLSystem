package ru.tidstu.testingsystem.data.dao;

import lombok.extern.log4j.Log4j;
import org.springframework.stereotype.Repository;
import ru.tidstu.testingsystem.data.DataBase;
import ru.tidstu.testingsystem.data.entity.Question;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Log4j
@Repository
public class QuestionsDAOImpl implements QuestionsDAO {

    private DataBase dataBase = DataBase.getInstance();

    public void addQuestion(Question question){
        String query = "INSERT INTO questions(title, text) " +
                       "VALUES('" + question.getTitle() + "', '" + question.getText() + "')";
        dataBase.execInsert(query);
    }

    public void removeQuestion(String titleQuestion){
        String query = "DELETE FROM questions q " +
                       "WHERE q.title = '" + titleQuestion + "'";
        dataBase.execDelete(query);
    }

    public void changeQuestion(String nameQuestion, String newTitle, String newText){
        String query = "UPDATE questions q " +
                       "SET q.title = '" + newTitle + "', q.text = '" + newText + "' " +
                       "WHERE q.title = '" + nameQuestion + "'";
        dataBase.execUpdate(query);
    }

    public Question getQuestion(String titleQuestion){
        String query = "SELECT q.title, q.text " +
                       "FROM questions q " +
                       "WHERE q.title = '" + titleQuestion + "'";
        ResultSet result = dataBase.execSelect(query);
        try {
            result.next();
            return Question.builder()
                    .text(result.getString("TEXT"))
                    .title(result.getString("TITLE"))
                    .build();
        } catch (SQLException e) {
            log.error("Error is reading question " + titleQuestion + ". Query: " + query);
        }
        throw new NullPointerException("Question " + titleQuestion + " not found.");
    }

    public int getCountQuestions(){
        int countQuestions = 0;
        String query = "SELECT COUNT(id) FROM questions";
        ResultSet result = dataBase.execSelect(query);
        try {
            result.next();
            countQuestions = result.getInt(1);
        } catch (SQLException e) {
            log.error("Error is reading count questions Query: " + query);
        }
        return countQuestions;
    }

    public List<Question> getQuestions(){
        String query = "SELECT q.title, q.text, " +
                       "(SELECT FIRST 1 d.in_date FROM in_out_dates d WHERE d.id_question = q.id), " +
                       "(SELECT FIRST 1 d.out_date FROM in_out_dates d WHERE d.id_question = q.id) " +
                       "FROM questions q";
        return loadQuestionsFromDB(query);
    }

    private List<Question> loadQuestionsFromDB(String query){
        List<Question> questions = new ArrayList<Question>();
        int number = 1;
        ResultSet result = dataBase.execSelect(query);
        try {
            while (result.next()){
                Question question = Question.builder()
                        .number(number++)
                        .title(result.getString(1))
                        .text(result.getString(2))
                        .inputData(result.getString(3))
                        .outputData(result.getString(4))
                        .build();
                question.toString();
                questions.add(question);
            }
        } catch (SQLException e) {
            log.error("Error is reading questions. Query: " + query);
        }
        return questions;
    }

}
