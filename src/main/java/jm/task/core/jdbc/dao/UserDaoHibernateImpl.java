package jm.task.core.jdbc.dao;

import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.util.Util;
import org.hibernate.*;


import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static jm.task.core.jdbc.util.Util.getSessionFactory;

public class UserDaoHibernateImpl implements UserDao {
    public UserDaoHibernateImpl() {

    }


    @Override
    public void createUsersTable() {
        Session session = getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();

        String sql = "CREATE TABLE IF NOT EXISTS users " +
                "(id BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY, " +
                "name VARCHAR(50) NOT NULL, lastName VARCHAR(50) NOT NULL, " +
                "age TINYINT NOT NULL)";

        session.createSQLQuery(sql).executeUpdate();

        transaction.commit();
        session.close();
    }
    @Override
    public void dropUsersTable() {
        Session session = getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();

        String sql = "DROP TABLE IF EXISTS users";

        session.createSQLQuery(sql).executeUpdate(); // addEntity(User.class);

        transaction.commit();
        session.close();
    }



    @Override
    public void saveUser(String name, String lastName, byte age) {
        User user = new User(name, lastName, age);
        try(Session session = Util.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            session.save(user);
            transaction.commit();
        }catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void removeUserById(long id) {

        try(Session session = Util.getSessionFactory().openSession()){
            Transaction transaction = session.beginTransaction();
            User user = session.find(User.class, id);

            if(user != null) {

                session.delete(user);
                transaction.commit();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }


    @Override
    public List<User> getAllUsers() throws SQLException, ClassNotFoundException {
        List<User> from_users;
        try (Session session = Util.getSessionFactory().openSession()) {
            Transaction  transaction = session.beginTransaction();
            transaction.commit();
            from_users = session.createQuery("from User", User.class).list();
            return from_users;
        }
    }

    @Override
    public void cleanUsersTable() {
        Transaction transaction = null;
        Session session = Util.getSessionFactory().openSession();
        transaction = session.beginTransaction();

        session.createSQLQuery("TRUNCATE TABLE users").executeUpdate();

        transaction.commit();
        session.close();

    }
}
