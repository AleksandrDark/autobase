package service;

import dao.DaoDriver;
import dao.DriverDaoImpl;
import domain.Driver;

import java.util.List;

public class DriverService {
    private final DaoDriver driverDao = new DriverDaoImpl();


    public Driver get(Integer id) {
        return driverDao.getID(id);

    }

    public List<Driver> getAll(){
        return driverDao.getAll();
    }

    public Driver create(Driver driver){
        return driverDao.create(driver);
    }

    public Driver update(Integer id, Driver driver){
        return driverDao.update(id, driver);
    }

    public Driver deleteID(Integer id){
        return driverDao.delete(id);
    }

}
