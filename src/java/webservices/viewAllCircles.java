/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package webservices;


import dao.CircleImp;
import dao.UserImp;
import antlr.debug.MessageAdapter;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.sun.jersey.multipart.FormDataParam;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import org.codehaus.jettison.json.JSONArray;
import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;
import pojos.Circle;
import pojos.Users;


/**
 *
 * @author Rehab
 */
@Path("/viewcircle")
public class viewAllCircles {
    @POST
    //@Path("/test")
    //@Consumes(MediaType.APPLICATION_JSON)
    //@Produces(MediaType.APPLICATION_JSON)
    @Path("view")
    public String viewCircles(@FormParam(value = "user")String user)//JSONObject user)
    {
        System.out.println("hellloooooooooooooooooooooooooo");
        Users us = new Gson().fromJson(user, Users.class);
        CircleImp circleimp = new CircleImp();
        UserImp u=new UserImp();
        Users us1 = u.retrieveUserByUserName(us);
        List<Circle> c=circleimp.retrieveUserCircles(us1);
        
//        Gson g = new Gson();
//        System.out.println("Heey : " + c.get(0).getCircleName());
//        String x =g.toJson(c);
//        System.out.println(x);
        
        JSONObject circles=new JSONObject();
        for(int i=0;i<c.size();i++)
        {
            try {
                String name =c.get(i).getCircleName();
                int cid=c.get(i).getIdCircle();
                JSONObject circledata=new JSONObject();
                circledata.put("circleName", name);
                circledata.put("circleId", cid);
                JSONArray ja=new JSONArray();
                ja.put(circledata);
                circles.put("circles", ja);
                System.out.println("looollllllllllllllll");
            } catch (JSONException ex) {
                //Logger.getLogger(viewAllCircles.class.getName()).log(Level.SEVERE, null, ex);
                ex.printStackTrace();
            }
        }
        System.out.println("looollllllly");
        //return circles;
        //return "eshta ya sasa ";
        return circles.toString();
    }
    
}
