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
    //1.3 metode C from CRUD: CREATE

@Autowired
DataSource dataSource;

public void createLejeaftale(Lejeaftale lejeaftale){
    String sql="INSERT INTO lejeaftale (Lejeaftaleid, BilId, KundeId,skadeMatrixId, startDato, laengdeDays, slutDato, prisKr) " +
            "VALUES(?,?,?,?,?,?,?,?)";


    try(Connection connection=dataSource.getConnection();
        PreparedStatement statement=connection.prepareStatement(sql)) {
        statement.setInt(1, lejeaftale.getId());
        statement.setInt(2, lejeaftale.getBilId());
        statement.setInt(3, lejeaftale.getKundeId());
        statement.setInt(4, lejeaftale.getSkadeMatrixId());
        statement.setDate(5, (LocalDate) lejeaftale.getStartDato());
        statement.setInt(6, lejeaftale.getLaengeDays());
        statement.setDate(7, (LocalDate) lejeaftale.getSlutDato());
        statement.setBigDecimal(8, lejeaftale.getPrisKr());
        statement.executeUpdate();
    }catch (SQLException e){
        e.printStackTrace();
    }
}


}
