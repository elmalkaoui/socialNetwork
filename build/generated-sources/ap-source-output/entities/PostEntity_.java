package entities;

import entities.FileEntity;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2019-04-06T21:39:37")
@StaticMetamodel(PostEntity.class)
public class PostEntity_ { 

    public static volatile SingularAttribute<PostEntity, FileEntity> file;
    public static volatile SingularAttribute<PostEntity, Long> id;
    public static volatile SingularAttribute<PostEntity, String> content;

}