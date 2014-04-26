/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package webservices;

import dao.*;
import java.util.Date;
import java.util.Set;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import org.codehaus.jettison.json.JSONArray;
import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;
import pojo.*;

/**
 *
 * @author Nourhan
 */
@Path("user")
public class UserManagement {
    public JSONObject blockUser(String input)
    {
        try {
            JSONObject joinEventJson = new JSONObject(input);
            if(!joinEventJson.isNull("user") && !joinEventJson.isNull("event"))
            {
                JSONObject user=joinEventJson.getJSONObject("user");
                int userId=user.getInt("id");
                JSONObject event=joinEventJson.getJSONObject("event");
                int eventId=event.getInt("id");
                
                JoinEventDAO jedao = new JoinEventDAO();
                UserStatueDAO usdao = new UserStatueDAO();
                
                JoinEvent joinEvent=jedao.retrieveJoinEvent(userId, eventId);
                UserStatue userStatue=usdao.retrieveUserStatueById(2);
                joinEvent.setUserStatue(userStatue);
                boolean b =jedao.updateJoinEvent(joinEvent);
                
                JSONObject blockUser = new JSONObject();
                JSONObject jsonOutput = new JSONObject();
                if(b)
                {
                    blockUser.put("blocked", true);
                    jsonOutput.put("HasError", false);
                    jsonOutput.put("HasWarning", false);
                    jsonOutput.put("FaultsMsg", "");
                    jsonOutput.put("ResponseValue",blockUser);
                }
                return jsonOutput;
            }
            return  null;
            } catch (JSONException ex) {
            ex.printStackTrace();
            return null;
        }
    }
}