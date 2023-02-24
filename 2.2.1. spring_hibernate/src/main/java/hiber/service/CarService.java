package hiber.service;

import hiber.dao.CarDao;
import hiber.dao.CarDaoImp;
import hiber.model.Car;
import hiber.model.User;

public interface CarService {

    void addCar(Car car);
   public User getUserCar(String model, int series);
    }

