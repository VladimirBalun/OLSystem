package ru.tidstu.testingsystem.authentication;

import lombok.extern.log4j.Log4j;
import ru.tidstu.testingsystem.data.dao.UsersDAOImpl;
import ru.tidstu.testingsystem.data.entity.User;

@Log4j
public class SignUp {

    public boolean register(User user){
        return isEmptyUser(user);
    }

    private boolean isEmptyUser(User user){
        UsersDAOImpl usersDAOImpl = new UsersDAOImpl();
        if(usersDAOImpl.isEmptyUserForSignUp(user)){
            usersDAOImpl.addUser(user);
            return true;
        } else {
            return false;
        }
    }

}