package ru.system.OLSystem.data.entity;

import org.codehaus.jackson.annotate.JsonBackReference;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(generator = "increment")
    @GenericGenerator(name = "increment", strategy = "increment")
    @Column(name = "id", unique = true, nullable = false)
    private long id;

    @Column(name = "login", unique = true, length = 20, nullable = false)
    private String login;

    @Column(name = "password", length = 35, nullable = false)
    private String password;

    @Column(name = "name", length = 50)
    private String name;

    @JsonBackReference
    @OneToMany(fetch = FetchType.EAGER, mappedBy = "user")
    private List<ResultUser> resultsUser = new ArrayList<>();

    public User() {}

    public User(String login, String password) {
        this.login = login;
        this.password = password;
    }

    public User(String name, String login, String password) {
        this.name = name;
        this.login = login;
        this.password = password;
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

    public List<ResultUser> getResultsUser() {
        return resultsUser;
    }

    public void setResultsUser(List<ResultUser> resultsUser) {
        this.resultsUser = resultsUser;
    }
}
