/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Test;

import com.google.gson.Gson;



/**
 *
 * @author Kristian Nielsen
 */
public class Test {
    
    
    
    public static void main(String[] args) {
        Person p1 = new Person();
        p1.setAge(20);
        p1.setIsMale(true);
        p1.setName("John");
        p1.setOccupation("Fisherman");
        Gson gson = new Gson();
        String json = gson.toJson(p1);
        System.out.println(json);
    }
}
