package pojos;
// Generated Apr 12, 2014 12:23:51 PM by Hibernate Tools 3.2.1.GA



/**
 * EventToLocation generated by hbm2java
 */
public class EventToLocation  implements java.io.Serializable {


     private EventToLocationId id;
     private Event event;
     private Location location;
     private int toOrder;

    public EventToLocation() {
    }

    public EventToLocation(EventToLocationId id, Event event, Location location, int toOrder) {
       this.id = id;
       this.event = event;
       this.location = location;
       this.toOrder = toOrder;
    }
   
    public EventToLocationId getId() {
        return this.id;
    }
    
    public void setId(EventToLocationId id) {
        this.id = id;
    }
    public Event getEvent() {
        return this.event;
    }
    
    public void setEvent(Event event) {
        this.event = event;
    }
    public Location getLocation() {
        return this.location;
    }
    
    public void setLocation(Location location) {
        this.location = location;
    }
    public int getToOrder() {
        return this.toOrder;
    }
    
    public void setToOrder(int toOrder) {
        this.toOrder = toOrder;
    }




}


