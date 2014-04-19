/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package webservices;

import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/test")
public class testService {
   
    @POST
    //@GET
    @Path("/test1")
    @Produces(MediaType.TEXT_PLAIN)
    //@Consumes(MediaType.TEXT_PLAIN)
     public String viewCircles(@FormParam(value = "user")String user)
    {
        System.out.println(user+"33333333333333333333333333333");
        return "helloooooooooooooooooooo ya "+user;
    }
}
