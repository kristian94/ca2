/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facade;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author Kristian Nielsen
 */
public class EntManGetter {
    
    private static EntityManager em;
    
    public static EntityManager getEntMan(){
        if(em == null) em = getNewEntityManager();
        if (!em.isOpen()) em.clear();
        return em;
    }
    
    private static EntityManager getNewEntityManager(){
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("pu_OPENSHIFT");
        return emf.createEntityManager();
    } 
    
}
