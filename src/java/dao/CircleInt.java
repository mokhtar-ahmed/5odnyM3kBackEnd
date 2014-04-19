/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package dao;

import java.util.List;
import pojos.*;

/**
 *
 * @author Rehab
 */
public interface CircleInt {
    public void addCircle(Circle circle);
    public List<Circle> retrieveUserCircles(Users user);//Users user);
    public void editCircle(Circle circle);
    public void deleteCircle(Circle circle);
    public void blockUserFromCircle(ExistIn ex);//exist in table
    public boolean isBlocked(ExistIn ex);//
    public void addUserToCircle(Users user,Circle circle);//
    public void removeUserFromCircle(Users user,Circle circle);//
    public Circle retrieveCircleByName(Users user,Circle circle);//
    public List<Users> retrieveCircleUsers(Circle circle);//
    public Circle retrieveCircleById(Circle circle);
    public ExistIn retrieveExistInUser(ExistIn ex);
}
