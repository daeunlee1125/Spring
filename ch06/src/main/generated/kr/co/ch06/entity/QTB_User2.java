package kr.co.ch06.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;


/**
 * QTB_User2 is a Querydsl query type for TB_User2
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QTB_User2 extends EntityPathBase<TB_User2> {

    private static final long serialVersionUID = 1802728505L;

    public static final QTB_User2 tB_User2 = new QTB_User2("tB_User2");

    public final StringPath gender = createString("gender");

    public final StringPath hp = createString("hp");

    public final StringPath name = createString("name");

    public final StringPath userId = createString("userId");

    public QTB_User2(String variable) {
        super(TB_User2.class, forVariable(variable));
    }

    public QTB_User2(Path<? extends TB_User2> path) {
        super(path.getType(), path.getMetadata());
    }

    public QTB_User2(PathMetadata metadata) {
        super(TB_User2.class, metadata);
    }

}

