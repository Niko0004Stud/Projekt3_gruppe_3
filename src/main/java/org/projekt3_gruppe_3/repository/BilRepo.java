package org.projekt3_gruppe_3.repository;

import org.projekt3_gruppe_3.model.Bil;
import org.projekt3_gruppe_3.model.Bilmodel;
import org.projekt3_gruppe_3.repository.interfaces.CruRepository;
import org.projekt3_gruppe_3.repository.interfaces.DRepository;
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
public class BilRepo implements CruRepository<Bil>, DRepository<Bil> {

    @Autowired
    DataSource dataSource;

    @Override
    public List<Bil> getAll() {
        List<Bil> bilList = new ArrayList<>();

        String sql = "SELECT * FROM Bil";

        try (Connection connection = dataSource.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql);
             ResultSet resultSet = statement.executeQuery()

        ) {
            while (resultSet.next()) {
                Bil bil = new Bil(
                        resultSet.getInt("id"),
                        resultSet.getString("vognnummer"),
                        resultSet.getString("stelnummer"),
                        getBilmodelById(resultSet.getInt("modelId")),
                        resultSet.getInt("udstyrsNiveau"),
                        resultSet.getDouble("staalpris"),
                        resultSet.getDouble("regAfgift"),
                        resultSet.getDouble("co2Udledning"),
                        resultSet.getString("statusBil")
                );
                bilList.add(bil);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return bilList;
    }

    public Bilmodel getBilmodelById(int id){
        Bilmodel bilmodel = null;
        String sql = "SELECT * FROM Model WHERE id = ?";

        try(Connection connection = dataSource.getConnection();
        PreparedStatement statement = connection.prepareStatement(sql)){

        statement.setInt(1, id);

        try(ResultSet resultSet = statement.executeQuery()){
            if(resultSet.next()){
                bilmodel = new Bilmodel(
                        resultSet.getInt("id"),
                        resultSet.getString("model"),
                        resultSet.getString("maerke"),
                        resultSet.getString("beskrivelse")
                );
            } else  {
                System.out.println("fejl ved resultSet.next()");
                return null;
            }

        }

        } catch (SQLException e){
            e.printStackTrace();
        }
        return bilmodel;
    }

    public List<Bil> getAllByStatuss(String statusBil){
        List<Bil> bilList = new ArrayList<>();

        String sql = "SELECT * FROM Bil WHERE StatusBil = ?";

        try(Connection connection = dataSource.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(sql)){


            preparedStatement.setString(1, statusBil);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){

                Bil bil = new Bil();
                bil.setId(resultSet.getInt("id"));
                bil.setVognnummer(resultSet.getString("vognnummer"));
                bil.setStelnummer(resultSet.getString("stelnummer"));
                bil.setStatusBil(resultSet.getString("statusBil"));
                bil.setBilmodel(getBilmodelById(resultSet.getInt("modelId")));
                bilList.add(bil);
                System.out.println(bil.getBilmodel());
            }
        } catch (SQLException e){
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

    }

    public void createBil(Bil bil, Bilmodel bilmodel){
        String sql = "INSERT INTO Bil (vognnummer, stelnummer, modelId, udstyrsNiveau, staalpris, regAfgift, co2Udledning, statusBil)"+
                "VALUES (?,?,?,?,?,?,?,?)";

        try(Connection connection = dataSource.getConnection();
            PreparedStatement statement = connection.prepareStatement(sql)){


            statement.setString(1, bil.getVognnummer());
            statement.setString(2, bil.getStelnummer());
            statement.setInt(3, createBilmodel(bilmodel));
            statement.setInt(4, bil.getUdstyrsNiveau());
            statement.setDouble(5, bil.getStaalpris());
            statement.setDouble(6, bil.getRegAfgift());
            statement.setDouble(7, bil.getCo2Udledning());
            statement.setString(8, bil.getStatusBil());

            statement.executeUpdate();

        } catch (SQLException e){
            e.printStackTrace();
        }
    }

    public int createBilmodel(Bilmodel bilmodel){
        String sql = "INSERT INTO Model (model, maerke, beskrivelse)" +
                "VALUES (?,?,?)";

        try(Connection connection = dataSource.getConnection();
        PreparedStatement statement = connection.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS)){

        statement.setString(1, bilmodel.getModel());
        statement.setString(2, bilmodel.getMaerke());
        statement.setString(3, bilmodel.getBeskrivelse());

        statement.executeUpdate();

        try(ResultSet generatedKeys = statement.getGeneratedKeys()){
            if(generatedKeys.next()){
                return generatedKeys.getInt(1);
            }
        }

        } catch (SQLException e){
            e.printStackTrace();
        }


        return 1;
    }

    public void updateStatusBil(int id, String updateStatus){
        String sql = "UPDATE Bil SET statusBil = ? WHERE id = ?";

        try(Connection connection = dataSource.getConnection();
        PreparedStatement statement = connection.prepareStatement(sql)){

            statement.setString(1, updateStatus);
            statement.setInt(2, id);

            statement.executeUpdate();

        }   catch (SQLException e){
            e.printStackTrace();
        }
    }

    @Override
    public void update(Bil bil){
    }

    public void delete(int id){
    }
}
