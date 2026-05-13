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
        List<Bil> bilList = new ArrayList<>();

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
                bilList.add(bil);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return bilList;
    }

    @Override
    public Bil getById(int id){
        return null;
    }
    @Override
    public void create(Bil bil){
        String sql = "INSERT INTO Bil (vognnummer, stelnummer, modelId, udstyrsNiveau, staalpris, regAfgift, co2Udledning)"+
                "VALUES (?,?,?,?,?,?,?,?)";

        try(Connection connection = dataSource.getConnection();
            PreparedStatement statement = connection.prepareStatement(sql)){

            statement.setString(1, bil.getVognnummer());
            statement.setString(2, bil.getStelnummer());
            statement.setInt(3, bil.getModelId());
            statement.setInt(4, bil.getUdstyrsNiveau());
            statement.setDouble(5, bil.getStaalpris());
            statement.setDouble(6, bil.getRegAfgift());
            statement.setDouble(7, bil.getCo2Udledning());

            statement.executeUpdate();

        } catch (SQLException e){
            e.printStackTrace();
        }
    }
    @Override
    public void update(Bil bil){
    }
    @Override
    public void delete(int id){
    }
}
