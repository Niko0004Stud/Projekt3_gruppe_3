package org.projekt3_gruppe_3.repository;

import org.projekt3_gruppe_3.model.Forhaandsaftale;
import org.projekt3_gruppe_3.model.Lejeaftale;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;

@Repository
public class ForhaandsaftaleRepo {
    @Autowired
    private DataSource dataSource;

    public ArrayList<Forhaandsaftale> readAllForhaandsaftaler() {
        ArrayList<Forhaandsaftale> forhaandsaftaler = new ArrayList<>();
        String sql = "SELECT * FROM Forhaandsaftale";

        try (Connection connection = dataSource.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                forhaandsaftaler.add(
                        new Forhaandsaftale(
                                resultSet.getInt("id"),
                                resultSet.getInt("kundeId"),
                                resultSet.getInt("bilId"),
                                resultSet.getInt("fhaKvitteringId"),
                                resultSet.getDate("RegDate").toLocalDate(),
                                resultSet.getDouble("StartPrisKr")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return forhaandsaftaler;
    }

    public void createForhaandsaftale(Forhaandsaftale forhaandsaftale){
        String sql="INSERT INTO forhaandsaftaler (id, kundeId, bilId,fhaKvitteringId,RegDate,StartPrisKr ) " +
                "VALUES(?,?,?,?,?,?)";


        try(Connection connection=dataSource.getConnection();
            PreparedStatement statement=connection.prepareStatement(sql)) {
            statement.setInt(1, forhaandsaftale.getId());
            statement.setInt(2, forhaandsaftale.getBilId());
            statement.setInt(3, forhaandsaftale.getkundeID());
            statement.setInt(4, forhaandsaftale.getFhaKvitteringId());
            statement.setDate(5, Date.valueOf((forhaandsaftale.RegDate())));
            statement.setDouble(6, forhaandsaftale.getStartPrisKr());

            statement.executeUpdate();
        }catch (SQLException e){
            e.printStackTrace();
        }
    }
}






