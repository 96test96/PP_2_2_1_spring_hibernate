package hiber.dao;

import org.hibernate.SessionFactory;
import hiber.model.Car;
import hiber.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.TypedQuery;

@Repository
public class CarDaoImp implements CarDao {

    private SessionFactory sessionFactory;

    @Autowired
    public CarDaoImp(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public void addCar(Car car) {
        sessionFactory.getCurrentSession().save(car);
    }

    @Override
    public User getUserCar(String model, int series) {
        TypedQuery<User> query = sessionFactory.getCurrentSession().createQuery("select u from User u where u.car.model = :model and u.car.series = :series", User.class);
        query.setParameter("model", model).setParameter("series", series);
        return query.getSingleResult();
    }
}
