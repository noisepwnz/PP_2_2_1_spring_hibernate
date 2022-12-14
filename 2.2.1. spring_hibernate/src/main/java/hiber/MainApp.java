package hiber;

import hiber.config.AppConfig;
import hiber.model.Car;
import hiber.model.User;
import hiber.service.UserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.sql.SQLException;
import java.util.List;

public class MainApp {
    public static void main(String[] args) throws SQLException {
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(AppConfig.class);

        UserService userService = context.getBean(UserService.class);


        Car car1 = new Car("Tesla", 3);
        Car car2 = new Car("Audi", 7);
        Car car3 = new Car("Mersedes", 63);
        Car car4 = new Car("BWM", 5);


        userService.addUser(new User("Nikolay", "Belov", "user1@mail.ru", car1));
        userService.addUser(new User("Artem", "Babkin", "user2@mail.ru", car2));
        userService.addUser(new User("Kirill", "Razboykim", "user3@mail.ru", car3));
        userService.addUser(new User("Roman", "Romanov", "user4@mail.ru", car4));


        List<User> users = userService.listUsers();
        for (User user : users) {
            System.out.println("Id = " + user.getId());
            System.out.println("First Name = " + user.getFirstName());
            System.out.println("Last Name = " + user.getLastName());
            System.out.println("Email = " + user.getEmail());
            System.out.println("Car = " + user.getCar());
            System.out.println();
        }
        ;

        System.out.println(userService.getUserByCar("Audi", 7));


        context.close();
    }
}
