package org.projekt3_gruppe_3.repository;

import org.projekt3_gruppe_3.model.Bil;
import org.projekt3_gruppe_3.repository.interfaces.CrudRepository;
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
public class BilRepo implements CrudRepository<Bil> {

    @Autowired
    DataSource dataSource;

    @Override
    public List<Bil> getAll() {
        List<Bil> biler = new ArrayList<>();

        String sql = "SELECT * FROM Bil";

        try (Connection connection = dataSource.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql);
             ResultSet resultSet = preparedStatement.executeQuery()

        ) {
            while (resultSet.next()) {


                Bil bil = new Bil(
                        resultSet.getInt("id"),
                        resultSet.getString("vognnummer"),
                        resultSet.getString("stelnummer"),
                        resultSet.getInt("modelId"),
                        resultSet.getInt("udstyrsNiveau"),
                        resultSet.getDouble("staalpris"),
                        resultSet.getDouble("regAfgift"),
                        resultSet.getDouble("co2Udledning")
                );
                biler.add(bil);

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return biler;
    }
    @Override
    public Bil getById(int id){
        return null;
    }
    @Override
    public void create(Bil bil){
    }
    @Override
    public void update(Bil bil){
    }
    @Override
    public void delete(int id){
    }
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

    public List<Bil> readAllBil(){
        ArrayList<Bil> bilList = new ArrayList<>();

        String sql = "SELECT * FROM Bil";

        try(Connection connection = dataSource.getConnection();
        PreparedStatement statement = connection.prepareStatement(sql)){
            ResultSet resultSet = statement.executeQuery();

            while(resultSet.next()){
                bilList.add(new Bil(
                        resultSet.getInt("id"),
                        resultSet.getString("vognnummer"),
                        resultSet.getString("stelnummer"),
                        resultSet.getString("maerke"),
                        resultSet.getString("model"),
                        resultSet.getInt("udstyrsniveau"),
                        resultSet.getDouble("staalpris"),
                        resultSet.getDouble("regAfgift"),
                        resultSet.getDouble("co2udledning")));
            }

        } catch (SQLException e){
            e.printStackTrace();
        }
        return bilList;
    }

}
