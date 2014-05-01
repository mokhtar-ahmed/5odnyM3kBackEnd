/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package webservices;

/**
 *
 * @author Rehab
 */
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import dao.UserImp;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
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
@Path("saveImg")
public class SaveImg {

    public String saveImgg(byte[] image, User user) {
        try {
            String path = "D://" + user.getId() + ".png";
            BufferedImage img = ImageIO.read(new ByteArrayInputStream(image));
            ImageIO.write(img, "png", new File(path));
            user.setUserImage(path);
            UserImp ui=new UserImp();
            ui.edit(user);

            return "eshta";
        } catch (IOException ex) {
            Logger.getLogger(SaveImg.class.getName()).log(Level.SEVERE, null, ex);
        }
        return "fffffffff";
    }

    public static byte[] decodeImage(String imageDataString) {
        return Base64.decodeBase64(imageDataString);
    }

    @Path("save")
    public String test(String image, User user) {
        System.out.println(image);
        byte[] img = decodeImage(image);
        String s = saveImgg(img, user);
        return s;
    }
}

