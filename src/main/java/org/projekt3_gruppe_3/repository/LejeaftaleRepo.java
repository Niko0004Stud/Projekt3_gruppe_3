package org.projekt3_gruppe_3.repository;

import org.projekt3_gruppe_3.model.Lejeaftale;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDate;

@Repository
public class LejeaftaleRepo {

@Autowired
DataSource dataSource;

public void createLejeaftale(Lejeaftale lejeaftale){
    String sql="INSERT INTO lejeaftale (BilId, KundeId,skadeMatrixId, startDato, laengdeDays, slutDato, prisKr) " +
                "VALUES(?,?,?,?,?,?,?)";

    try(Connection connection=dataSource.getConnection();
        PreparedStatement statement=connection.prepareStatement(sql)) {
        statement.setInt(1, lejeaftale.getBilId());
        statement.setInt(2, lejeaftale.getKundeId());
        statement.setInt(3, lejeaftale.getSkadeMatrixId());
        statement.setDate(4, Date.valueOf((LocalDate) lejeaftale.getStartDato()));
        statement.setInt(5, lejeaftale.getLaengeDays());
        statement.setDate(6, Date.valueOf((LocalDate) lejeaftale.getSlutDato()));
        statement.setBigDecimal(7, lejeaftale.getPrisKr());
        statement.executeUpdate();
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

}
