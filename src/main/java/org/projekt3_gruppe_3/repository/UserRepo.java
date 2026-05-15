package org.projekt3_gruppe_3.repository;

import org.projekt3_gruppe_3.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Repository
public class UserRepo {

    @Autowired
    DataSource dataSource;


    public List<User> getAll(){
        List<User> userList = new ArrayList<>();

        String sql = "SELECT * FROM User";

        try(Connection connection = dataSource.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery()){

            while (resultSet.next()){
                User user = new User(
                        resultSet.getInt("id"),
                        resultSet.getString("username"),
                        resultSet.getString("password"),
                        resultSet.getString("sysrole")
                        );
                userList.add(user);
            }
        } catch (SQLException e){
            e.printStackTrace();
        }
        return userList;
    }

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
