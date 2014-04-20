
package webservices;

import com.google.gson.Gson;
import dao.EventDAO;
import java.util.Date;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import org.codehaus.jettison.json.JSONException;
import org.json.simple.JSONObject;
import pojos.*;

@Path("/event")
public class EventManagement {
    
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/getevent")
    public JSONObject retrieveEvent(String event)
    {
        try {
            Event myEvent = new Gson().fromJson(event, Event.class);
            EventDAO edao = new EventDAO();
            myEvent=edao.retrieveEvent(myEvent);
            JSONObject eventJson = new JSONObject();
            
            //id
            int id               = myEvent.getIdEvent();
            eventJson.put("idEvent", id);
            
            //user
            Users user   = myEvent.getUsers();
            JSONObject userJson = new JSONObject();
            userJson.put("id", user.getId());
            userJson.put("username", user.getUsername());
            eventJson.put("user", userJson);
            
            //from location
            Location location    = myEvent.getLocation();
            JSONObject locationJson = new JSONObject();
            locationJson.put("idLocation", location.getIdLocation());
            locationJson.put("address", location.getAddress());
            eventJson.put("location", locationJson);
            
            //name
            String name          = myEvent.getEventName();
            eventJson.put("eventName", name);
            
            //slots
            int slots            = myEvent.getNoOfSlots();
            eventJson.put("noOfSlots", slots);
            
            //date
            Date date            = myEvent.getEventDate();
            eventJson.put("eventDate", date);
            
            //status
            String eventStatue   = myEvent.getEventStatue();
            eventJson.put("eventStatue", eventStatue);
            /*
            //notification
            Set notifications    = myEvent.getNotifications();
            Notification notification;// = new Notification();
            String n = "{\"notifications\":[";
            for(int i =0;i<notifications.size() ;i++)
            {
                notification=(Notification)notifications.iterator().next();
                n+="{\"id\":\"";
                n+=notification.getId();
                n+="\"}";
                if(!notifications.isEmpty())
                    n=",";
            }
            n+="]}";
            JSONObject notificationJson = new JSONObject(n);
            eventJson.put("notifications", notificationJson);
            
            //to
            Set eventToLocations = myEvent.getEventToLocations();
            
            
            //joinevent
            Set joinEvents       = myEvent.getJoinEvents();
            //comments
            Set comments         = myEvent.getComments();*/
            return eventJson;
        } catch (JSONException ex) {
            return null;
        }
    }
    
    
}
