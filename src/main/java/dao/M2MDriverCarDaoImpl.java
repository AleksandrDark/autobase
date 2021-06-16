package dao;

import domain.DriverCarM2M;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class M2MDriverCarDaoImpl implements DaoM2MDriverCar{
    private final ConnectionClass connectionClass = new ConnectionClass();

    @Override
    public DriverCarM2M getID(Integer id) {
        return null;
    }

    @Override
    public List<DriverCarM2M> getAll() {
        return null;
    }

    @Override
    public DriverCarM2M create(DriverCarM2M object) {
        return null;
    }

    @Override
    public DriverCarM2M update(Integer id, DriverCarM2M object) {
        return null;
    }

    @Override
    public DriverCarM2M delete(Integer id) {
        return null;
    }

    @Override
    public List<String> getAllDriverAndCars() {
        String selectDriversAndCars = "select * FROM carpool.drivers inner join carpool.cars ON drivers.id = cars.id;";
        List<String> driversAndCars = new ArrayList<>();
        try(Connection connection = connectionClass.createConnection();
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(selectDriversAndCars)){
            while (rs.next()){
                Integer idDr = rs.getInt(1);
                String name = rs.getString(2);
                String surname = rs.getString(3);
                int salary = rs.getInt(4);
                int idCar = rs.getInt(5);
                String model = rs.getString(6);
                String number = rs.getString(7);
                driversAndCars.add(idDr + " - " + name + " - " + surname + " - " + salary + " - " + idCar + " - " + model + " - " + number + "\n");
            }
            return driversAndCars;
        }catch (SQLException e){
            e.printStackTrace();
        }
        return null;
    }
}
