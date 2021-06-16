package dao;

import domain.DriverCarM2M;

import java.util.List;

public interface DaoM2MDriverCar extends Dao<DriverCarM2M>{

    List<String> getAllDriverAndCars();
}
