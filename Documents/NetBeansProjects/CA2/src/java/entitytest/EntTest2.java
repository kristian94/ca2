/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entitytest;

import entity.Address;
import entity.Company;
import entity.Phone;
import facade.CompanyFacade;
import facade.SharedFacade;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author Kristian Nielsen
 */
public class EntTest2 {
    public static void main(String[] args) {
        
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("CA2PU");
        EntityManager em = emf.createEntityManager();
        System.out.println("we");
        
        CompanyFacade cf = new CompanyFacade();
        SharedFacade sf = new SharedFacade();
        em.getTransaction().begin();
        
        Company c = cf.getCompanyByName("TDC");
        Phone ph = sf.getPhoneById(19);
        c.addPhone(ph);
        ph.setInfoentity(c);
        System.out.println(ph.getNumber());
        em.merge(ph);
        em.merge(c);
        em.getTransaction().commit();
        System.out.println(ph.getInfoentity().getId());
        System.out.println(c.getDescription());
    }
}
