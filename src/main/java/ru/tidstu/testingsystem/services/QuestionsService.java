package ru.tidstu.testingsystem.services;

import lombok.extern.log4j.Log4j;
import ru.tidstu.testingsystem.utils.DataBase;
import ru.tidstu.testingsystem.services.models.Question;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

@Log4j
public class QuestionsService {

    private static ArrayList<Question> listQuestionsOfUser;
    private DataBase dataBase = DataBase.getInstance();

    public void setQuestions(){
        String query = "SELECT q.title, q.text, " +
                       "(SELECT FIRST 1 d.in_date FROM in_out_dates d WHERE d.id_question = q.id), " +
                       "(SELECT FIRST 1 d.out_date FROM in_out_dates d WHERE d.id_question = q.id) " +
                       "FROM questions q";
        listQuestionsOfUser = loadQuestionsFromDB(query);
    }

    public ArrayList<Question> getAllQuestions(){
        String query = "SELECT q.title, q.text, " +
                       "(SELECT FIRST 1 d.in_date FROM in_out_dates d WHERE d.id_question = q.id), " +
                       "(SELECT FIRST 1 d.out_date FROM in_out_dates d WHERE d.id_question = q.id) " +
                       "FROM questions q";
        ArrayList<Question> questions = loadQuestionsFromDB(query);
        return questions;
    }

    private ArrayList<Question> loadQuestionsFromDB(String query){
        ArrayList<Question> questions = new ArrayList<Question>();
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
                questions.add(question);
            }
        } catch (SQLException e) {
            log.error("Error is reading dates from table \"QuestionsService\".");
        }
        return questions;
    }

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
            Question question = Question.builder()
                    .text(result.getString("TEXT"))
                    .title(result.getString("TITLE"))
                    .build();
            return question;
        } catch (SQLException e) {
            log.error("Error is reading dates from table \"QuestionsService\".");
        }
        throw new NullPointerException("Question " + titleQuestion + " not found.");
    }

    public ArrayList<Question> getQuestionsOfUser(){
        return listQuestionsOfUser;
    }

    public Question getQuestionOfUser(int number){
        for (Question curQuestion : listQuestionsOfUser) {
            if(curQuestion.getNumber() == number){
                return curQuestion;
            }
        }
        log.warn("Not found right question");
        return null;
    }

}
