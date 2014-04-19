/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package webservices;

import dao.*;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.json.simple.*;
import pojos.*;

/**
 *
 * @author Rehab
 */
@Path("/reg")
public class Register {
//    
//    @GET
//    @Consumes(MediaType.TEXT_PLAIN)
//    @Produces(MediaType.TEXT_PLAIN)
//    @Path("/{name}")    
//    public String Reg(@PathParam(value = "name") String name) {
//        Session session = Controller.sessionFactory.openSession();
//        session.beginTransaction();
//        //Users u=new Users("roka", "smsm", "wwww", "gg");
//        Users u = new Users("Rehab", "roka", "qqq", "female", null, name, name, name, name, name, null, null, null, null, null, null, null);
//        if (u != null) {
//            session.persist(u);
//            session.getTransaction().commit();
//            return "hello ya " + name;
//        } else {
//            return null;
//        }
//        
//    }
    
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public JSONObject Reg(@PathParam(value = "user") JSONObject user) {
        JSONObject us = new JSONObject();
        
        Users u = null;
        
        try {
            u = new Users(user.getString("name"), user.getString("username"), user.getString("password"),
                    user.getString("gender"), null, null, null, user.getString("userImage"),
                    user.getString("mail"), user.getString("facebookKey"), null, null, null, null,
                    null, null, null);
        } catch (JSONException ex) {
            Logger.getLogger(Register.class.getName()).log(Level.SEVERE, null, ex);
        }
        if (u != null) {
            UserImp userimp = new UserImp();
            userimp.addUser(u);
            Phone phone = null;
            try {
                phone = new Phone(user.getInt("id"), u);
            } catch (JSONException ex) {
                Logger.getLogger(Register.class.getName()).log(Level.SEVERE, null, ex);
            }
            PhoneImp phoneimp = new PhoneImp();
            phoneimp.addPhone(phone);
            try {
                JSONObject subj = new JSONObject();
                subj.put("register", "true");
                us.put("HasError", "false");
                us.put("HasWarning", "false");
                us.put("FaultsMsg", "false");
                us.put("ResponseValue", subj);
            } catch (JSONException ex) {
                Logger.getLogger(Register.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            return us;
        } else {
            try {
                JSONObject subj = new JSONObject();
                subj.put("register", "true");
                us.put("HasError", "false");
                us.put("HasWarning", "false");
                us.put("FaultsMsg", "false");
                us.put("ResponseValue", subj);
                return us;
            } catch (JSONException ex) {
                Logger.getLogger(Register.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return null;
        
    }
}
