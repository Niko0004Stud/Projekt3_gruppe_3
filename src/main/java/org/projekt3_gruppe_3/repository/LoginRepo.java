package org.projekt3_gruppe_3.repository;

import org.projekt3_gruppe_3.model.Admin;
import org.projekt3_gruppe_3.model.SuperUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ResourceLoader;
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

    public SuperUser rTryLogin(String username, String password){
    SuperUser user = null;
    String sql = "SELECT * FROM users WHERE username = ? AND password = ?";


    try(Connection connection = dataSource.getConnection();
        PreparedStatement statement = connection.prepareStatement(sql)){

        statement.setString(1, username);
        statement.setString(2, password);

        try(ResultSet resultSet = statement.executeQuery()){
            if(resultSet.next()){
                switch (resultSet.getInt("sysRole")){
                    case 0: user=rGetUserAdmin(
                            resultSet.getInt("id"),
                            resultSet.getString("username"),
                            resultSet.getString("password"),
                            resultSet.getString("sysRole")
                    );
                        break;

                    case 1: //user
                        break;

                }
            } else {
                return null;
            }
        }
    } catch (SQLException e){
        e.printStackTrace();
    }

    return user;
    }

    public Admin rGetUserAdmin(int id, String username, String password, String sysRole){
        return new Admin(id, username, password, sysRole);
    }


}
