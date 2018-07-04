package javaapplication5;

import javaapplication5.Machinetypes;
import javaapplication5.Maintenance;
import javaapplication5.Users;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-06-07T23:48:56")
@StaticMetamodel(Firm.class)
public class Firm_ { 

    public static volatile CollectionAttribute<Firm, Machinetypes> machinetypesCollection;
    public static volatile SingularAttribute<Firm, Integer> firmID;
    public static volatile SingularAttribute<Firm, String> firmMail;
    public static volatile SingularAttribute<Firm, String> firmName;
    public static volatile CollectionAttribute<Firm, Users> usersCollection;
    public static volatile CollectionAttribute<Firm, Maintenance> maintenanceCollection;
    public static volatile SingularAttribute<Firm, String> firmPhone;

}