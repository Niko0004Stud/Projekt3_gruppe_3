package org.projekt3_gruppe_3.repository;

import org.projekt3_gruppe_3.model.SkadeMatrix;
import org.projekt3_gruppe_3.repository.interfaces.CruRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


//estera
@Repository
public class SMatrixRepo implements CruRepository {

    @Autowired
    private DataSource dataSource;


    public ArrayList<SkadeMatrix> getAll() {
        ArrayList<SkadeMatrix> skadeMatrix =new ArrayList<>();
        String sql="SELECT * FROM Skade";

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
        String sql="SELECT * FROM Skade WHERE id=?";

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

    public void create() {
        String sql="INSERT INTO skade (beskrivelse, omkostning, registreringsDate) " +
                "VALUES( ?, ?, ?)";
        try(Connection connection=dataSource.getConnection();
            PreparedStatement statement=connection.prepareStatement(sql)){
            statement.executeUpdate();
        }catch (SQLException e){
            e.printStackTrace();
        }
    }



    @Override
    public void create(Object entity) {

    }

    @Override
    public void update(Object entity) {

    }



}
