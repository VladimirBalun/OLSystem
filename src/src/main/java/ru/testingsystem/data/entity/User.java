package ru.testingsystem.data.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
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

    @ManyToOne(fetch = FetchType.LAZY, cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    @JoinColumn(name = "id_group", nullable = false)
    private Group group;

    public User(){

    }

    public User(String login, String password, String name, long countTrueAnswers, long countQuestions, Group group) {
        this.login = login;
        this.password = password;
        this.name = name;
        this.countTrueAnswers = countTrueAnswers;
        this.countQuestions = countQuestions;
        this.group = group;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getCountTrueAnswers() {
        return countTrueAnswers;
    }

    public void setCountTrueAnswers(long countTrueAnswers) {
        this.countTrueAnswers = countTrueAnswers;
    }

    public long getCountQuestions() {
        return countQuestions;
    }

    public void setCountQuestions(long countQuestions) {
        this.countQuestions = countQuestions;
    }

    public Group getGroup() {
        return group;
    }

    public void setGroup(Group group) {
        this.group = group;
    }

}
