package entity;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import com.google.gson.annotations.Expose;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

/**
 *
 * @author Shmilo
 */
@NamedQueries({
    @NamedQuery(name="Person.FindAll", query="SELECT p FROM Person p"),
    @NamedQuery(name="Person.FindById", query="SELECT p FROM Person p WHERE p.id = :id")
})

@Entity
public class Person extends InfoEntity implements Serializable {

    private static final long serialVersionUID = 1L;
    
    @Expose
    private String firstName;
    @Expose
    private String lastName;
    
    @ManyToMany
    private List<Hobby> hobbies = new ArrayList();
    
    public Person(){
        
    }

    public void addHobby(Hobby hobby) {
        hobbies.add(hobby);
    }

    public List<Hobby> getHobbies() {
        return hobbies;
    }

    public void setHobbies(List<Hobby> hobbies) {
        this.hobbies = hobbies;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }


}
