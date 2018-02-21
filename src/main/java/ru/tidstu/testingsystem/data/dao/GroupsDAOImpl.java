package ru.tidstu.testingsystem.data.dao;

import lombok.extern.log4j.Log4j;
import ru.tidstu.testingsystem.utils.DataBase;
import ru.tidstu.testingsystem.data.entity.Group;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

@Log4j
public class GroupsDAOImpl implements GroupsDAO {

    private static ArrayList<Group> groups = new ArrayList<Group>();
    private DataBase dataBase = DataBase.getInstance();

    public ArrayList<Group> getGroups() {
        groups.clear();
        try {
            String query = "SELECT g.name_group, " +
                           "(SELECT COUNT(u.id) FROM users u WHERE u.id_group = g.id) " +
                           "FROM groups g";
            ResultSet result = dataBase.execSelect(query);
            while (result.next()){
                Group group = Group.builder()
                        .name(result.getString(1))
                        .countUsers(result.getInt(2))
                        .build();
                groups.add(group);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return groups;
    }

    public void addGroup(String nameGroup){
        String query = "INSERT INTO groups(name_group) VALUES('" + nameGroup + "')";
        dataBase.execInsert(query);
    }

    public void changeGroup(String oldName, String newName){
        String query = "UPDATE groups SET name_group = '" + newName + "' WHERE name_group = '" + oldName + "'";
        dataBase.execUpdate(query);
    }

    public void deleteGroup(String nameGroup){
        String query = "DELETE FROM groups WHERE name_group = '" + nameGroup + "'";
        dataBase.execDelete(query);
    }

}
