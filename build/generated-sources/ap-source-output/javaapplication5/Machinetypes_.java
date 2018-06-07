package javaapplication5;

import java.util.Date;
import javaapplication5.Firm;
import javaapplication5.Machines;
import javaapplication5.Maintenance;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-06-05T11:06:38")
@StaticMetamodel(Machinetypes.class)
public class Machinetypes_ { 

    public static volatile SingularAttribute<Machinetypes, Date> lastMaintenanceDate;
    public static volatile SingularAttribute<Machinetypes, String> modelName;
    public static volatile SingularAttribute<Machinetypes, Integer> typeID;
    public static volatile CollectionAttribute<Machinetypes, Maintenance> maintenanceCollection;
    public static volatile CollectionAttribute<Machinetypes, Machines> machinesCollection;
    public static volatile SingularAttribute<Machinetypes, Integer> maintenancePeriod;
    public static volatile SingularAttribute<Machinetypes, Firm> maintenanceFirmID;

}