package ru.tidstu.testingsystem.authentication;

import lombok.extern.log4j.Log4j;
import ru.tidstu.testingsystem.data.dao.UsersDAOImpl;

@Log4j
public class SignIn {

    public RoleUser authenticate(String login, String password){
        if(isAdmin(login, password)){
            return RoleUser.ADMIN;
        } else if(isUser(login, password)){
            return RoleUser.USER;
        } else {
            return RoleUser.UNKNOWN;
        }
    }

    private boolean isAdmin(String login, String password){
        if(login.equals("admin") && password.equals("admin")){
            return true;
        } else {
            return false;
        }
    }

    private boolean isUser(String login, String password){
        UsersDAOImpl usersDAOImpl = new UsersDAOImpl();
        if(usersDAOImpl.setCurrentUser(login, password)){
            return true;
        } else {
            return false;
        }
    }


}
