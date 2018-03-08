package ru.tidstu.testingsystem.data.dao;

import lombok.extern.log4j.Log4j;
import org.springframework.stereotype.Repository;
import ru.tidstu.testingsystem.data.DataBase;
import ru.tidstu.testingsystem.data.entity.User;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Log4j
@Repository
public class UsersDAOImpl implements UsersDAO {

    private DataBase dataBase = DataBase.getInstance();

    public boolean isValidLoginAndPassword(String login, String password){
        String query = "SELECT u.login, u.password, u.full_name, g.name_group " +
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
        String query = "SELECT u.login, u.password, u.full_name, g.name_group " +
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
        String query = "DELETE FROM users WHERE full_name = '" + nameUser + "'";
        dataBase.execDelete(query);
    }

    public void addUser(User user){
        String query = "INSERT INTO users(login, password, full_name, id_group) " +
                       "VALUES('" + user.getLogin() + "','" + user.getPassword() + "','" + user.getName() + "'," +
                       "(SELECT g.id FROM groups g WHERE g.name_group = '" + user.getGroup() + "'))";
        dataBase.execInsert(query);
    }

    public List<User> getUsers()  {
        String query = "SELECT * " +
                       "FROM users u " +
                       "LEFT JOIN groups g ON u.id_group = g.id " +
                       "ORDER BY u.full_name";
        return loadUsersFromDB(query);
    }

    public List<User> getUsersFromGroup(String nameGroup){
        String query = "SELECT * " +
                       "FROM users u " +
                       "LEFT JOIN groups g ON u.id_group = g.id " +
                       "WHERE u.id_group = (SELECT id FROM groups WHERE name_group = '" + nameGroup + "') " +
                       "ORDER BY u.full_name";
        return loadUsersFromDB(query);
    }

    private List<User> loadUsersFromDB(String query){
        List<User> users = new ArrayList<User>();
        ResultSet result = dataBase.execSelect(query);
        try {
            while (result.next()){
                User user = User.builder()
                        .login(result.getString("LOGIN"))
                        .name(result.getString("FULL_NAME"))
                        .group(result.getString("NAME_GROUP"))
                        .password(result.getString("PASSWORD"))
                        .bestResult(result.getString("COUNT_TRUE_ANSWERS") + "/" + result.getString("COUNT_QUESTIONS"))
                        .build();
                users.add(user);
            }
        } catch (SQLException e) {
            log.error("Error is reading users. Query: " + query);
        }
        return users;
    }

}