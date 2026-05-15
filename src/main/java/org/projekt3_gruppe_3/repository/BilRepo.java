package org.projekt3_gruppe_3.repository;

import org.projekt3_gruppe_3.model.Bil;
import org.projekt3_gruppe_3.repository.interfaces.CruRepository;
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
public class BilRepo implements CruRepository<Bil> {

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

    public void delete(int id){
    }
}
