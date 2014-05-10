package pojo;
// Generated May 10, 2014 1:41:20 PM by Hibernate Tools 3.6.0


import java.util.Date;

/**
 * Comment generated by hbm2java
 */
public class Comment  implements java.io.Serializable {


     private Integer id;
     private User user;
     private Event event;
     private Date commentDate;
     private String commentText;

    public Comment() {
    }

    public Comment(User user, Event event, Date commentDate, String commentText) {
       this.user = user;
       this.event = event;
       this.commentDate = commentDate;
       this.commentText = commentText;
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
    public Event getEvent() {
        return this.event;
    }
    
    public void setEvent(Event event) {
        this.event = event;
    }
    public Date getCommentDate() {
        return this.commentDate;
    }
    
    public void setCommentDate(Date commentDate) {
        this.commentDate = commentDate;
    }
    public String getCommentText() {
        return this.commentText;
    }
    
    public void setCommentText(String commentText) {
        this.commentText = commentText;
    }




}


