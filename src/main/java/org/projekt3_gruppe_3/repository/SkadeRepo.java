package org.projekt3_gruppe_3.repository;

import org.projekt3_gruppe_3.model.Skade;
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
public class SkadeRepo implements CruRepository {

    @Autowired
    private DataSource dataSource;


    public ArrayList<Skade> getAll() {
        ArrayList<Skade>skade=new ArrayList<>();
        String sql="SELECT * FROM Skade";

        try (Connection connection= dataSource.getConnection();
             PreparedStatement statement= connection.prepareStatement(sql)){
            ResultSet resultSet=statement.executeQuery();

            while (resultSet.next()){
                skade.add(new Skade(
                        resultSet.getInt("id"),
                        resultSet.getString("beskrivelse"),
                        resultSet.getDouble("omkostning"),
                        resultSet.getDate("registreringsDate").toLocalDate()
                ));
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return skade;
    }

    public Skade getById(int id) {
        Skade skade=null;
        String sql="SELECT * FROM Skade WHERE id=?";

        try(Connection connection=dataSource.getConnection();
            PreparedStatement statement=connection.prepareStatement(sql)) {
            statement.setInt(1, id);
            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    skade=new Skade();
                    skade.setId(resultSet.getInt("id"));
                    skade.setBeskrivelse(resultSet.getString("beskrivelse"));
                    skade.setOmkostning(resultSet.getDouble("omkostning"));
                    skade.setRegistreringsDate(resultSet.getDate("registreringsDate").toLocalDate());
                }
            }
        }catch (SQLException e){
            e.printStackTrace();
        }

        return skade;
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
