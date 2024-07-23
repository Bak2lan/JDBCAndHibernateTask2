package peaksoft.dao;

import peaksoft.model.User;
import peaksoft.util.Util;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserDaoJdbcImpl implements UserDao {

    public UserDaoJdbcImpl() {

    }

    public void createUsersTable() {
        Connection connection = Util.getConnection();

        String sql="create table  users(" +
                   "id serial primary key," +
                   "name varchar ," +
                   "last_name varchar," +
                   "age int)";
        try {
            Statement statement = connection.createStatement();
            statement.executeUpdate(sql);
            System.out.println("Table successfully created");
            statement.close();
        }catch (SQLException e){
            System.out.println(e.getMessage());
        }

    }

    public void dropUsersTable() {
        Connection connection=Util.getConnection();
        String sql="drop table users cascade";
        try {
            Statement statement = connection.createStatement();
            statement.executeUpdate(sql);
            statement.close();
        }catch (SQLException e){
            System.out.println(e.getMessage());
        }

    }

    public void saveUser(String name, String lastName, byte age) {
        Connection connection=Util.getConnection();
        String sql="insert into users(name,last_name,age)" +
                   "values" +
                   "(?,?,?)";
        User user= new User();
        user.setName(name);
        user.setLastName(lastName);
        user.setAge(age);
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, user.getName());
            preparedStatement.setString(2, user.getLastName());
            preparedStatement.setByte(3, user.getAge());
            preparedStatement.executeUpdate();
            System.out.println("Successfully saved");
            preparedStatement.close();
        }catch (SQLException e){
            System.out.println(e.getMessage());
        }


    }

    public void removeUserById(long id) {
        Connection connection=Util.getConnection();
        String sql="delete from users where id=?";
        try{
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setLong(1,id);
             preparedStatement.executeQuery();
            System.out.println("Successfully deleted");
            preparedStatement.close();
        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
    }

    public List<User> getAllUsers() {
        Connection connection =Util.getConnection();
        String sql="select * from users";
        try{
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            List<User>users= new ArrayList<>();
            while(resultSet.next()){
                users.add(new User(
                        resultSet.getLong("id"),
                        resultSet.getString("name"),
                        resultSet.getString("last_name"),
                        resultSet.getByte("age")));
            }
            statement.close();
            return users;

        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
        return null;
    }

    public void cleanUsersTable() {
        Connection connection=Util.getConnection();
        String sql="truncate table users";
        try{
            Statement statement = connection.createStatement();
            statement.executeUpdate(sql);
            System.out.println("Table successfully cleaned");
            statement.close();
        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
    }
}