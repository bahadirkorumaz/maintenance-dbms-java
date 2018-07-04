package javaapplication5;

import javaapplication5.Users;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-06-07T23:48:56")
@StaticMetamodel(Usertypes.class)
public class Usertypes_ { 

    public static volatile SingularAttribute<Usertypes, String> typeName;
    public static volatile SingularAttribute<Usertypes, Integer> typeID;
    public static volatile CollectionAttribute<Usertypes, Users> usersCollection;

}