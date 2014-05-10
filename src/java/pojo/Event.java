package pojo;
// Generated May 10, 2014 1:41:20 PM by Hibernate Tools 3.6.0


import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Event generated by hbm2java
 */
public class Event  implements java.io.Serializable {


     private Integer id;
     private User user;
     private Location location;
     private String eventName;
     private int noOfSlots;
     private Date eventDate;
     private String eventStatue;
     private Set joinEvents = new HashSet(0);
     private Set notifications = new HashSet(0);
     private Set eventToLocations = new HashSet(0);
     private Set comments = new HashSet(0);

    public Event() {
    }

	
    public Event(User user, Location location, String eventName, int noOfSlots, Date eventDate, String eventStatue) {
        this.user = user;
        this.location = location;
        this.eventName = eventName;
        this.noOfSlots = noOfSlots;
        this.eventDate = eventDate;
        this.eventStatue = eventStatue;
    }
    public Event(User user, Location location, String eventName, int noOfSlots, Date eventDate, String eventStatue, Set joinEvents, Set notifications, Set eventToLocations, Set comments) {
       this.user = user;
       this.location = location;
       this.eventName = eventName;
       this.noOfSlots = noOfSlots;
       this.eventDate = eventDate;
       this.eventStatue = eventStatue;
       this.joinEvents = joinEvents;
       this.notifications = notifications;
       this.eventToLocations = eventToLocations;
       this.comments = comments;
    }
   
    public Integer getId() {
        return this.id;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }
    public User getUser() {
        return this.user;
    }
    
    public void setUser(User user) {
        this.user = user;
    }
    public Location getLocation() {
        return this.location;
    }
    
    public void setLocation(Location location) {
        this.location = location;
    }
    public String getEventName() {
        return this.eventName;
    }
    
    public void setEventName(String eventName) {
        this.eventName = eventName;
    }
    public int getNoOfSlots() {
        return this.noOfSlots;
    }
    
    public void setNoOfSlots(int noOfSlots) {
        this.noOfSlots = noOfSlots;
    }
    public Date getEventDate() {
        return this.eventDate;
    }
    
    public void setEventDate(Date eventDate) {
        this.eventDate = eventDate;
    }
    public String getEventStatue() {
        return this.eventStatue;
    }
    
    public void setEventStatue(String eventStatue) {
        this.eventStatue = eventStatue;
    }
    public Set getJoinEvents() {
        return this.joinEvents;
    }
    
    public void setJoinEvents(Set joinEvents) {
        this.joinEvents = joinEvents;
    }
    public Set getNotifications() {
        return this.notifications;
    }
    
    public void setNotifications(Set notifications) {
        this.notifications = notifications;
    }
    public Set getEventToLocations() {
        return this.eventToLocations;
    }
    
    public void setEventToLocations(Set eventToLocations) {
        this.eventToLocations = eventToLocations;
    }
    public Set getComments() {
        return this.comments;
    }
    
    public void setComments(Set comments) {
        this.comments = comments;
    }




}


