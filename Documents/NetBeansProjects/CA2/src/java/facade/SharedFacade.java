/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facade;

import entity.Address;
import entity.CityInfo;
import entity.Phone;
import interfaces.ISharedFacade;
import java.util.List;
import javax.persistence.EntityManager;

/**
 *
 * @author Kristian Nielsen
 */
public class SharedFacade implements ISharedFacade {

    EntityManager em = EntManGetter.getEntMan();
    
    @Override
    public List<CityInfo> getAllZips() {
        return em.createNamedQuery("CityInfo.findAll").getResultList();
    }

    @Override
    public Address getAddress(int id) {
        return (Address) em.createNamedQuery("Address.FindById").setParameter("id", id).getSingleResult();
    }

    @Override
    public List<Address> getAddresses() {
        return em.createNamedQuery("Address.FindAll").getResultList();
    }

    @Override
    public Address addAddress(Address address, CityInfo cityInfo) {
        em.getTransaction().begin();
        address.setCityinfo(cityInfo);
        em.persist(address);
        em.getTransaction().commit();
        return em.find(Address.class, address);
    }
    
    

    @Override
    public Phone addPhone(Phone phone) {
        em.getTransaction().begin();
        em.persist(phone);
        em.getTransaction().commit();
        return em.find(Phone.class, phone);
    }

    @Override
    public CityInfo getCityInfo(int zipCode) {
        return (CityInfo) em.createNamedQuery("CityInfo.FindByZip").setParameter("zipCode", zipCode).getSingleResult();
    }

    @Override
    public CityInfo addCityInfo(CityInfo cityInfo) {
        em.getTransaction().begin();
        em.persist(cityInfo);
        em.getTransaction().commit();
        return em.find(CityInfo.class, cityInfo);
    }

    @Override
    public Phone getPhoneById(int id) {
        return (Phone) em.createNamedQuery("Phone.FindById").setParameter("id", id).getSingleResult();
    }
    
    
    
}
