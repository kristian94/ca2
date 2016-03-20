/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;

import com.google.gson.JsonObject;
import entity.Hobby;
import entity.Person;
import java.util.List;

/**
 *
 * @author Kristian Nielsen
 */
public interface IPersonFacade {
    Person getPerson(String dataType, String data);
    Person getPersonById(int id);
    Person addCompletePerson(JsonObject jo);
    List<Person> getPersons();
    List<Person> getPersons(String dataType, String data);
    List<Person> getPersonsFromHobby(String hobby);
    Hobby addHobby(Hobby hobby);
    Hobby editHobby(Hobby hobby);
    int getHobbyCount(String hobby);
    Person addPerson(Person person);
    Person editPerson(Person person);
    boolean deletePerson(Person person);
    
    
}
