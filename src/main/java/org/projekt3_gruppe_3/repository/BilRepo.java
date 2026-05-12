package org.projekt3_gruppe_3.repository;

import org.projekt3_gruppe_3.model.Bil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

@Repository
public class BilRepo {

    @Autowired
    DataSource dataSource;

    public void rCreateBil(Bil bil){
        String sql = "INSERT INTO Bil (vognnummer, stelnummer, maerke, model, udstyrsniveau, staalpris, regAfgift, co2Udledning)"+
                "VALUES (?,?,?,?,?,?,?,?)";

        try(Connection connection = dataSource.getConnection();
            PreparedStatement statement = connection.prepareStatement(sql)){

            statement.setString(1, bil.getVognnummer());
            statement.setString(2, bil.getStelnummer());
            statement.setString(3, bil.getMaerke());
            statement.setString(4, bil.getModel());
            statement.setInt(5, bil.getUdstyrsniveau());
            statement.setDouble(6, bil.getStaalpris());
            statement.setDouble(7, bil.getRegAfgift());
            statement.setDouble(8, bil.getCo2Udledning());

            statement.executeUpdate();

        } catch (SQLException e){
            e.printStackTrace();
        }

    }
}
