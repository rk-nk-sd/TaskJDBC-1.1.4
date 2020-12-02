package jm.task.core.jdbc;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;
import jm.task.core.jdbc.dao.UserDaoJDBCImpl;
import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.util.Util;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Iterator;

public class Main {
    public static void main(String[] args) {
        // реализуйте алгоритм здесь
        //new UserDaoJDBCImpl().getAllUsers();
        Iterator<User> iterator = new UserDaoJDBCImpl().getAllUsers().iterator();
        while(iterator.hasNext()) {
            System.out.println(iterator.next().getName());
        }
    }
}
