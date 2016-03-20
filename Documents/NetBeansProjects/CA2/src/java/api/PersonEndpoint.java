/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package api;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import entity.Hobby;
import entity.Person;
import entity.Phone;
import facade.PersonFacade;
import facade.SharedFacade;
import helper.JsonBuilder;
import java.util.List;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;

/**
 * REST Web Service
 *
 * @author Kristian Nielsen
 */
@Path("person")
public class PersonEndpoint {

    Gson gson =  GsonGetter.getGson();
    PersonFacade pf = new PersonFacade();
    
    @Context
    private UriInfo context;

    public PersonEndpoint() {
    }
    
    
    
    @GET
    @Produces("application/json")
    public String getPersons(){
        List<Person> persons = pf.getPersons();
        JsonArray personArray = new JsonArray();
        for(Person p: persons){
            
            JsonObject job = JsonBuilder.getCompletePerson(p);
            personArray.add(job);
        }
        
        
        
        return gson.toJson(personArray);
    }
    
    @GET
    @Path("/id/{id}")
    @Produces("application/json")
    public String getPersonById(@PathParam("id") int id) {
        
        JsonObject jo = JsonBuilder.getCompletePerson(pf.getPersonById(id));
        
        return gson.toJson(jo);
    }
    

//    @GET
//    @Path("hobby/{hobby}/count")
//    @Produces("text/html")
//    public String getHobbyCount(@PathParam("hobby") String hobby){
//        return "number of people with given hobby (" + hobby + ")";
//    }
    
    @POST
    @Consumes("application/json")
    @Produces("application/json")
    public String addPerson(String content){
        System.out.println("posting");
        JsonObject jo = gson.fromJson(content, JsonObject.class);
        Person p = pf.addCompletePerson(jo);
        return gson.toJson(p);
    }
    
    

//    @DELETE
//    @Consumes("application/json")
//    @Produces("text/html")
//    public String deletePerson(String content){
//        pf.deletePerson(null)
//    }
    
//    @PUT
//    @Path("/address/{personid}/{addressid}")
//    @Produces("text/html")
//    public String setAddress(){
//        return "hey";
//    }
    
//    @PUT
//    @Consumes("application/json")
//    @Produces("application/json")
//    public String editPerson(String content) {
//        //Person p = gson.fromJson(content, Person.class);
//        return "hey";
//    }
}
