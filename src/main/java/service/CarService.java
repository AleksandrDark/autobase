package service;

import dao.CarDaoImpl;
import dao.DaoCar;
import domain.Car;

import java.util.List;

public class CarService {
    private final DaoCar carDao = new CarDaoImpl();

    public Car getID(Integer id) {
        return carDao.getID(id);
    }

    public List<Car> getAllCars(){
        return carDao.getAll();
    }

    public Car create(Car car){
        return carDao.create(car);
    }

    public Car update(Integer id, Car car){
        return carDao.update(id, car);
    }

    public Car deleteID(Integer id){
        return carDao.delete(id);
    }

}
