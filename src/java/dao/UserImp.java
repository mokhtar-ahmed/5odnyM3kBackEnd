/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package dao;

import static dao.CircleImp.session;
import java.util.List;
import org.hibernate.EntityMode;
import org.hibernate.Query;
import org.hibernate.Session;
import pojo.Circle;
import pojo.ExistIn;
import pojo.User;

/**
 *
 * @author Rehab
 */
public class UserImp implements UsersInt{
    static Session session;
    public UserImp()
    {
         session= Controller.getSessionFactory().openSession();
    }
    static Session getSession()
    {
        return session;
    }
    
    @Override
    public void addUser(User user) {
        session.beginTransaction();
        session.persist(user);
        session.getTransaction().commit();
    }

    @Override
    public User retrieveUserByUserName(User user) {
        List<User> x;
        String s="from Users u where u.username =:username";
        Query q = session.createQuery(s).setString("username",user.getUsername()); 
        x=q.list();
        session.beginTransaction();
        session.getTransaction().commit();
        
        if(!x.isEmpty())
            return x.get(0);
        else return null;
    }

    @Override
    public User retrieveUserById(User user) {
        List<User> x;
        String s="from Users u where u.id =:uid";
        Query q = session.createQuery(s).setInteger("uid",user.getId()); 
        x=q.list();
        session.beginTransaction();
        session.getTransaction().commit();
        
        if(!x.isEmpty())
            return x.get(0);
        else return null;
    }
    
    public void edit(User user){
        session.beginTransaction();
        session.merge(user);
        session.getTransaction().commit();
    }

}
