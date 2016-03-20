/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package api;

import com.google.gson.Gson;
import entity.Company;
import facade.CompanyFacade;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import static javax.ws.rs.HttpMethod.DELETE;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;

/**
 * REST Web Service
 *
 * @author Kristian Nielsen
 */
@Path("company")
public class CompanyEndpoint {

    Gson gson = GsonGetter.getGson();
    CompanyFacade cf = new CompanyFacade();
    
    @Context
    private UriInfo context;

    /**
     * Creates a new instance of CompanyResource
     */
    public CompanyEndpoint() {
    }

    @GET
    @Produces("application/json")
    public String getCompanies(){
        return gson.toJson(cf.getCompanies());
    }
    
    @GET
    @Path("/{name}")
    //@Produces("application/json")
    @Produces("text/html")
    public String getCompany(@PathParam("name") String name) {

        return gson.toJson(cf.getCompanyByName(name));
    }
    
    @GET
    @Path("/employees/over/{count}")
    public String getCompaniesOverXEmp(@PathParam("count") int count){
        return gson.toJson(cf.getCompaniesOverXEmp(count));
    }
    
//    @POST
//    @Consumes("application/json")
//    @Produces("application/json")
//    public String addCopmany(String content){
//        Company c = gson.fromJson(content, Company.class);
//        return gson.toJson(cf.addCompany(c));
//    }
//
//    @DELETE
//    @Consumes("application/json")
//    @Produces("text/html")
//    public String deleteCompany(String content){
//        Company c = gson.fromJson(content, Company.class);
//        if (cf.deleteCompany(c)) return "Company deleted";
//        else return "Could not find company";
//    }
//    
//    @PUT
//    @Consumes("application/json")
//    @Produces("application/json")
//    public String editCompany(String content) {
//        Company c = gson.fromJson(content, Company.class);
//        return gson.toJson(cf.editCompany(c));
//    }
}
