package dao;

import java.util.List;
import pojos.*;

public class test {
    
    
    public static void main(String[] args){
    
        
        List<User> user =  new UserHome().getUser(1);
        if(!user.isEmpty()){
           List<Event> ev =  new EventHome().searchEventByDriver(user.get(0));
          System.out.println(ev.size());
        }
        
        Location loc = new Location();
        loc.setIdLocation(1);
        
          List<Event> ev1 =  new EventHome().searchEventByFromLocation(loc);
             System.out.println(ev1.size());
                
    }
}
