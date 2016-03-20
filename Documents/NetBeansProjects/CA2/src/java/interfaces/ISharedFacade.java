/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;

import entity.Address;
import entity.CityInfo;
import entity.Phone;
import java.util.List;

/**
 *
 * @author Kristian Nielsen
 */ 
public interface ISharedFacade {
    List<CityInfo> getAllZips();
    Address getAddress(int id);
    List<Address> getAddresses();
    Address addAddress(Address address, CityInfo cityInfo);
    Phone addPhone(Phone phone);
    CityInfo addCityInfo(CityInfo cityInfo);
    CityInfo getCityInfo(int zipCode);
    Phone getPhoneById(int id);
    
    
      
} 
