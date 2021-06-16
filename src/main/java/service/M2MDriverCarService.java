package service;

import dao.DaoM2MDriverCar;
import dao.M2MDriverCarDaoImpl;

import java.util.List;

public class M2MDriverCarService {
    private final DaoM2MDriverCar dao = new M2MDriverCarDaoImpl();

    public List<String> getAllDriverCar(){
        return dao.getAllDriverAndCars();
    }
}
