/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Example;
import org.hibernate.criterion.Restrictions;
import pojos.*;

/**
 *
 * @author Nourhan
 */
public class EventDAO {
    
    static Session session;
    public EventDAO()
    {
        session = HibernateUtil.getSessionFactory().openSession();
    }
    
    public Event retrieveEvent(Event event)
    {
        /*
        System.out.println(event.getEventName());
        Example eventExample = Example.create(event)
                .ignoreCase().enableLike(MatchMode.ANYWHERE);
        List l= session.createCriteria(Event.class)
                .add(eventExample).list();
        System.out.println(l.size());
       
        */
        Criteria criteria = session.createCriteria(Event.class)
                .add(Restrictions.eq("eventName", event.getName()));
        List l= criteria.list();
        if(l.size()>0)
        {
            System.out.println("nnnnnnnnnnnnno nuuuuuuuuuuuuul");
            System.err.println((Event) l.get(0));
            Event e=(Event) l.get(0);
            return e;
        }
        else{
            System.out.println("Sorrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrry");
            return null;}
    }
    
    public List retrieveAllEvents(Event event)
    {
        Example eventExample = Example.create(event);
        List<Event> l= session.createCriteria(Event.class)
                .add(eventExample).list();
        if(l.size()>0)
        {
            return l;
        }
        else
            return null;
        
    }
    
}
