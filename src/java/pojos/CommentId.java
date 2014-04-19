package pojos;
// Generated Apr 19, 2014 3:45:32 PM by Hibernate Tools 3.2.1.GA



/**
 * CommentId generated by hbm2java
 */
public class CommentId  implements java.io.Serializable {


     private int eventId;
     private int usersId;

    public CommentId() {
    }

    public CommentId(int eventId, int usersId) {
       this.eventId = eventId;
       this.usersId = usersId;
    }
   
    public int getEventId() {
        return this.eventId;
    }
    
    public void setEventId(int eventId) {
        this.eventId = eventId;
    }
    public int getUsersId() {
        return this.usersId;
    }
    
    public void setUsersId(int usersId) {
        this.usersId = usersId;
    }


   public boolean equals(Object other) {
         if ( (this == other ) ) return true;
		 if ( (other == null ) ) return false;
		 if ( !(other instanceof CommentId) ) return false;
		 CommentId castOther = ( CommentId ) other; 
         
		 return (this.getEventId()==castOther.getEventId())
 && (this.getUsersId()==castOther.getUsersId());
   }
   
   public int hashCode() {
         int result = 17;
         
         result = 37 * result + this.getEventId();
         result = 37 * result + this.getUsersId();
         return result;
   }   


}


