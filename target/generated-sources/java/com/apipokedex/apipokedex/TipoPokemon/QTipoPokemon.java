package com.apipokedex.apipokedex.TipoPokemon;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.annotations.Generated;
import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;

import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QTipoPokemon is a Querydsl query type for TipoPokemon
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QTipoPokemon extends EntityPathBase<TipoPokemon> {

    private static final long serialVersionUID = -255209757L;

    public static final QTipoPokemon tipoPokemon = new QTipoPokemon("tipoPokemon");

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final StringPath nome = createString("nome");

    public final SetPath<com.apipokedex.apipokedex.Pokemon.Pokemon, com.apipokedex.apipokedex.Pokemon.QPokemon> pokemonList = this.<com.apipokedex.apipokedex.Pokemon.Pokemon, com.apipokedex.apipokedex.Pokemon.QPokemon>createSet("pokemonList", com.apipokedex.apipokedex.Pokemon.Pokemon.class, com.apipokedex.apipokedex.Pokemon.QPokemon.class, PathInits.DIRECT2);

    public QTipoPokemon(String variable) {
        super(TipoPokemon.class, forVariable(variable));
    }

    public QTipoPokemon(Path<? extends TipoPokemon> path) {
        super(path.getType(), path.getMetadata());
    }

    public QTipoPokemon(PathMetadata metadata) {
        super(TipoPokemon.class, metadata);
    }

}

