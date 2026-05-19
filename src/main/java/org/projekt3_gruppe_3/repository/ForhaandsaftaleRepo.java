package org.projekt3_gruppe_3.repository;

import org.projekt3_gruppe_3.model.Bil;
import org.projekt3_gruppe_3.model.Forhaandsaftale;
import org.projekt3_gruppe_3.model.Lejeaftale;
import org.projekt3_gruppe_3.repository.interfaces.CruRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

//Natasha

@Repository
public class ForhaandsaftaleRepo implements CruRepository<Forhaandsaftale> {
    @Autowired
    private DataSource dataSource;

    public List<Forhaandsaftale> getAll() {
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

    public void create(Forhaandsaftale forhaandsaftale){
        String sql="INSERT INTO Forhaansaftale (bilId, kundeId, FhaKvitteringId, registreringsDate, startPrisKr ) " +
                "VALUES(?,?,?,?,?)";


        try(Connection connection=dataSource.getConnection();
            PreparedStatement statement=connection.prepareStatement(sql)) {
            statement.setInt(1, forhaandsaftale.getBilId());
            statement.setInt(2, forhaandsaftale.getkundeID());
            statement.setInt(3, forhaandsaftale.getFhaKvitteringId());
            statement.setDate(4, Date.valueOf((forhaandsaftale.RegDate())));
            statement.setDouble(5, forhaandsaftale.getStartPrisKr());

            statement.executeUpdate();
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    public Forhaandsaftale getById(int id){

        return null;
    }

    public void update(Forhaandsaftale forhaandsaftale){

    }
}






