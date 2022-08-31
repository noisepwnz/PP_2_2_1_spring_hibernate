package hiber.dao;

import hiber.model.Car;
import hiber.model.User;

import java.util.List;

public interface UserDao {
   void addUser(User user);


   User getUserByCar(String model, int series);

   List<User> listUsers();

}
