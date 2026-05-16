package org.projekt3_gruppe_3.repository;

import org.projekt3_gruppe_3.model.LaKvittering;
import org.projekt3_gruppe_3.model.Lejeaftale;
import org.projekt3_gruppe_3.repository.interfaces.CruRepository;
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
public class LejeaftaleRepo implements CruRepository<Lejeaftale> {

    @Autowired
    private DataSource dataSource;
    @Autowired
    private LaKvitteringRepo laKvitteringRepo;

    public ArrayList<Lejeaftale> getAll(){
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
                        resultSet.getInt("laKvitteringId"),
                        resultSet.getDate("startDate").toLocalDate(),
                        resultSet.getDate("slutDate").toLocalDate(),
                        resultSet.getDouble("startPrisKr")
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return lejeaftaler;
    }


    public void create(Lejeaftale lejeaftale){
        String sql="INSERT INTO Lejeaftale (bilId, KundeId, laKvitteringId, startDate, slutDate, startPrisKr) " +
                "VALUES( ?, ?, ?, ?, ?, ?)";
        System.out.println("Du kom til create i lejeaftalerepo");
        try(Connection connection=dataSource.getConnection();
            PreparedStatement statement=connection.prepareStatement(sql)) {
            statement.setInt(1, lejeaftale.getBilId());
            statement.setInt(2, lejeaftale.getKundeId());
            statement.setInt(3, lejeaftale.getLaKvitteringId());
            statement.setDate(4, Date.valueOf((LocalDate)  lejeaftale.getStartDate()));
            statement.setDate(5, Date.valueOf((LocalDate) lejeaftale.getSlutDate()));
            statement.setDouble(6, lejeaftale.getstartPrisKr());
            statement.executeUpdate();
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    //updatelejeaftale til at oprette slut kvittering. estera
    public  void update(Lejeaftale lejeaftale){
        String sql="UPDATE Lejeaftale SET bilId=?, KundeId=?, laKvitteringId=?, startDate=?, slutDate=?, totalPrisKr=?, WHERE id=?";

        try(Connection connection=dataSource.getConnection();
            PreparedStatement statement=connection.prepareStatement(sql)){
            statement.setInt(1,lejeaftale.getBilId());
            statement.setInt(2, lejeaftale.getKundeId());
            statement.setInt(3, lejeaftale.getLaKvitteringId());
            statement.setDate(4,Date.valueOf((LocalDate)  lejeaftale.getStartDate()) );
            statement.setDate(5, Date.valueOf((LocalDate) lejeaftale.getSlutDate()));
            statement.setDouble(6, lejeaftale.getstartPrisKr());
            statement.setInt(7, lejeaftale.getId());
            statement.executeUpdate();
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    @Override
    public Lejeaftale getById(int id) {
        return null;
    }

}
