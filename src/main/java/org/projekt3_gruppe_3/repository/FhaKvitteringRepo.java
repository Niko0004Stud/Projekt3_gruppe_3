package org.projekt3_gruppe_3.repository;

import org.projekt3_gruppe_3.model.FhaKvittering;
import org.projekt3_gruppe_3.model.LaKvittering;
import org.projekt3_gruppe_3.repository.interfaces.CruRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;

//Natasha
@Repository
public class FhaKvitteringRepo {
    @Autowired
    private DataSource dataSource;

    public ArrayList<FhaKvittering> getAll() {
        ArrayList<FhaKvittering> fhaKvittering = new ArrayList<>();
        String sql = "SELECT * FROM FhaKvittering";

        try (Connection connection = dataSource.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {
            ResultSet resultSet = statement.executeQuery();


            while (resultSet.next()) {
                fhaKvittering.add(new FhaKvittering(
                        resultSet.getInt("id"),
                        resultSet.getInt("SkadeMatrixId"),
                        resultSet.getDate("registreringDate").toLocalDate(),
                        resultSet.getDouble("totalPrisKr")
                ));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return fhaKvittering;

    }
    //Natasha

    public FhaKvittering getbyId(int id) {
        FhaKvittering fhaKvittering = null;
        String sql = "SELECT * FROM FhaKvittering WHERE id=?";
        try (Connection connection = dataSource.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, id);
            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    fhaKvittering = new FhaKvittering();
                    fhaKvittering.setId(resultSet.getInt("id"));
                    fhaKvittering.setSkadeMatrixId(resultSet.getInt("skadeMatrixId"));
                    fhaKvittering.setRegistreringDate(resultSet.getDate("registeringDate").toLocalDate());
                    fhaKvittering.setTotalPrisKr(resultSet.getDouble("totalPrisKr"));

                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return fhaKvittering;
    }

    public int createFhaK(FhaKvittering fhaKvittering) {
        String sql = "INSERT INTO Fhakvittering (skadeMatrixid,registeringDate,totalPrisKr)" +
                "VALUES( ?, ?, ?)";
        try (Connection connection = dataSource.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS)) {
            statement.setDouble(1, fhaKvittering.getSkadeMatrixId());
            statement.setDate(2, Date.valueOf((LocalDate) fhaKvittering.getRegistreringDate()));
            statement.setDouble(3, fhaKvittering.getTotalPrisKr());
            statement.executeUpdate();

            try (ResultSet generatedKeys = statement.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    return generatedKeys.getInt(1);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 1;
    }


//    //Natasha
    public void update(FhaKvittering fhaKvittering) {
        String sql="UPDATE FhaKvittering SET skadeMatrixId=?, registeringDate=?, totslPrisKr=?,type=? WHERE id=?";

        try(Connection connection=dataSource.getConnection();
            PreparedStatement statement=connection.prepareStatement(sql)){
            statement.setInt(1,fhaKvittering.getSkadeMatrixId());
            statement.setDate(2, Date.valueOf((LocalDate) fhaKvittering.getRegistreringDate()));
            statement.setDouble(3, fhaKvittering.getTotalPrisKr());
            statement.executeUpdate();
        }catch (SQLException e){
       e.printStackTrace();
        }

   }

}