/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package dao;

import java.util.List;
import pojos.*;

/**
 *
 * @author Rehab
 */
public interface EventInt {
    public void addEvent(Event event,Users user);
    //public void cancelEvent(Event event,Users user);
    public void closeEventTimeOut(Event event,Users user);
    public void setEventStatus(Users user,Event event);
    public Event editEvent(Users user,Event event);
    public List<Event> retrieveEvetByLocation(Location location);
    public List<Event> retreiveEventByUser(Users user);
    //increase/decrease no of slots
    //setUserStatus,joinEvent,addCircleToEvent,removeEventFromCircle,retrieveUsersJoinEvent-->with nourhan
    public void setUserStatus();
    public void joinEvent();
    public void addCircleToEvent();
    public void removeEventFromCircle();
    public void retrieveUsersJoinEvent();
    
}
