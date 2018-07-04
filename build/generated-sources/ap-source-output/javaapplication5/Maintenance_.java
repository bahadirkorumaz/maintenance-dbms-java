package javaapplication5;

import javaapplication5.Firm;
import javaapplication5.Machinetypes;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-06-07T23:48:56")
@StaticMetamodel(Maintenance.class)
public class Maintenance_ { 

    public static volatile SingularAttribute<Maintenance, Integer> maintenanceID;
    public static volatile SingularAttribute<Maintenance, String> plannedDate;
    public static volatile SingularAttribute<Maintenance, Machinetypes> machinetypeID;
    public static volatile SingularAttribute<Maintenance, Firm> maintenanceFirmID;

}