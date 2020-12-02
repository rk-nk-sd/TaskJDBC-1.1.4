package jm.task.core.jdbc.dao;

import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.util.Util;

import java.sql.SQLException;
import java.util.List;

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
        new Util().getConnectionFromDataBase(SQL);
        System.out.println("Таблица пользователей успешно создана...");

    }

    public void dropUsersTable() {
        String SQL = "DROP TABLE " + table;
        new Util().getConnectionFromDataBase(SQL);
        System.out.println("Таблица пользователей успешно удалена из БД...");

    }

    public void saveUser(String name, String lastName, byte age) {
        String SQL = "INSERT `" + table + "`(`name`, `lastname`, `age`) VALUES ('" + name + "', '" + lastName + "', '" + age + "')";
        new Util().getConnectionFromDataBase(SQL);
        System.out.println("Данные пользователя успешно удалены в БД...");
    }

    public void removeUserById(long id) {
        String SQL = "DELETE FROM " + table + " WHERE " + id;
    }

    public List<User> getAllUsers() {
        return null;
    }

    public void cleanUsersTable() {
        String SQL = "TRUNCATE TABLE " + table;
        new Util().getConnectionFromDataBase(SQL);
        System.out.println("Таблица успешно очищена, ее структура не затронута...");

    }
}
