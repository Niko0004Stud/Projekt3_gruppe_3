package org.projekt3_gruppe_3.repository;

import org.projekt3_gruppe_3.model.Bil;
import org.projekt3_gruppe_3.model.SkadeMatrix;
import org.projekt3_gruppe_3.repository.interfaces.CruRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;


//estera
@Repository
public class SMatrixRepo implements CruRepository<SkadeMatrix> {

    @Autowired
    private DataSource dataSource;


    public ArrayList<SkadeMatrix> getAll() {
        ArrayList<SkadeMatrix> skadeMatrix =new ArrayList<>();
        String sql="SELECT * FROM SkadeMatrix";

        try (Connection connection= dataSource.getConnection();
             PreparedStatement statement= connection.prepareStatement(sql)){
            ResultSet resultSet=statement.executeQuery();

            while (resultSet.next()){
                skadeMatrix.add(new SkadeMatrix(
                        resultSet.getInt("id"),
                        resultSet.getDouble("omkostning"),
                        resultSet.getDate("registreringsDate").toLocalDate()
                ));
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return skadeMatrix;
    }

    public SkadeMatrix getById(int id) {
        SkadeMatrix skadeMatrix =null;
        String sql="SELECT * FROM SkadeMatrix WHERE id=?";

        try(Connection connection=dataSource.getConnection();
            PreparedStatement statement=connection.prepareStatement(sql)) {
            statement.setInt(1, id);
            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    skadeMatrix =new SkadeMatrix();
                    skadeMatrix.setId(resultSet.getInt("id"));
                    skadeMatrix.setOmkostninger(resultSet.getDouble("omkostning"));
                    skadeMatrix.setRegistreringsDate(resultSet.getDate("registreringsDate").toLocalDate());
                }
            }
        }catch (SQLException e){
            e.printStackTrace();
        }

        return skadeMatrix;
    }

    @Override
    public void create(SkadeMatrix skadeMatrix) {
        String sql="INSERT INTO SkadeMatrix (bilId, omkostninger, registreringsDate) " +
                "VALUES( ?, ?, ?)";
        try(Connection connection=dataSource.getConnection();
            PreparedStatement statement=connection.prepareStatement(sql)){
            statement.setInt(1, skadeMatrix.getBilId());
            statement.setDouble(2, skadeMatrix.getOmkostninger());
            statement.setDate(3, Date.valueOf((LocalDate) skadeMatrix.getRegistreringsDate()));
            statement.executeUpdate();
        }catch (SQLException e){
            e.printStackTrace();
        }
    }




    @Override
    public void update(SkadeMatrix skadeMatrix) {

    }



}
