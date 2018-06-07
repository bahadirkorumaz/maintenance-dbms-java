package javaapplication5;

import java.util.Date;
import javaapplication5.Machinetypes;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-06-05T11:06:38")
@StaticMetamodel(Machines.class)
public class Machines_ { 

    public static volatile SingularAttribute<Machines, Integer> machineID;
    public static volatile SingularAttribute<Machines, Date> productionDate;
    public static volatile SingularAttribute<Machines, Machinetypes> typeID;
    public static volatile SingularAttribute<Machines, Integer> floor;
    public static volatile SingularAttribute<Machines, Date> lastWarrantyDate;
    public static volatile SingularAttribute<Machines, String> room;

}