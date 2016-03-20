/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package api;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

/**
 *
 * @author Kristian Nielsen
 */
public class GsonGetter {
    
    private static Gson gson = new GsonBuilder().excludeFieldsWithoutExposeAnnotation().create();
    
    public static Gson getGson(){
        return gson;
    }
    
}
