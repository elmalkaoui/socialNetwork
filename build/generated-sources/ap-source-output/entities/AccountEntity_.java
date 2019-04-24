package entities;

import entities.UserEntity;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

<<<<<<< HEAD
@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2019-04-24T21:19:19")
=======
@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2019-04-24T20:26:01")
>>>>>>> master
@StaticMetamodel(AccountEntity.class)
public class AccountEntity_ { 

    public static volatile SingularAttribute<AccountEntity, String> password;
    public static volatile SingularAttribute<AccountEntity, Long> id;
    public static volatile SingularAttribute<AccountEntity, UserEntity> user;
    public static volatile SingularAttribute<AccountEntity, String> username;

}