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
@StaticMetamodel(PostEntity.class)
public class PostEntity_ { 

    public static volatile SingularAttribute<PostEntity, String> fileLink;
    public static volatile SingularAttribute<PostEntity, UserEntity> author;
    public static volatile SingularAttribute<PostEntity, Long> id;
    public static volatile SingularAttribute<PostEntity, String> content;
    public static volatile SingularAttribute<PostEntity, String> fileType;

}