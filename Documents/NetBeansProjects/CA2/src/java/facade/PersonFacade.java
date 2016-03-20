/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facade;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import entity.Address;
import entity.CityInfo;
import entity.Hobby;
import entity.Person;
import entity.Phone;
import interfaces.IPersonFacade;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;

/**
 *
 * @author Kristian Nielsen
 */
public class PersonFacade implements IPersonFacade {

    EntityManager em = EntManGetter.getEntMan();

    @Override
    public Person getPerson(String dataType, String data) {
        String query = "SELECT p FROM Person p WHERE p." + dataType + " = " + data;
        return (Person) em.createQuery(query).getSingleResult();
    }

    @Override
    public List<Person> getPersons() {
        return em.createNamedQuery("Person.FindAll").getResultList();
    }

    @Override
    public List<Person> getPersons(String dataType, String data) {
        String query = "SELECT p FROM Person p WHERE p." + dataType + " = " + data;
        return em.createQuery(query).getResultList();
    }

    @Override
    public List<Person> getPersonsFromHobby(String hobby) {
        Hobby h = (Hobby) em.createNamedQuery("Hobby.findByName").setParameter("hobby", hobby).getSingleResult();
        return h.getPersons();
    }

    @Override
    public int getHobbyCount(String hobby) {
        Hobby h = (Hobby) em.createNamedQuery("Hobby.findByName").setParameter("hobby", hobby).getSingleResult();
        int count = 0;
        for (Person p : h.getPersons()) {
            count++;
        }
        return count;
    }

    @Override
    public Person addPerson(Person person) {
        em.getTransaction().begin();
        em.persist(person);
        em.getTransaction().commit();
        return em.find(Person.class, person);
    }

    @Override
    public Person editPerson(Person person) {
        em.getTransaction().begin();
        Person p2 = em.merge(person);
        em.getTransaction().commit();
        return p2;
    }

    @Override
    public boolean deletePerson(Person person) {
        em.getTransaction().begin();
        em.remove(person);
        em.getTransaction().commit();
        Person p = em.find(Person.class, person);
        if (p == null) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public Hobby addHobby(Hobby hobby) {
        em.getTransaction().begin();
        em.persist(hobby);
        em.getTransaction().commit();
        return em.find(Hobby.class, hobby);
    }

    @Override
    public Hobby editHobby(Hobby hobby) {
        em.getTransaction().begin();
        em.merge(hobby);
        em.getTransaction().commit();
        return em.find(Hobby.class, hobby);
    }

    @Override
    public Person getPersonById(int id) {
        return (Person) em.createNamedQuery("Person.FindById").setParameter("id", id).getSingleResult();
    }

    @Override
    public Person addCompletePerson(JsonObject jo) {
        Person p = new Person();
        try {

            if (!em.getTransaction().isActive()) {
                em.getTransaction().begin();
            }

            
            Address a;
            CityInfo ci;
            try {
                a = (Address) em.createNamedQuery("Address.FindByStreet").setParameter("street", jo.get("street").getAsString()).getSingleResult();
            } catch (NoResultException nre) {
                a = null;
            }
            try {
                ci = (CityInfo) em.createNamedQuery("CityInfo.FindByZip").setParameter("zipCode", jo.get("zipCode").getAsInt()).getSingleResult();
            } catch (NoResultException nre2) {
                ci = null;
            }

            JsonArray jsonHobbies = jo.get("hobbies").getAsJsonArray();
            JsonArray jsonPhones = jo.get("phones").getAsJsonArray();

            for (int i = 0; i < jsonHobbies.size(); i++) {
                JsonObject current = jsonHobbies.get(i).getAsJsonObject();
                Hobby h;
                try {
                    h = (Hobby) em.createNamedQuery("Hobby.FindByName").setParameter("name", current.get("name").getAsString()).getSingleResult();
                } catch (NoResultException nre3) {
                    h = null;
                }
                if (h == null) {
                    h = new Hobby();
                    h.setName(current.get("name").getAsString());
                    h.setDescription(current.get("description").getAsString());

                }
                em.persist(h);
                h.addPerson(p);
                p.addHobby(h);
            }

            for (int j = 0; j < jsonPhones.size(); j++) {
                JsonObject current = jsonPhones.get(j).getAsJsonObject();
                Phone ph;
                try {
                    ph = (Phone) em.createNamedQuery("Phone.FindByNumber").setParameter("number", current.get("number").getAsString()).getSingleResult();
                } catch (NoResultException nre4) {
                    ph = null;
                }
                if (ph == null) {
                    ph = new Phone();
                    ph.setNumber(current.get("number").getAsString());
                    ph.setDescription("Private");
                }
                ph.setInfoentity(p);
                p.addPhone(ph);
                em.persist(ph);
            }

            if (ci == null) {
                ci = new CityInfo();
                ci.setCity(jo.get("city").getAsString());
                ci.setZipCode(jo.get("zipCode").getAsInt());
                em.persist(ci);
            }

            if (a == null) {
                a = new Address();
                a.setStreet(jo.get("street").getAsString());
                a.setAdditionalInfo("Home");
                a.setCityinfo(ci);
                ci.addAddress(a);
                em.persist(a);
            } else {
                a.addInfoEntity(p);
                em.merge(a);
            }

            p.setFirstName(jo.get("firstName").getAsString());
            p.setLastName(jo.get("lastName").getAsString());
            p.setEmail(jo.get("email").getAsString());

            em.persist(p);
            em.getTransaction().commit();
        }catch(Exception e){
            return new Person();
        }
        return p;
    }

}
