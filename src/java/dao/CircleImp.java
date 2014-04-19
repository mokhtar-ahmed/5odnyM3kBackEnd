
package dao;

import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import pojos.*;

/**
 *
 * @author Rehab
 */
public class CircleImp implements CircleInt{

    @Override
    public void addCircle(Circle circle) {
        Session session=Controller.getSessionFactory().openSession();
        session.beginTransaction();
        session.persist(circle);
        session.getTransaction().commit();
    }

    @Override
    public List<Circle> retrieveUserCircles(Users user){
        /*Session session=Controller.sessionFactory.openSession();
        String str1 = "from Users u, Circle c , ExistIn e where u.id=e.users.id and c.idCircle=e.circle.idCircle";
        
        Query q1 = session.createQuery(str1);//.setInteger("uid", user.getCircles().);
        List<Circle> list1 = q1.list();
        for (int i = 0; i < list1.size(); i++) {
            Circle c = list1.get(i);
            System.out.println("user "+ i + "= " + c.getCircleName());
        }
        return list1;*/
        Session session=Controller.getSessionFactory().openSession();
        String str1 = "from Circle c where c.users.id like :uid";
        
        Query q1 = session.createQuery(str1).setInteger("uid", user.getId());
        List<Circle> list1 = q1.list();
        return list1;
    }

    @Override
    public void editCircle(Circle circle) {
        Session session=Controller.getSessionFactory().openSession();
        session.beginTransaction();
        session.saveOrUpdate(circle);
        session.getTransaction().commit();
    }

    @Override
    public void deleteCircle(Circle circle) {
        Session session=Controller.getSessionFactory().openSession();
        Circle c=retrieveCircleById(circle);
        session.beginTransaction();
        session.delete(c);
        session.getTransaction().commit();
    }

    @Override
    public void blockUserFromCircle(ExistIn ex) {
        Session session=Controller.getSessionFactory().openSession();
        session.beginTransaction();
        ex.setBolckStatue("open");
        session.persist(ex);
        session.getTransaction().commit();
    }

    @Override
    public boolean isBlocked(ExistIn ex) {
        Session session=Controller.getSessionFactory().openSession();
        session.beginTransaction();
        if(ex.getBolckStatue().equals("open"))
        return true;
        return false;
    }

    @Override
    public void addUserToCircle(Users user, Circle circle) {////////
        Session session=Controller.getSessionFactory().openSession();
        session.beginTransaction();
        ExistIn ex=new ExistIn(user, circle, "open");
        session.persist(ex);
        session.getTransaction().commit();
    }

    @Override
    public void removeUserFromCircle(Users user, Circle circle) {
        Session session=Controller.getSessionFactory().openSession();
        session.beginTransaction();
        ExistIn ex=new ExistIn(user, circle, "open");
        ExistIn e=retrieveExistInUser(ex);
        session.delete(e);
        session.getTransaction().commit();
    }

    @Override
    public Circle retrieveCircleByName(Users user, Circle circle) {
        return null;
        
    }

    @Override
    public List<Users> retrieveCircleUsers( Circle circle) {
        Session session=Controller.getSessionFactory().openSession();
        String str1 = "from Circle c , ExistIn e where c.idCircle=e.circle.idCircle";
        //String str1
        Query q1 = session.createQuery(str1);//.setInteger("uid", user.getCircles().);
        List<ExistIn> list1 = q1.list();
        List<Users> list2 = null;
        for (int i = 0; i < list1.size(); i++) {
            System.out.println(list1.get(i).getUsers().getName());
            //list2.add(list1.get(i).getUsers());
        }
        return list2;
    }

    @Override
    public Circle retrieveCircleById(Circle circle) {
        Session session=Controller.getSessionFactory().openSession();
        List<Circle> x;
        String s="from Circle c where c.idCircle like :id";
        Query q = session.createQuery(s).setInteger("id",circle.getIdCircle()); 
        x=q.list();
        session.beginTransaction();
        session.getTransaction().commit();
        
        if(!x.isEmpty())
            return x.get(0);
        else return null;
    }

    @Override
    public ExistIn retrieveExistInUser(ExistIn ex) {
        
        return null;
    }
    
}
