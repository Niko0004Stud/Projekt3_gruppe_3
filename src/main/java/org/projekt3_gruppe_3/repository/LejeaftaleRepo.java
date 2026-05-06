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

    @Autowired
    private DataSource dataSource;

    public ArrayList<Lejeaftale> readAllLejeaftaler(){
        ArrayList<Lejeaftale> lejeaftaler = new ArrayList<>();
        String sql = "SELECT * FROM lejeaftaler";

        try(Connection connection = dataSource.getConnection();
            PreparedStatement statement = connection.prepareStatement(sql)){

            ResultSet resultSet = statement.executeQuery();

//            while (resultSet.next()){
//                lejeaftaler.add(new Lejeaftale(
//                        /* attributter*/
//                ));
//            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return lejeaftaler;
    }

    public void createLejeaftale(Lejeaftale lejeaftale){
        String sql="INSERT INTO lejeaftale (Lejeaftaleid, BilId, KundeId,skadeMatrixId, startDato, laengdeDays, slutDato, prisKr) " +
                "VALUES(?,?,?,?,?,?,?,?)";


        try(Connection connection=dataSource.getConnection();
            PreparedStatement statement=connection.prepareStatement(sql)) {
            statement.setInt(1, lejeaftale.getId());
            statement.setInt(2, lejeaftale.getBilId());
            statement.setInt(3, lejeaftale.getKundeId());
            statement.setInt(4, lejeaftale.getSkadeMatrixId());
            statement.setDate(5, Date.valueOf((LocalDate) lejeaftale.getStartDato()));
            statement.setInt(6, lejeaftale.getLaengeDays());
            statement.setDate(7, Date.valueOf((LocalDate) lejeaftale.getSlutDato()));
            statement.setBigDecimal(8, lejeaftale.getPrisKr());
            statement.executeUpdate();
        }catch (SQLException e){
            e.printStackTrace();
        }
    }
}
