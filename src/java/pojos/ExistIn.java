package pojos;
// Generated Apr 19, 2014 3:45:32 PM by Hibernate Tools 3.2.1.GA



/**
 * ExistIn generated by hbm2java
 */
public class ExistIn  implements java.io.Serializable {


     private ExistInId id;
     private Users users;
     private Circle circle;
     private String bolckStatue;

    public ExistIn() {
    }

    public ExistIn(ExistInId id, Users users, Circle circle, String bolckStatue) {
       this.id = id;
       this.users = users;
       this.circle = circle;
       this.bolckStatue = bolckStatue;
    }
   
    public ExistInId getId() {
        return this.id;
    }
    
    public void setId(ExistInId id) {
        this.id = id;
    }
    public Users getUsers() {
        return this.users;
    }
    
    public void setUsers(Users users) {
        this.users = users;
    }
    public Circle getCircle() {
        return this.circle;
    }
    
    public void setCircle(Circle circle) {
        this.circle = circle;
    }
    public String getBolckStatue() {
        return this.bolckStatue;
    }
    
    public void setBolckStatue(String bolckStatue) {
        this.bolckStatue = bolckStatue;
    }




}


