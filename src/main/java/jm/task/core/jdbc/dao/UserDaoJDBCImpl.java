package jm.task.core.jdbc.dao;

import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.util.Util;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;

public class UserDaoJDBCImpl implements UserDao {
    private static final String table = "new_table";
    public UserDaoJDBCImpl() {

    }

    public void createUsersTable() {
        String SQL = "CREATE TABLE `jmDatabase`.`" + table + "` (\n" +
                "  `id` INT NOT NULL AUTO_INCREMENT,\n" +
                "  `name` VARCHAR(45) NULL,\n" +
                "  `lastname` VARCHAR(45) NULL,\n" +
                "  `age` INT NULL,\n" +
                "  PRIMARY KEY (`id`));";
        Statement statement = new Util().getConnectionFromDataBase();
        try {
            statement.executeUpdate(SQL);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        System.out.println("Таблица пользователей успешно создана...");

    }

    public void dropUsersTable() {
        String SQL = "DROP TABLE " + table;
        Statement statement = new Util().getConnectionFromDataBase();
        try {
            statement.executeUpdate(SQL);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        System.out.println("Таблица пользователей успешно удалена из БД...");

    }

    public void saveUser(String name, String lastName, byte age) {
        String SQL = "INSERT `" + table + "`(`name`, `lastname`, `age`) VALUES ('" + name + "', '" + lastName + "', '" + age + "')";
        Statement statement = new Util().getConnectionFromDataBase();
        try {
            statement.executeUpdate(SQL);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        System.out.println("Данные пользователя успешно сохранены в БД...");
    }

    public void removeUserById(long id) {
        String SQL = "DELETE FROM " + table + " WHERE id = " + id;
        Statement statement = new Util().getConnectionFromDataBase();
        try {
            statement.executeUpdate(SQL);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        System.out.println("Данные пользователя успешно удалены из БД...");
    }

    public List<User> getAllUsers() {
        String SQL = "SELECT * FROM " + table;
        Statement statement = new Util().getConnectionFromDataBase();
        List<User> listUsers = new ArrayList<User>();

        try {
            ResultSet resultSet = statement.executeQuery(SQL);
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

    public void cleanUsersTable() {
        String SQL = "TRUNCATE TABLE " + table;
        Statement statement = new Util().getConnectionFromDataBase();
        try {
            statement.executeUpdate(SQL);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        System.out.println("Таблица успешно очищена, ее структура не затронута...");

    }
}
