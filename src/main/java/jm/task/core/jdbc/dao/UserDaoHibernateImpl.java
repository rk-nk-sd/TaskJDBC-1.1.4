package jm.task.core.jdbc.dao;

import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.util.Util;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class UserDaoHibernateImpl implements UserDao {
    public UserDaoHibernateImpl() {

    }


    @Override
    public void createUsersTable() {
        try {
            Session session = Util.getSession();
            Transaction transaction = session.beginTransaction();
            String sql = "CREATE TABLE IF NOT EXISTS `jmDatabase`.`new_table` (\n" +
                    "  `id` INT NOT NULL AUTO_INCREMENT,\n" +
                    "  `name` VARCHAR(45) NULL,\n" +
                    "  `lastname` VARCHAR(45) NULL,\n" +
                    "  `age` TINYINT NULL,\n" +
                    "  PRIMARY KEY (`id`));";
            session.createSQLQuery(sql).executeUpdate();
            transaction.commit();
            session.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void dropUsersTable() {
        try {
            Session session = Util.getSession();
            Transaction transaction = session.beginTransaction();
            String sql = "DROP TABLE IF EXISTS new_table";
            session.createSQLQuery(sql).executeUpdate();
            transaction.commit();
            session.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void saveUser(String name, String lastName, byte age) {
        User user = new User();
        user.setName(name);
        user.setLastName(lastName);
        user.setAge(age);

        try {
            Session session = Util.getSession();
            Transaction transaction = session.beginTransaction();
            session.save(user);
            transaction.commit();
            session.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void removeUserById(long id) {
        try {
            Session session = Util.getSession();
            Transaction transaction = session.beginTransaction();
            String hql = "DELETE User WHERE id = :id";
            Query query = session.createQuery(hql);
            query.setParameter("id", id);
            query.executeUpdate();
            transaction.commit();
            session.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<User> getAllUsers() {
        List<User> user = null;
        try {
            Session session = Util.getSession();
            user = session.createQuery("From User").list();
            session.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return user;
    }

    @Override
    public void cleanUsersTable() {
        try {
            Session session = Util.getSession();
            Transaction transaction = session.beginTransaction();
            String hql = "DELETE FROM User";
            session.createQuery(hql).executeUpdate();
            transaction.commit();
            session.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
