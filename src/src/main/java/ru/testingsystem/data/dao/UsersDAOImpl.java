package ru.testingsystem.data.dao;

import lombok.extern.log4j.Log4j;
import org.springframework.stereotype.Repository;
import ru.testingsystem.data.DataBase;
import ru.testingsystem.data.entity.User;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Log4j
@Repository
public class UsersDAOImpl implements UsersDAO {

    private DataBase dataBase = DataBase.getInstance();

    public boolean isValidLoginAndPassword(String login, String password){
        String query = "SELECT u.login, u.password, u.name, g.name " +
                       "FROM users u LEFT JOIN groups g ON u.id_group = g.id " +
                       "WHERE login = '" + login + "' AND password = '" + password + "'";
        try {
            ResultSet result = dataBase.execSelect(query);
            return result.next();
        } catch (SQLException e) {
            log.error("Error is reading user by login and password. Query: " + query);
        }
        return false;
    }

    public boolean isEmptyLoginForSignUp(String login){
        String query = "SELECT u.login, u.password, u.name, g.name " +
                       "FROM users u LEFT JOIN groups g ON u.id_group = g.id " +
                       "WHERE login = '" + login + "'";
        try {
            ResultSet result = dataBase.execSelect(query);
            return !result.next();
        } catch (SQLException e) {
            log.error("Error is checking of user for sign up. Query: " + query);
        }
        return false;
    }

    public void delUser(String nameUser){
        String query = "DELETE FROM users WHERE name = '" + nameUser + "'";
        dataBase.execDelete(query);
    }

    public void addUser(User user){
        String query = "INSERT INTO users(login, password, name, id_group) " +
                       "VALUES('" + user.getLogin() + "','" + user.getPassword() + "','" + user.getName() + "', " +
                       "(SELECT g.id FROM groups g WHERE g.name = '" + user.getGroup() + "'))";
        dataBase.execInsert(query);
    }

    public List<User> getUsers()  {
        String query = "SELECT u.login, u.name, g.name, u.password, u.count_true_answers, u.count_questions " +
                       "FROM users u " +
                       "LEFT JOIN groups g ON u.id_group = g.id " +
                       "ORDER BY u.name";
        return loadUsersFromDB(query);
    }

    public List<User> getUsersFromGroup(String nameGroup){
        String query = "SELECT u.login, u.name, g.name, u.password, u.count_true_answers, u.count_questions " +
                       "FROM users u " +
                       "LEFT JOIN groups g ON u.id_group = g.id " +
                       "WHERE u.id_group = (SELECT id FROM groups WHERE name = '" + nameGroup + "') " +
                       "ORDER BY u.name";
        return loadUsersFromDB(query);
    }

    private List<User> loadUsersFromDB(String query){
        List<User> users = new ArrayList<>();
        ResultSet result = dataBase.execSelect(query);
        try {
            while (result.next()){
                User user = User.builder()
                        .login(result.getString(1))
                        .name(result.getString(2))
                        .group(result.getString(3))
                        .password(result.getString(4))
                        .bestResult(result.getString(5) + "/" + result.getString(6))
                        .build();
                users.add(user);
            }
        } catch (SQLException e) {
            log.error("Error is reading users. Query: " + query);
        }
        return users;
    }

}