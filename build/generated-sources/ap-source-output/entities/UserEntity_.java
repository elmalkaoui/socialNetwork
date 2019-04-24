package entities;

import entities.PostEntity;
import entities.UserEntity;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2019-04-24T16:05:00")
@StaticMetamodel(UserEntity.class)
public class UserEntity_ { 

    public static volatile SingularAttribute<UserEntity, String> imageLink;
    public static volatile SingularAttribute<UserEntity, String> firstname;
    public static volatile SingularAttribute<UserEntity, String> birthdate;
    public static volatile SingularAttribute<UserEntity, Long> id;
    public static volatile ListAttribute<UserEntity, PostEntity> posts;
    public static volatile ListAttribute<UserEntity, UserEntity> friends;
    public static volatile SingularAttribute<UserEntity, String> lastname;

}