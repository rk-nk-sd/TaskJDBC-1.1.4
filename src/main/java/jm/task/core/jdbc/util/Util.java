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
    private static ResultSet resultSet;

    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";


    public ResultSet getConnectionFromDataBase(String query) throws ClassNotFoundException, SQLException {
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

            //System.out.println("Начинаю удаление таблицы из БД...");
            statement = (Statement) connection.createStatement();
            statement.executeUpdate(query);


        } catch (SQLException sqle) {
            sqle.printStackTrace();
        } finally {
            try {
                if (statement != null)
                    statement.close();
                if (connection != null)
                connection.close();
            } catch(SQLException se) {  }
        }
        //return resultSet;
        return null;
    }
}
