package org.projekt3_gruppe_3.repository;

import org.projekt3_gruppe_3.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


@Repository
public class LoginRepo {

    @Autowired
    DataSource dataSource;

    public User rTryLogin(String username, String password){
    User user = null;
    String sql = "SELECT * FROM User WHERE username = ? AND password = ?";

    try(Connection connection = dataSource.getConnection();
        PreparedStatement statement = connection.prepareStatement(sql)){

        statement.setString(1, username);
        statement.setString(2, password);

        try(ResultSet resultSet = statement.executeQuery()){
            if(resultSet.next()){
                user = new User(resultSet.getInt("id"),
                        resultSet.getString("username"),
                        resultSet.getString("password"),
                        resultSet.getString("sysrole"));
                /*user = switch (resultSet.getInt("sysRole")) {
                    case 0 -> rGetUserAdmin(
                            resultSet.getInt("id"),
                            resultSet.getString("username"),
                            resultSet.getString("password"),
                            resultSet.getString("sysRole"));
                    case 1 -> rGetUserDr(
                            resultSet.getInt("id"),
                            resultSet.getString("username"),
                            resultSet.getString("password"),
                            resultSet.getString("sysRole"));
                    case 2 -> rGetUserFU(
                            resultSet.getInt("id"),
                            resultSet.getString("username"),
                            resultSet.getString("password"),
                            resultSet.getString("sysRole"));
                    case 3 -> rGetUserBilTech(
                            resultSet.getInt("id"),
                            resultSet.getString("username"),
                            resultSet.getString("password"),
                            resultSet.getString("sysRole"),
                            resultSet.getString("sysRoleType"));
                    default -> user;
                }; */
            } else {
                return null;
            }
        }
    } catch (SQLException e){
        e.printStackTrace();
    }

        return user;
    }

    /*public Admin rGetUserAdmin(int id, String username, String password, String sysRole){
        return new Admin(id, username, password, sysRole);
    }

    public Dataregistrerer rGetUserDr(int id, String username, String password, String sysRole){
        return new Dataregistrerer(id, username, password, sysRole);
    }

    public Forretningsudvikler rGetUserFU(int id, String username, String password, String sysRole){
        return new Forretningsudvikler(id, username, password, sysRole);
    }

    public BilTech rGetUserBilTech(int id, String username, String password, String sysRole, String sysRoleType){
        return new BilTech(id, username, password, sysRole, sysRoleType);
    }*/
}
