package webservices;

import org.json.simple.JSONObject;
import pojos.Event;

class JSONUtils {

   public static JSONObject ConvertEventToJson(Event event) {
      
       
       JSONObject obj = new JSONObject();
  
        obj.put(obj,event.getDate());
        obj.put(obj,event.getEventStatue());
        obj.put(obj,event.getId());
        obj.put(obj,event.getLocation());
        obj.put(obj,event.getName());
        obj.put(obj,event.getNoOfSlots());
        obj.put(obj,event.getUser());
       
       return null;
         
    }
    
}
