package peaksoft;

import peaksoft.dao.UserDaoHibernateImpl;
import peaksoft.dao.UserDaoJdbcImpl;
import peaksoft.util.Util;


public class Main {
    public static void main(String[] args) {
        // реализуйте алгоритм здесь


        UserDaoHibernateImpl userDaoHibernate= new UserDaoHibernateImpl();
        UserDaoJdbcImpl userDaoJdbc= new UserDaoJdbcImpl();
//        userDaoJdbc.createUsersTable();

//        UserDaoJdbcImpl userDaoJdbc= new UserDaoJdbcImpl();
//        userDaoJdbc.createUsersTable();
//        System.out.println(Util.getSession());
//        userDaoHibernate.dropUsersTable();
//        userDaoHibernate.saveUser("Baktulan","Nazirbek uulu", (byte) 23);
//        userDaoHibernate.saveUser("Asel","Janbolot kyzy", (byte) 23);
//        userDaoHibernate.saveUser("Aizada","Asanova", (byte) 23);
//        userDaoHibernate.getAllUsers().forEach(System.out::println);
//        userDaoHibernate.removeUserById(1L);
//        userDaoHibernate.cleanUsersTable();



    }
}
