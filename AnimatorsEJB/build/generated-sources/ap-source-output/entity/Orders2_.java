package entity;

import entity.Users2;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2016-01-24T13:33:09")
@StaticMetamodel(Orders2.class)
public class Orders2_ { 

    public static volatile SingularAttribute<Orders2, Integer> id;
    public static volatile SingularAttribute<Orders2, String> adress;
    public static volatile SingularAttribute<Orders2, String> minut;
    public static volatile SingularAttribute<Orders2, Date> time;
    public static volatile SingularAttribute<Orders2, String> status;
    public static volatile SingularAttribute<Orders2, Users2> idpersonage;
    public static volatile SingularAttribute<Orders2, Users2> idcustomer;
    public static volatile SingularAttribute<Orders2, String> summa;
    public static volatile SingularAttribute<Orders2, Integer> del;
    public static volatile SingularAttribute<Orders2, Date> date;

}