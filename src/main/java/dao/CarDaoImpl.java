package dao;

import domain.Car;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CarDaoImpl implements DaoCar{
    private final ConnectionClass connectionClass = new ConnectionClass();

    @Override
    public Car getID(Integer id) {
        String selectIDCar = "SELECT * FROM carpool.cars WHERE id = ?";
        try(Connection connection = connectionClass.createConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(selectIDCar)){
            preparedStatement.setInt(1, id);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()){
                Integer idCar = rs.getInt(1);
                String model = rs.getString(2);
                String number = rs.getString(3);
                return new Car(idCar, model, number);
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Car> getAll() {
        List<Car> cars = new ArrayList<>();
        try(Connection connection = connectionClass.createConnection();
            Statement statement = connection.createStatement()){
            String selectCars = "SELECT * FROM carpool.cars";
            ResultSet rs = statement.executeQuery(selectCars);
            while (rs.next()){
                Integer idCar = rs.getInt(1);
                String model = rs.getString(2);
                String number = rs.getString(3);
                cars.add(new Car(idCar, model, number));
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return cars;
    }

    @Override
    public Car create(Car car) {
        String insertCar = "INSERT INTO `carpool`.`cars` (`model`, `number`) VALUES (?, ?)";
        try(Connection connection = connectionClass.createConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(insertCar, Statement.RETURN_GENERATED_KEYS)){
            preparedStatement.setString(1, car.getModel());
            preparedStatement.setString(2, car.getNumber());
            int row = preparedStatement.executeUpdate();
            ResultSet rs = preparedStatement.getGeneratedKeys();
            if (row > 0){
                System.out.println("Car added successfully " + row);
                while (rs.next()){
                    Integer id = rs.getInt(1);
                    return getID(id);
                }
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Car update(Integer id, Car car) {
        String updateCar = "UPDATE carpool.cars SET model = ?, number = ? WHERE id = ?";
        try(Connection connection = connectionClass.createConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(updateCar)){
            preparedStatement.setString(1, car.getModel());
            preparedStatement.setString(2, car.getNumber());
            preparedStatement.setInt(3, id);
            int row = preparedStatement.executeUpdate();
            if (row > 0){
                System.out.println("Car updated successfully");
                return getID(id);
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Car delete(Integer id) {
        String deleteIDCar = "DELETE FROM carpool.cars WHERE id = ?";
        try(Connection connection = connectionClass.createConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(deleteIDCar)){
            preparedStatement.setInt(1, id);
            int row = preparedStatement.executeUpdate();
            if (row > 0){
                System.out.println("Car deleted " + row);
                return getID(id);
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return null;
    }
}
