/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package dao;

import java.util.List;
import org.hibernate.EntityMode;
import org.hibernate.Query;
import org.hibernate.Session;
import pojos.Circle;
import pojos.ExistIn;
import pojos.Users;

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
    public void addUser(Users user) {
        session.beginTransaction();
        session.persist(user);
        session.getTransaction().commit();
    }

    @Override
    public Users retrieveUserByUserName(Users user) {
        List<Users> x;
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
    public Users retrieveUserById(Users user) {
        List<Users> x;
        String s="from Users u where u.id =:uid";
        Query q = session.createQuery(s).setInteger("uid",user.getId()); 
        x=q.list();
        session.beginTransaction();
        session.getTransaction().commit();
        
        if(!x.isEmpty())
            return x.get(0);
        else return null;
    }

    @Override
    public void addUserToCircle(ExistIn e) {
        session.beginTransaction();
        session.persist(e);
        session.getTransaction().commit();
    }
    
}
