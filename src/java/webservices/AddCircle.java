/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package webservices;

import dao.CircleImp;
import dao.UserImp;
import com.google.gson.Gson;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.scene.media.Media;
import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import org.codehaus.jettison.json.JSONArray;
import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;
import pojos.Circle;
import pojos.ExistIn;
import pojos.ExistInId;
import pojos.Users;

/**
 *
 * @author Rehab
 */
@Path("addCircle")
public class AddCircle {
    
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/update")
    public JSONObject addCirclee(@FormParam(value = "circle")JSONObject circle)
    {
        try {
            System.out.println(circle.toString());
            Users owner=new Users();
            owner.setId(circle.getInt("userId"));
            UserImp userimp=new UserImp();
            owner=userimp.retrieveUserById(owner);
            System.out.println(owner.getName());
            Circle circle1 = null;
            circle1 = new Circle(owner, circle.getString("circleName"));
            CircleImp circleImp=new CircleImp();
            circleImp.addCircle(circle1);
            circle1=circleImp.retrieveCircleByUserIdAndCircleName(circle1);
            
            JSONArray friends=circle.getJSONArray("friends");
            for(int i=0;i<friends.length();i++)
            {
                System.out.println(friends.get(i));
                Users u =new Users();
                JSONObject o=friends.getJSONObject(i);
                u.setId(o.getInt("userId"));
                u=userimp.retrieveUserById(u);
                ExistIn existIn=new ExistIn(u, circle1, "0");
                ExistInId id=new ExistInId(u.getId(), circle1.getIdCircle());
                existIn.setId(id);
                userimp.addUserToCircle(existIn);
            }
            
            JSONObject status=new JSONObject();
            status.put("added", "true");
            return status;
        } catch (JSONException ex) {
            Logger.getLogger(AddCircle.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return null;
    }
    
}