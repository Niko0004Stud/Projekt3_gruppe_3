package org.projekt3_gruppe_3.repository;

import org.projekt3_gruppe_3.model.Lejeaftale;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

@Repository
public class LejeaftaleRepo {

    @Autowired
    private DataSource dataSource;

    public ArrayList<Lejeaftale> readAllLejeaftaler(){
        ArrayList<Lejeaftale> lejeaftaler = new ArrayList<>();
        String sql = "SELECT * FROM lejeaftaler";

        try(Connection connection = dataSource.getConnection();
            PreparedStatement statement = connection.prepareStatement(sql)){

            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()){
                lejeaftaler.add(new Lejeaftale(
                        /* attributter*/
                ));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return lejeaftaler;
    }
}
