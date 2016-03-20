package entity.deploy;

import entity.Address;
import entity.CityInfo;
import entity.InfoEntity;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2016-03-20T14:54:07")
@StaticMetamodel(Address.class)
public class Address_ { 

    public static volatile ListAttribute<Address, InfoEntity> infoEntities;
    public static volatile SingularAttribute<Address, CityInfo> cityinfo;
    public static volatile SingularAttribute<Address, String> street;
    public static volatile SingularAttribute<Address, String> additionalInfo;
    public static volatile SingularAttribute<Address, Long> id;

}