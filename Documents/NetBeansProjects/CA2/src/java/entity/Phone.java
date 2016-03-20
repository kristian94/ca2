package entity;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import com.google.gson.annotations.Expose;
import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

/**
 *
 * @author Shmilo
 */
@NamedQueries({
    @NamedQuery(name="Phone.FindById", query="SELECT ph FROM Phone ph WHERE ph.id = :id"),
    @NamedQuery(name="Phone.FindAll", query="SELECT ph FROM Phone ph"),
    @NamedQuery(name="Phone.FindByNumber", query="SELECT ph from Phone ph where ph.number = :number")
})

@Entity
public class Phone implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Expose
    private Long id;
    @Expose
    private String number;
    @Expose
    private String description;
    
    
    @ManyToOne
    private InfoEntity infoentity;

    public InfoEntity getInfoentity() {
        return infoentity;
    }

    public void setInfoentity(InfoEntity infoentity) {
        this.infoentity = infoentity;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Phone)) {
            return false;
        }
        Phone other = (Phone) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entity.Phone[ id=" + id + " ]";
    }
    
}
