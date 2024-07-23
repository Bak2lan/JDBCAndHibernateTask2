package peaksoft.util;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;
import peaksoft.model.User;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLClientInfoException;
import java.sql.SQLException;
import java.util.Properties;

public class Util {
    // реализуйте настройку соеденения с БД

    public static SessionFactory getSession(){
        Properties properties= new Properties();
        properties.put(Environment.DRIVER,"org.postgresql.Driver");
        properties.put(Environment.URL,"jdbc:postgresql://localhost:5432/sql");
        properties.put(Environment.USER,"postgres");
        properties.put(Environment.PASS,"1234");
        properties.put(Environment.HBM2DDL_AUTO,"create");
        properties.put(Environment.SHOW_SQL,"true");


        Configuration configuration= new Configuration();
        configuration.addProperties(properties);
        configuration.addAnnotatedClass(User.class);
        return configuration.buildSessionFactory();
    }

    public static Connection getConnection(){
        Connection connection=null;
        try {
            connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/sql",
                    "postgres",
                    "1234");
            System.out.println("Successfully connected");
        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
        return connection;

    }
}
