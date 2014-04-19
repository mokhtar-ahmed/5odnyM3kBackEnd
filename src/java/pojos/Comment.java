package pojos;
// Generated Apr 19, 2014 3:45:32 PM by Hibernate Tools 3.2.1.GA


import java.util.Date;

/**
 * Comment generated by hbm2java
 */
public class Comment  implements java.io.Serializable {


     private CommentId id;
     private Users users;
     private Event event;
     private Date commentDate;
     private String commentText;

    public Comment() {
    }

    public Comment(CommentId id, Users users, Event event, Date commentDate, String commentText) {
       this.id = id;
       this.users = users;
       this.event = event;
       this.commentDate = commentDate;
       this.commentText = commentText;
    }
   
    public CommentId getId() {
        return this.id;
    }
    
    public void setId(CommentId id) {
        this.id = id;
    }
    public Users getUsers() {
        return this.users;
    }
    
    public void setUsers(Users users) {
        this.users = users;
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


