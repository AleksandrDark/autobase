package dao;

import domain.Driver;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DriverDaoImpl implements DaoDriver {
    private final ConnectionClass connectionClass = new ConnectionClass();

    @Override
    public Driver getID(Integer id) {
        String selectIDDriver = "SELECT * FROM carpool.drivers WHERE id = ?";
        try (Connection connection = connectionClass.createConnection();
             PreparedStatement statement = connection.prepareStatement(selectIDDriver)) {
            statement.setInt(1, id);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                Integer idDriver = rs.getInt(1);
                String name = rs.getString(2);
                String surname = rs.getString(3);
                Integer salary = rs.getInt(4);
                return new Driver(idDriver, name, surname, salary);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Driver> getAll() {
        List<Driver> drivers = new ArrayList<>();
        String selectDrivers = "SELECT * FROM carpool.drivers";
        try (Connection connection = connectionClass.createConnection();
             Statement statement = connection.createStatement();
             ResultSet rs = statement.executeQuery(selectDrivers)) {
            while (rs.next()) {
                Integer id = rs.getInt(1);
                String name = rs.getString(2);
                String surname = rs.getString(3);
                Integer salary = rs.getInt(4);
                drivers.add(new Driver(id, name, surname, salary));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return drivers;
    }

    @Override
    public Driver create(Driver driver) {
        String insertDriver = "INSERT INTO `carpool`.`drivers` (`name`, `surname`, `salary`) VALUES (?, ?, ?)";
        try (Connection connection = connectionClass.createConnection();
             PreparedStatement statement = connection.prepareStatement(insertDriver, Statement.RETURN_GENERATED_KEYS)) {
            statement.setString(1, driver.getName());
            statement.setString(2, driver.getSurname());
            statement.setInt(3, driver.getSalary());
            int row = statement.executeUpdate();
            ResultSet rs = statement.getGeneratedKeys();
            if (row > 0) {
                System.out.println("Водитель добавлен");
                while(rs.next()){
                    Integer id = rs.getInt(1);
                    return getID(id);
                }
            } else System.out.println("Ошибка ввода");
            //написать код который будет возвращать из базы данных вставленного сотрудника
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Driver update(Integer id, Driver driver) {
        String updateDriver = "UPDATE `carpool`.`drivers` SET name = ?, surname = ?, salary = ? WHERE id = ?";
        try (Connection connection = connectionClass.createConnection();
             PreparedStatement statement = connection.prepareStatement(updateDriver)) {
            statement.setString(1, driver.getName());
            statement.setString(2, driver.getSurname());
            statement.setInt(3, driver.getSalary());
            statement.setInt(4, id);
            int row = statement.executeUpdate();
            if (row > 0){
                System.out.println("Водитель успешно обновлен");
                return getID(id);
            }else System.out.println("Ошибка добавления водителя, повторите ввод");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Driver delete(Integer id) {
        String deleteIDDriver = "DELETE FROM `carpool`.`drivers` WHERE id = ?";
        try (Connection connection = connectionClass.createConnection();
             PreparedStatement statement = connection.prepareStatement(deleteIDDriver)) {
            statement.setInt(1, id);
            int row = statement.executeUpdate();
            if (row > 0) {
                System.out.println("Водитель успешно удален");
                return getID(id);
            } else System.out.println("Ошибка удаления водителя, введите существующий id");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
