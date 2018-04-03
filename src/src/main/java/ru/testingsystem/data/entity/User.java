package ru.testingsystem.data.entity;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

@Entity
@Getter
@Setter
@ToString
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(generator = "increment")
    @GenericGenerator(name= "increment", strategy= "increment")
    @Column(name = "id", unique = true, nullable = false)
    private long id;

    @Column(name = "login", length = 30, nullable = false)
    private String login;

    @Column(name = "password", length = 30, nullable = false)
    private String password;

    @Column(name = "name", length = 150, nullable = false)
    private String name;

    @Column(name = "count_true_answers", nullable = false)
    private long countTrueAnswers;

    @Column(name = "count_questions", nullable = false)
    private long countQuestions;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_group", nullable = false)
    private Group group;

    @Transient
    private List<Question> questionsUser;

    @Transient
    private Queue<Log> logsUser = new LinkedList<>();

    public User(){

    }

    @Builder
    public User(String login, String password, String name, long countTrueAnswers, long countQuestions, Group group) {
        this.login = login;
        this.password = password;
        this.name = name;
        this.countTrueAnswers = countTrueAnswers;
        this.countQuestions = countQuestions;
        this.group = group;
    }

    public void addLog(Log log){
        if(logsUser.size() > 14){
            logsUser.remove();
        }
        logsUser.add(log);
    }

    public void removeQuestion(String title){
        for (Question question : questionsUser) {
            if(question.getTitle().equals(title)){
                questionsUser.remove(question);
                return;
            }
        }
    }

}