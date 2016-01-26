package entity;

import entity.Orders2;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2016-01-24T13:33:09")
@StaticMetamodel(Users2.class)
public class Users2_ { 

    public static volatile SingularAttribute<Users2, Integer> id;
    public static volatile ListAttribute<Users2, Orders2> orders2List1;
    public static volatile SingularAttribute<Users2, String> namepersonage;
    public static volatile SingularAttribute<Users2, String> adress;
    public static volatile ListAttribute<Users2, Orders2> orders2List;
    public static volatile SingularAttribute<Users2, String> email;
    public static volatile SingularAttribute<Users2, String> name;
    public static volatile SingularAttribute<Users2, String> surname;
    public static volatile SingularAttribute<Users2, String> login;
    public static volatile SingularAttribute<Users2, Integer> type;
    public static volatile SingularAttribute<Users2, String> password;

}