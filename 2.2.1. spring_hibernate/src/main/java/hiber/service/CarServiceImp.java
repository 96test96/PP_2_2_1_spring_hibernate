package hiber.service;

import hiber.dao.CarDao;
import hiber.dao.CarDaoImp;
import hiber.model.Car;
import hiber.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CarServiceImp implements CarService {
    private final CarDao carDao;

    @Autowired
    public CarServiceImp (CarDao carDao) { this.carDao = carDao; }

    @Override
    public void addCar(Car car) { carDao.addCar(car); }
    @Transactional
    @Override
    public User getUserCar(String model, int series) { return carDao.getUserCar(model, series); }
}
