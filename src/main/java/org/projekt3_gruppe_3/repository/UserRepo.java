package org.projekt3_gruppe_3.repository;

import org.projekt3_gruppe_3.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

@Repository
public class UserRepo {

    @Autowired
    DataSource dataSource;

    public void rCreateUser(User user){
        String sql = "INSERT INTO User (username, password, sysrole) " +
                "VALUES( ?, ?, ?)";

        try(Connection connection = dataSource.getConnection();
            PreparedStatement statement = connection.prepareStatement(sql)){
            statement.setString(1, user.getUsername());
            statement.setString(2, user.getPassword());
            statement.setString(3, user.getSysRole());

            statement.executeUpdate();

        } catch (SQLException e){
            e.printStackTrace();
        }
    }
}
