/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package helper;

import api.GsonGetter;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import entity.Hobby;
import entity.Person;
import entity.Phone;

/**
 *
 * @author Kristian Nielsen
 */
public class JsonBuilder {

    private static Gson gson = GsonGetter.getGson();

    public static JsonObject getCompletePerson(Person p) {
        
        JsonObject jo = gson.fromJson(gson.toJson(p), JsonObject.class);
        
        jo.addProperty("street", p.getAddress().getStreet());
        jo.addProperty("city", p.getAddress().getCityinfo().getCity());

        JsonArray phoneArray = new JsonArray();
        for (Phone ph : p.getPhones()) {
            JsonObject inner = new JsonObject();
            inner.addProperty("number", ph.getNumber());
            inner.addProperty("description", ph.getDescription());
            phoneArray.add(inner);
        }
        jo.add("phones", phoneArray);

        JsonArray hobbyArray = new JsonArray();
        for (Hobby h : p.getHobbies()) {
            JsonObject inner = new JsonObject();
            inner.addProperty("name", h.getName());
            inner.addProperty("description", h.getDescription());
            hobbyArray.add(inner);
        }
        jo.add("hobbies", hobbyArray);

        return jo;
    }
    
    
}
