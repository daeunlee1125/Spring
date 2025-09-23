package kr.co.ch06.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;


/**
 * QTB_User1 is a Querydsl query type for TB_User1
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QTB_User1 extends EntityPathBase<TB_User1> {

    private static final long serialVersionUID = 1802728504L;

    public static final QTB_User1 tB_User1 = new QTB_User1("tB_User1");

    public final NumberPath<Integer> age = createNumber("age", Integer.class);

    public final StringPath birth = createString("birth");

    public final StringPath name = createString("name");

    public final StringPath userId = createString("userId");

    public QTB_User1(String variable) {
        super(TB_User1.class, forVariable(variable));
    }

    public QTB_User1(Path<? extends TB_User1> path) {
        super(path.getType(), path.getMetadata());
    }

    public QTB_User1(PathMetadata metadata) {
        super(TB_User1.class, metadata);
    }

}

