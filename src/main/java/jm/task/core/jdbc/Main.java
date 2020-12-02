package jm.task.core.jdbc;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;
import jm.task.core.jdbc.dao.UserDaoJDBCImpl;
import jm.task.core.jdbc.util.Util;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args) {
        // реализуйте алгоритм здесь
        new UserDaoJDBCImpl().removeUserById(6);
    }
}
