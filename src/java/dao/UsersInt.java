/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package dao;

import pojos.ExistIn;
import pojos.Users;

/**
 *
 * @author Rehab
 */
public interface UsersInt {
    public void addUser(Users user);
    public Users retrieveUserByUserName(Users user);
    public Users retrieveUserById(Users user);
    
    public void addUserToCircle(ExistIn e);
    
}
