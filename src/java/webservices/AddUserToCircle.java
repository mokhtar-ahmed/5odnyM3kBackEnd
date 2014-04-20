/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package webservices;

import dao.CircleImp;
import dao.UserImp;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
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
@Path("addUserToCircle")
public class AddUserToCircle {

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/addUser")
    public JSONObject addUserToCirclee(@FormParam(value = "circle") JSONObject exist) {
        try {
            Users u = new Users();
            u.setId(exist.getInt("userId"));
            UserImp userImp=new UserImp();
            u = userImp.retrieveUserById(u);
            Circle c=new Circle();
            c.setIdCircle(exist.getInt("circleId"));
            CircleImp circleImp=new CircleImp();
            c=circleImp.retrieveCircleById(c);
            ExistIn existIn = new ExistIn(u, c, "0");
            ExistInId id = new ExistInId(u.getId(), c.getIdCircle());
            existIn.setId(id);
            userImp.addUserToCircle(existIn);
            
            JSONObject status=new JSONObject();
            status.put("added", "true");
            return status;
            
        } catch (JSONException ex) {
            Logger.getLogger(AddUserToCircle.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
}
