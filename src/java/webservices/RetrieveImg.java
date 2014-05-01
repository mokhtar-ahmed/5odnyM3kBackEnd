/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package webservices;


import java.awt.image.BufferedImage;
import java.awt.image.DataBufferByte;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.ws.rs.Path;
import org.apache.commons.codec.binary.Base64;
import pojo.User;

/**
 *
 * @author Rehab
 */
@Path("retrieveImg")
public class RetrieveImg {
    @Path("hat")
    public String retreiveImgg(User user) {
        try {
            String path = "D://" + user.getId() + ".png";
            URL url = new File(path).toURI().toURL();
            BufferedImage img ;
            img = ImageIO.read(url);
            
            byte[] imageBytes = ((DataBufferByte) img.getData().getDataBuffer()).getData();
            System.out.println(imageBytes);
            
            String s = encodeImage(imageBytes);

            return s;
        } catch (IOException ex) {
            Logger.getLogger(SaveImg.class.getName()).log(Level.SEVERE, null, ex);
        }
        return "not eshta";
    }

    public static String encodeImage(byte[] imageByteArray) {
        return Base64.encodeBase64String(imageByteArray);
    }

}
