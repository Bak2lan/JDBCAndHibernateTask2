package peaksoft.service;

import peaksoft.dao.UserDao;
import peaksoft.dao.UserDaoHibernateImpl;
import peaksoft.dao.UserDaoJdbcImpl;
import peaksoft.model.User;

import java.util.List;

public class UserServiceImpl implements UserService {
    UserDao userDao= new UserDaoHibernateImpl();
    UserDaoJdbcImpl userDaoJdbc= new UserDaoJdbcImpl();

    public void createUsersTable() {
userDaoJdbc.createUsersTable();
    }

    public void dropUsersTable() {
userDaoJdbc.dropUsersTable();
    }

    public void saveUser(String name, String lastName, byte age) {
userDaoJdbc.saveUser(name,lastName,age);
    }

    public void removeUserById(long id) {
userDaoJdbc.removeUserById(id);
    }

    public List<User> getAllUsers() {
        return userDaoJdbc.getAllUsers();
    }

    public void cleanUsersTable() {
        userDaoJdbc.cleanUsersTable();
    }
}
