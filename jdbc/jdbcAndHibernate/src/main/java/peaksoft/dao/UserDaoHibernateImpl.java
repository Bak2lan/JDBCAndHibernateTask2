package peaksoft.dao;

import org.hibernate.HibernateException;
import org.hibernate.ObjectNotFoundException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.dialect.MyISAMStorageEngine;
import org.hibernate.query.Query;
import peaksoft.exception.MyException;
import peaksoft.util.Util;

import java.sql.SQLException;
import java.util.List;
import peaksoft.model.User;

public class UserDaoHibernateImpl implements UserDao {

    public UserDaoHibernateImpl() {

    }


    @Override
    public void createUsersTable() {

    }

    @Override
    public void dropUsersTable() {
        Session session=Util.getSession().openSession();
        session.beginTransaction();
        session.createNativeQuery("drop table users").executeUpdate();
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public void saveUser(String name, String lastName, byte age) {
        Session session=Util.getSession().openSession();
        session.beginTransaction();
        User user= new User();
        user.setName(name);
        user.setLastName(lastName);
        user.setAge(age);
        session.persist(user);
        session.getTransaction().commit();
        System.out.println("Successfully saved");
        session.close();
    }

    @Override
    public void removeUserById(long id) {
        try {
            Session session = Util.getSession().openSession();
            session.beginTransaction();
            User user = session.createNativeQuery("select * from users where id=:id ", User.class).setParameter("id", id).getSingleResult();
            if (user==null){
                session.getTransaction().rollback();
                throw new MyException("not found");
            }
            session.remove(user);
            session.getTransaction().commit();
            System.out.println("Successfully deleted");
            session.close();
        }catch (HibernateException |MyException e){
            System.out.println(e.getMessage());
        }
    }

    @Override
    public List<User> getAllUsers() {
        Session session =Util.getSession().openSession();
        session.beginTransaction();
        List<User> resultList = session.createNativeQuery("select * from users", User.class).getResultList();
        session.getTransaction().commit();
        session.close();
        return resultList;
    }

    @Override
    public void cleanUsersTable() {
    Session session=Util.getSession().openSession();
    session.beginTransaction();
    session.createNativeQuery("truncate table users").executeUpdate();
    session.getTransaction().commit();
    session.close();

    }
}