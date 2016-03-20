/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package api;

import com.google.gson.Gson;
import entity.Address;
import entity.CityInfo;
import entity.Phone;
import facade.SharedFacade;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;


/**
 * REST Web Service
 *
 * @author Kristian Nielsen
 */
@Path("shared")
public class SharedEndpoint {

    Gson gson = GsonGetter.getGson();
    SharedFacade sf = new SharedFacade();
    
    @Context
    private UriInfo context;

    /**
     * Creates a new instance of SharedEndpoint
     */
    public SharedEndpoint() {
    }


    @GET
    @Path("/zip")
    @Produces("application/json")
    public String getZips() {
        return gson.toJson(sf.getAllZips());
    }
    
    @GET
    @Path("/address")
    @Produces("application/json")
    public String getAddresses(){
        return gson.toJson(sf.getAddresses());
    }
    
    @GET
    @Path("/cityInfo/{zipCode}")
    public String getCityInfo(@PathParam("zipCode") int zipCode){
        return gson.toJson(sf.getCityInfo(zipCode));
    }
    
//    @GET
//    @Path("/address/{id}")
//    @Produces("application/json")
//    public String getAddress(@PathParam("id") int id){
//        return gson.toJson(sf.getAddress(id));
//    }
    
    
    
//    @POST
//    @Consumes("application/json")
//    @Produces("application/json")
//    @Path("/address/{zipCode}")
//    public String addAddress(@PathParam ("zipCode") int zipCode, String content) {
//        Address a = gson.fromJson(content, Address.class);
//        CityInfo ci = sf.getCityInfo(zipCode);
//        return gson.toJson(sf.addAddress(a, ci));
//    }
//    
//    @POST
//    @Consumes("application/json")
//    @Produces("application/json")
//    @Path("/cityInfo")
//    public String addCityInfo(String content) {
//        CityInfo ci = gson.fromJson(content, CityInfo.class);
//        return gson.toJson(sf.addCityInfo(ci));
//    } 
//    
//    @POST
//    @Consumes("application/json")
//    @Produces("application/json")
//    @Path("/phone")
//    public String addPhone(String content) {
//        Phone p = gson.fromJson(content, Phone.class);
//        return gson.toJson(sf.addPhone(p));
//    }


    
}
