/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package webservices;


import dao.CircleImp;
import dao.UserImp;
import com.google.gson.Gson;
import java.util.List;
import javax.ws.rs.FormParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import org.codehaus.jettison.json.JSONArray;
import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;
import pojo.Circle;
import pojo.User;


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
        User us = new Gson().fromJson(user, User.class);
        CircleImp circleimp = new CircleImp();
        UserImp u=new UserImp();
        User us1 = u.retrieveUserByUserName(us);
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
                int cid=c.get(i).getId();
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
