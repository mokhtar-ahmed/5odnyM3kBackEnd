/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package webservices;
import dao.EventHome;
import dao.UserHome;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import org.json.simple.*;
import pojos.Event;
import pojos.Notification;
import pojos.Users;
/**
 *
 * @author Mo5a
 */
public class NotificationUtil {
    
    public static Notification convertJsonToNotification(JSONObject obj) throws ParseException{
       
        Event event = new EventHome().getEventById(Integer.parseInt((String)obj.get("eventId")));
        List<Users> users = new UserHome().getUser(Integer.parseInt((String)obj.get("userId")));
        SimpleDateFormat formatter = new SimpleDateFormat("dd-MMM-yyyy");
        Date date = formatter.parse((String)obj.get("notificationDate"));
        
        Notification nf = new Notification();
        nf.setEvent(event);
        nf.setUsers(users.get(0));
        nf.setEventType((String)obj.get("eventType"));
        nf.setNotificationDate(date);
        nf.setEventState((String)obj.get("eventState"));
        
        return nf;
        
    }
    
      public static  JSONObject convertJsonToNotification(Notification nf){
       
       JSONObject output= new JSONObject();
      
       output.put("eventId", nf.getEvent());
       output.put("userId", nf.getUsers());
       output.put("eventState", nf.getEventState());
       output.put("eventType", nf.getEventType());
       output.put("notificationDate", nf.getNotificationDate());
       output.put("id", nf.getId());
        
       return output;
        
    }
      
}
