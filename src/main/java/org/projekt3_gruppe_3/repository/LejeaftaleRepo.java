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
import java.sql.Date;
import java.time.LocalDate;

@Repository
public class LejeaftaleRepo {
    //1.3 metode C from CRUD: CREATE

    @Autowired
    private DataSource dataSource;

    public ArrayList<Lejeaftale> readAllLejeaftaler(){
        ArrayList<Lejeaftale> lejeaftaler = new ArrayList<>();
        String sql = "SELECT * FROM Lejeaftale";

        try(Connection connection = dataSource.getConnection();
            PreparedStatement statement = connection.prepareStatement(sql)){

            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()){
                lejeaftaler.add(new Lejeaftale(
                        resultSet.getInt("id"),
                        resultSet.getInt("bilId"),
                        resultSet.getInt("kundeId"),
                        resultSet.getInt("skadeMatrixId"),
                        resultSet.getDate("startDate").toLocalDate(),
                        resultSet.getInt("laengdeDays"),
                        resultSet.getDate("slutDato").toLocalDate(),
                        resultSet.getDouble("prisKr")
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return lejeaftaler;
    }

    public void createLejeaftale(Lejeaftale lejeaftale){
        String sql="INSERT INTO Lejeaftale (BilId, KundeId,skadeMatrixId, startDate, laengdeDays, slutDato, prisKr) " +
                "VALUES(?,?,?,?,?,?,?)";


        try(Connection connection=dataSource.getConnection();
            PreparedStatement statement=connection.prepareStatement(sql)) {
            statement.setInt(1, lejeaftale.getBilId());
            statement.setInt(2, lejeaftale.getKundeId());
            statement.setInt(3, lejeaftale.getSkadeMatrixId());
            statement.setDate(4, Date.valueOf((LocalDate) lejeaftale.getStartDato()));
            statement.setInt(5, lejeaftale.getLaengeDays());
            statement.setDate(6, Date.valueOf((LocalDate) lejeaftale.getSlutDato()));
            statement.setDouble(7, lejeaftale.getPrisKr());
            statement.executeUpdate();
        }catch (SQLException e){
            e.printStackTrace();
        }
    }
}

