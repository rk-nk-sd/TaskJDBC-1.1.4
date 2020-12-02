package jm.task.core.jdbc.util;

import java.sql.*;


public class Util {
    // реализуйте настройку соеденения с БД

    /**
     * Конфигурация для подключения к БД
     */
    private static final String url = "jdbc:mysql://127.0.0.1/jmDatabase";
    private static final String user = "jm";
    private static final String pass = "Pa$$word";

    private static Connection connection;
    private static Statement statement;

    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";


    public Statement getConnectionFromDataBase() {
        connection = null;
        statement = null;

        try {
            /**
             * Открываем соединение с БД
             */
            System.out.println("Регистрирую JDBC драйвер...");
            Class.forName(JDBC_DRIVER);

            System.out.println("Создаю подключение к базе данных...");
            connection = (Connection) DriverManager.getConnection(url, user, pass);

            statement = (Statement) connection.createStatement();

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return statement;
    }
}
