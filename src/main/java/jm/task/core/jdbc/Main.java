package jm.task.core.jdbc;
import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.service.UserService;
import jm.task.core.jdbc.service.UserServiceImpl;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        UserService userService = new UserServiceImpl();

       // userService.createUsersTable();
        List<User> usersss = new ArrayList<>();

       // userService.saveUser( "ivan", "Luk", (byte) 3);
       // userService.cleanUsersTable();
        userService.removeUserById(3);
        usersss = userService.getAllUsers();

        usersss.forEach(x -> System.out.println(x));
    }

}
