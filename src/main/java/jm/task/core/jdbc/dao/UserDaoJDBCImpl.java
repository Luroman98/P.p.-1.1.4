//package jm.task.core.jdbc.dao;
//
//import jm.task.core.jdbc.model.User;
//import jm.task.core.jdbc.util.Util;
//
//import java.sql.*;
//import java.util.ArrayList;
//import java.util.List;
//
//public class UserDaoJDBCImpl implements UserDao {
//    Connection conn;
//    public UserDaoJDBCImpl () {
//    }
//
//
//
//    public void createUsersTable() throws SQLException, ClassNotFoundException {
//        String sqlCommand = "CREATE TABLE Users (Id INT PRIMARY KEY AUTO_INCREMENT, name VARCHAR(20), lastName VARCHAR(20), age INT)";
//
//        try(Connection conn = Util.getMySQLConnection(); Statement statement = conn.createStatement()) {
//            statement.executeUpdate(sqlCommand);
//        } catch (SQLException e) {
//            System.out.println("An error has occured on Create Table");
//        } catch (ClassNotFoundException e) {
//            System.out.println("An Mysql drivers were not found");
//        }
//    }
//
//    public void dropUsersTable() throws SQLException, ClassNotFoundException {
//
//        String sqlcommand = "DROP TABLE Users";
//        try(Connection conn = Util.getMySQLConnection(); Statement statement = conn.createStatement()) {
//            statement.execute(sqlcommand);
//        } catch (SQLException e) {
//            System.out.println("An error has occured on Drop Creation");
//        } catch (ClassNotFoundException e) {
//            System.out.println("An Mysql drivers were not found");
//        }
//    }
//
//    public void saveUser(String name, String lastName, byte age) throws SQLException, ClassNotFoundException {
//        String sqlcommand = "INSERT INTO Users (id, name, lastName, age) " +
//                "VALUES(?, ?, ?, ?)";
//        try(Connection conn = Util.getMySQLConnection(); PreparedStatement preparedStatement = conn.prepareStatement(sqlcommand)) {
//            ResultSet ggg = preparedStatement.executeQuery("select * from Users");
//            int id = 0;
//            while (ggg.next()) {
//                id = ggg.getInt(1);
//
//            }
//            preparedStatement.setInt(1, ++id);
//            preparedStatement.setString(2, name);
//            preparedStatement.setString(3, lastName);
//            preparedStatement.setByte(4, age);
//
//            preparedStatement.execute();
//
//        } catch (SQLException e) {
//            System.out.println("An error has occured on Clean Table");
//        } catch (ClassNotFoundException e) {
//            System.out.println("An Mysql drivers were not found");
//        }
//    }
//
//    public void removeUserById(long id) throws SQLException, ClassNotFoundException {
//        String sqlcommand = "DELETE FROM Users WHERE id=?";
//        try (Connection conn = Util.getMySQLConnection(); PreparedStatement preparedStatement = conn.prepareStatement(sqlcommand)) {
//            preparedStatement.setLong(1, id);
//
//            preparedStatement.execute();
//        } catch (SQLException e) {
//            System.out.println("An error has occured on Clean Table");
//        } catch (ClassNotFoundException e) {
//            System.out.println("An Mysql drivers were not found");
//        }
//    }
//
//    public List<User> getAllUsers() throws SQLException, ClassNotFoundException {
//        List<User> userList = new ArrayList<>();
//        String sqlcommand = "select * from Users";
//        try(Connection conn = Util.getMySQLConnection(); Statement statement = conn.createStatement()) {
//            ResultSet resultSet = statement.executeQuery(sqlcommand);
//            while (resultSet.next()) {
//                User user = new User();
//                user.setId(resultSet.getLong("id"));
//                user.setName(resultSet.getString("name"));
//                user.setLastName(resultSet.getString("lastName"));
//                user.setAge(Byte.valueOf(resultSet.getString("age")));
//                userList.add(user);
//            }
//        } catch (SQLException e) {
//            System.out.println("An error has occured on get all Users");
//        } catch (ClassNotFoundException e) {
//            System.out.println("An Mysql drivers were not found");
//        }
//        return userList;
//    }
//
//    public void cleanUsersTable() throws SQLException, ClassNotFoundException {
//
//        String sqlcommand = "TRUNCATE TABLE Users";
//        try(Connection conn = Util.getMySQLConnection(); Statement statement = conn.createStatement()) {
//            statement.execute(sqlcommand);
//
//        } catch (SQLException e) {
//            System.out.println("An error has occured on Clean Table");
//        } catch (ClassNotFoundException e) {
//            System.out.println("An Mysql drivers were not found");
//        }
//
//    }
//}
