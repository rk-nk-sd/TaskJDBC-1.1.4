package jm.task.core.jdbc.util;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;


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

    // Для Hibernet
    private static SessionFactory sessionFactory;
    private static ServiceRegistry serviceRegistry;
    static {
        try {
            Configuration configuration = getConfig();
            //configuration.configure();
            serviceRegistry = new StandardServiceRegistryBuilder().applySettings(
                    configuration.getProperties()).build();
            sessionFactory = configuration.buildSessionFactory(serviceRegistry);
        } catch (HibernateException he) {
            he.printStackTrace();
        }
    }
    public static Configuration getConfig() {
        Configuration configuration = new Configuration()
                .setProperty("hibernate.connection.driver_class", JDBC_DRIVER)
                .setProperty("hibernate.connection.url", url)
                .setProperty("hibernate.connection.username", user)
                .setProperty("hibernate.connection.password", pass)
                .setProperty("hibernate.dialect", "org.hibernate.dialect.MySQL5Dialect")
                .setProperty("hibernate.show_sql", "true")
                .setProperty("hibernate.hbm2ddl.auto", "update")
                .setProperty("hibernate.current_session_context_class", "thread")
                .addAnnotatedClass(jm.task.core.jdbc.model.User.class);
        return configuration;
    }
    public static Session getSession () {
        return sessionFactory.openSession();
    }
    //конец блока Hibernet


    public Statement getConnectionFromDataBase() {
        connection = null;
        statement = null;

        try {
            /**
             * Открываем соединение с БД
             */
            Class.forName(JDBC_DRIVER);

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
