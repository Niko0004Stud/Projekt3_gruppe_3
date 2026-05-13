package org.projekt3_gruppe_3.repository;

import org.projekt3_gruppe_3.model.LaKvittering;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

@Repository
public class LaKvitteringRepo {

    @Autowired
    private DataSource dataSource;

    //estera
    public ArrayList<LaKvittering> readAlleLaKvitteringer(){
        ArrayList<LaKvittering>laKvittering=new ArrayList<>();
        String sql="SELECT * FROM LaKvittering";

        try(Connection connection=dataSource.getConnection();
            PreparedStatement statement=connection.prepareStatement(sql)){
            ResultSet resultSet=statement.executeQuery();

            while (resultSet.next()){
                laKvittering.add(new LaKvittering(
                        resultSet.getInt("id"),
                        resultSet.getInt("skadeMatrixId"),
                        resultSet.getDate("startDate").toLocalDate(),
                        resultSet.getDate("slutDate").toLocalDate(),
                        resultSet.getDouble("totalPrisKr"),
                        resultSet.getString("type")
                ));
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return laKvittering;
    }

    //estera
    public LaKvittering readById(int id){
        LaKvittering laKvittering=null;
        String sql="SELECT * FROM LaKvittering WHERE id=?";

        try(Connection connection=dataSource.getConnection();
        PreparedStatement statement=connection.prepareStatement(sql)){
            statement.setInt(1,id);
            try(ResultSet resultSet=statement.executeQuery()){
                if(resultSet.next()){
                    laKvittering=new LaKvittering();
                    laKvittering.setId(resultSet.getInt("id"));
                    laKvittering.setSkadeMatrixId(resultSet.getInt("skadeMatrixId"));
                    laKvittering.setStartDate(resultSet.getDate("startDate").toLocalDate());
                    laKvittering.setSlutDate(resultSet.getDate("slutDate").toLocalDate());
                    laKvittering.setTotalPrisKr(resultSet.getDouble("totalPrisKr"));
                    laKvittering.setType(resultSet.getString("type"));
                }
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return laKvittering;
    }

    //estera
    public void automatiskKvittering(LaKvittering laKvittering){
        String sql="INSERT INTO laKvittering (skadeMatrixId, totalPrisKr)VALUES( ?, ?)";
        try(Connection connection=dataSource.getConnection();
        PreparedStatement statement=connection.prepareStatement(sql)){
            statement.setInt(1, laKvittering.getSkadeMatrixId());
            statement.setDouble(2, laKvittering.getTotalPrisKr());
            statement.executeUpdate();
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

}
