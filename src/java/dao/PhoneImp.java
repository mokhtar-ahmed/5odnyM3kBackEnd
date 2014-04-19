/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import org.hibernate.Session;
import pojos.Phone;

/**
 *
 * @author Rehab
 */
public class PhoneImp implements PhoneInt {

    @Override
    public void addPhone(Phone phone) {
        Session session =Controller.getSessionFactory().openSession();
        session.beginTransaction();
        session.persist(phone);
        session.getTransaction().commit();
        session.close();
    }

}
