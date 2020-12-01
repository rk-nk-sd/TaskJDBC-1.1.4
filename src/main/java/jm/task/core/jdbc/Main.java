package jm.task.core.jdbc;

import com.mysql.jdbc.Connection;
import jm.task.core.jdbc.util.Util;

public class Main {
    public static void main(String[] args) {
        // реализуйте алгоритм здесь
         Connection connection = new Util().getConnectionFromDataBase();
        System.out.println(connection.toString());
    }
}
