/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import pojos.Users;


public class UserHome {
    Session session; 
    
    public UserHome(){
    
        session = new HibernateUtil().getSessionFactory().openSession();
        
    }
      public List<Users> getUser(Integer id){
        
          Query createQuery = session.createQuery("from User u where u.id = :user ").setString("user", id.toString());
          List<Users> u = createQuery.list();
          return u;
    }
    
    
}
