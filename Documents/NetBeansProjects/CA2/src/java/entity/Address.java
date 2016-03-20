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
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;

/**
 *
 * @author Shmilo
 */
@NamedQueries({
    @NamedQuery(name="Address.FindById", query ="select a from Address a where a.id = :id"),
    @NamedQuery(name="Address.FindAll", query ="select a from Address a"),
    @NamedQuery(name="Address.FindByStreet", query="select a from Address a where a.street = :street")
})

@Entity
public class Address implements Serializable {

    @OneToMany(mappedBy = "address")
    private List<InfoEntity> infoEntities = new ArrayList();
    @ManyToOne
    private CityInfo cityinfo;
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Expose
    private Long id;
    @Expose
    private String street;
    @Expose
    private String additionalInfo;

    public void addInfoEntity(InfoEntity infoEntity) {
        infoEntities.add(infoEntity);
    }

    public List<InfoEntity> getInfoEntitys() {
        return infoEntities;
    }

    public void setInfoEntitys(List<InfoEntity> infoEntitys) {
        this.infoEntities = infoEntitys;
    }

    public CityInfo getCityinfo() {
        return cityinfo;
    }

    public void setCityinfo(CityInfo cityinfo) {
        this.cityinfo = cityinfo;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String Street) {
        this.street = Street;
    }

    public String getAdditionalInfo() {
        return additionalInfo;
    }

    public void setAdditionalInfo(String AdditionalInfo) {
        this.additionalInfo = AdditionalInfo;
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
        if (!(object instanceof Address)) {
            return false;
        }
        Address other = (Address) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entity.Address[ id=" + id + " ]";
    }

}
