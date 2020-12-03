package jm.task.core.jdbc.dao;

import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.util.Util;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class UserDaoJDBCImpl implements UserDao {
    private static final String table = "new_table";
    public UserDaoJDBCImpl() {

    }

    public void createUsersTable() {
        String SQL = "CREATE TABLE IF NOT EXISTS `jmDatabase`.`" + table + "` (\n" +
                "  `id` INT NOT NULL AUTO_INCREMENT,\n" +
                "  `name` VARCHAR(45) NULL,\n" +
                "  `lastname` VARCHAR(45) NULL,\n" +
                "  `age` TINYINT NULL,\n" +
                "  PRIMARY KEY (`id`));";
        Statement statement = new Util().getConnectionFromDataBase();
        try {
            statement.executeUpdate(SQL);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public void dropUsersTable() {
        String SQL = "DROP TABLE IF EXISTS " + table;
        Statement statement = new Util().getConnectionFromDataBase();
        try {
            statement.executeUpdate(SQL);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public void saveUser(String name, String lastName, byte age) {
        String SQL = "INSERT `" + table + "`(`name`, `lastname`, `age`) VALUES ('" + name + "', '" + lastName + "', '" + age + "')";
        Statement statement = new Util().getConnectionFromDataBase();
        try {
            statement.executeUpdate(SQL);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public void removeUserById(long id) {
        String SQL = "DELETE FROM " + table + " WHERE id = " + id;
        Statement statement = new Util().getConnectionFromDataBase();
        try {
            statement.executeUpdate(SQL);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    /**
     * Возвращает список пользователей вида List<User>
     * @return
     */
    public List<User> getAllUsers() {
        String SQL = "SELECT * FROM " + table;
        List<User> listUsers = new ArrayList<User>();

        try {
            ResultSet resultSet = new Util().getConnectionFromDataBase().executeQuery(SQL);
            while (resultSet.next()) {
                int i = resultSet.getInt("id");
                String name = resultSet.getString("name");
                String lastname = resultSet.getString("lastname");
                byte age = (byte) resultSet.getInt("age");
                //Assuming you have a user object
                User user = new User(name, lastname, age);
                listUsers.add(user);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return listUsers;
    }

    /**
     * Очистка таблицы пользователей
     */
    public void cleanUsersTable() {
        String SQL = "TRUNCATE TABLE " + table;
        Statement statement = new Util().getConnectionFromDataBase();
        try {
            statement.executeUpdate(SQL);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
