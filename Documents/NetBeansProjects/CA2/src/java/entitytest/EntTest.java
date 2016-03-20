/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entitytest;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import entity.Address;
import entity.CityInfo;
import entity.Company;
import entity.Hobby;
import entity.Person;
import entity.Phone;
import facade.PersonFacade;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author Kristian Nielsen
 */
public class EntTest {
    public static void main(String[] args) {
        
        Gson gson = new GsonBuilder().excludeFieldsWithoutExposeAnnotation().create();
        //Gson gson = new Gson();
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("CA2PU");
        EntityManager em = emf.createEntityManager();
        
        Person p = new Person();
        Person p2 = new Person();
        Address a = new Address();
        CityInfo ci = new CityInfo();
        Company c = new Company();
        Hobby h = new Hobby();
        Phone ph = new Phone();
        Phone ph2 = new Phone();
        
        System.out.println("llol");
        
        p.setEmail("email@ja.ja");
        p.setFirstName("Jens");
        p.setLastName("Hansen");
        
        p2.setEmail("nicemail@hey.dk");
        p2.setFirstName("Jesper");
        p2.setLastName("Poulsen");
        
        a.setAdditionalInfo("Blabla");
       
        a.setStreet("Vej 9");
        
        
        
        ci.setCity("København NV");
        ci.setZipCode(2400);
        
        
        c.setCvr("123234");
        c.setDescription("A nice company");
        c.setEmail("hmm@mail.com");
        c.setMarketValue(100000L);
        c.setName("Dell");
        c.setNumEmployees(10000);
        
        
        h.setName("Football");
        h.setDescription("aka Handegg");
        
        
        
        ph.setNumber("20202020");
        ph.setDescription("A certain persons number");
        
        
        ph2.setNumber("30303030");
        ph2.setDescription("A certain companys number");
        
        
        p.addPhone(ph);
        p.addHobby(h);
        
        p2.addPhone(ph);
        p2.addHobby(h);
        
        h.addPerson(p);
        h.addPerson(p2);
        
        c.addPhone(ph2);
        ph2.setInfoentity(c);
        ph.setInfoentity(p);
        
        c.setAddress(a);
        ci.addAddress(a);
        a.setCityinfo(ci);
        a.addInfoEntity(c);
        a.addInfoEntity(p);
        p.setAddress(a);
        p2.setAddress(a);
        
        em.getTransaction().begin();
        em.persist(p);
        em.persist(p2);
        em.persist(a);
        em.persist(ci);
        em.persist(c);
        em.persist(h);
        em.persist(ph);
        em.persist(ph2);
        em.getTransaction().commit();
        
        PersonFacade pf = new PersonFacade();
        System.out.println(pf.getPersons().get(0).getPhones().get(0).getNumber());
        
        System.out.println(gson.toJson(c));
        
    }
}
