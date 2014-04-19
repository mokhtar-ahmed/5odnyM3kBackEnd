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
import pojos.*;

/**
 *
 * @author Rehab
 */
public class UserImp implements UsersInt{

    @Override
    public void addUser(Users user) {
         Session session=Controller.getSessionFactory().openSession();
        session.beginTransaction();
        session.persist(user);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public Users retrieveUserByUserName(Users user) {
        //Session session=Controller.sessionFactory.getCurrentSession();
        
        Session session = Controller.getSessionFactory().openSession();
        
        
        System.out.println("dsadsadsadsadsa");
        
        List<Users> x;
        String s="from Users u where u.username like :username";
        Query q = session.createQuery(s).setString("username",user.getUsername()); 
        x=q.list();
        session.beginTransaction();
        session.getTransaction().commit();
        
        session.close();
        
        
        if(!x.isEmpty())
            return x.get(0);
        else return null;
    }
    
}
