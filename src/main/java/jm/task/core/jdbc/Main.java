package jm.task.core.jdbc;

import jm.task.core.jdbc.dao.UserDaoHibernateImpl;
import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.service.UserServiceImpl;

import java.util.Iterator;

public class Main {
    public static void main(String[] args) {
        // реализуйте алгоритм здесь

        /**
         * Создание таблицы User(ов)
         */
//        new UserServiceImpl().createUsersTable();

        /**
         * Добавление 4 User(ов) в таблицу с данными на свой выбор.
         * После каждого добавления должен быть вывод в консоль
         * ( User с именем – name добавлен в базу данных )
         */
        new UserServiceImpl().saveUser("Владимир", "Пупкин", (byte) 60);
        new UserServiceImpl().saveUser("Дмитрий", "Трутнев", (byte) 55);
        new UserServiceImpl().saveUser("Михаил", "Капустин", (byte) 50);
        new UserServiceImpl().saveUser("Антон", "Силович", (byte) 59);

        /**
         * Получение всех User из базы и вывод в консоль
         * ( должен быть переопределен toString в классе User)
         */
//        Iterator<User> iterator = new UserServiceImpl().getAllUsers().iterator();
//        while(iterator.hasNext()) {
//            System.out.println(iterator.next().toString());
//        }
        /**
         * Удаление пользователя по id
         */
        //new UserServiceImpl().removeUserById(4); //РАБОТАЕТ

        /**
         * Очистка таблицы User(ов)
         */
//        new UserServiceImpl().cleanUsersTable(); //РАБОТАЕТ

        /**
         * Удаление таблицы пользователей из БД
         */
//        new UserServiceImpl().dropUsersTable();

    }
}
