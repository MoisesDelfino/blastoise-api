package com.apipokedex.apipokedex.Receita;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.annotations.Generated;
import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;

import com.querydsl.core.types.Path;


/**
 * QReceita is a Querydsl query type for Receita
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QReceita extends EntityPathBase<Receita> {

    private static final long serialVersionUID = -342886489L;

    public static final QReceita receita = new QReceita("receita");

    public final StringPath descricao = createString("descricao");

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public QReceita(String variable) {
        super(Receita.class, forVariable(variable));
    }

    public QReceita(Path<? extends Receita> path) {
        super(path.getType(), path.getMetadata());
    }

    public QReceita(PathMetadata metadata) {
        super(Receita.class, metadata);
    }

}

