/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package webservices;

import dao.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ws.rs.FormParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import pojos.*;

/**
 *
 * @author Rehab
 */
@Path("/deleteCircle")
public class deleteCircle {
    @POST
    @Path("/delete")
    public String deleteCirclee(@FormParam(value = "circle")String circle)
    {
        try {
            Circle c = new Gson().fromJson(circle, Circle.class);
            CircleImp circleimp = new CircleImp();
            circleimp.deleteCircle(c);
            
            JSONObject status=new JSONObject();
            status.put("closed", "true");
            
            return status.toString();
        } catch (JSONException ex) {
            Logger.getLogger(deleteCircle.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
}
