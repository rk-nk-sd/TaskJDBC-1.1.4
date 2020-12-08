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
        Session session = Util.getSession();
        session.getTransaction();
    }

    @Override
    public void dropUsersTable() {

    }

    @Override
    public void saveUser(String name, String lastName, byte age) {
        Session session = Util.getSession();
        Transaction transaction = session.beginTransaction();
        String hql = "INSERT INTO User(name, lastName, age) VALUES ('" + name + "', '" + lastName + "', '" + age + "')";
        session.createQuery (hql).executeUpdate();
        transaction.commit();
    }

    @Override
    public void removeUserById(long id) {
        Session session = Util.getSession();
        Transaction transaction = session.beginTransaction();
        String hql = "DELETE User WHERE id = :id";
        Query query = session.createQuery(hql);
        query.setParameter("id", id);
        query.executeUpdate();
        transaction.commit();
    }

    @Override
    public List<User> getAllUsers() {
        Session session = Util.getSession();
//        String query = "SELECT * FROM new_table";
//        List<User> user = (List<User>) session.createSQLQuery(query).addEntity(User.class).list();
        List<User> user = session.createQuery("From User").list();
        return user;
    }

    @Override
    public void cleanUsersTable() {
        Session session = Util.getSession();
        Transaction transaction = session.beginTransaction();
        String hql = "DELETE FROM User";
        session.createQuery(hql).executeUpdate();
        transaction.commit();
    }
}
