package jm.task.core.jdbc.util;

import com.mysql.jdbc.Connection;

import java.sql.DriverManager;
import java.sql.SQLException;


public class Util {
    // реализуйте настройку соеденения с БД

    /**
     * Конфигурация для подключения к БД
     */
    private final String url = "jdbc:mysql://127.0.0.1/jmDatabase";
    private final String user = "jm";
    private final String pass = "Pa$$word";

    private static Connection connection;

    public Connection getConnectionFromDataBase() {
        try {
            /**
             * Открываем соединение с БД
             */
            connection = (Connection) DriverManager.getConnection(url, user, pass);
        } catch (SQLException sqle) {
            sqle.printStackTrace();
        } finally {
            try {
                if (connection != null)
                connection.close();
            } catch(SQLException se) {  }
        }
        return connection;
    }
}
