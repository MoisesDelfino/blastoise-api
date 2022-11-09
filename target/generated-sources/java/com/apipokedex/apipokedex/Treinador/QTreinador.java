package com.apipokedex.apipokedex.Treinador;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.annotations.Generated;
import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QTreinador is a Querydsl query type for Treinador
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QTreinador extends EntityPathBase<Treinador> {

    private static final long serialVersionUID = 2071973769L;

    public static final QTreinador treinador = new QTreinador("treinador");

    public final EnumPath<com.apipokedex.apipokedex.utils.Classificacao> classificacao = createEnum("classificacao", com.apipokedex.apipokedex.utils.Classificacao.class);

    public final EnumPath<com.apipokedex.apipokedex.utils.Genero> genero = createEnum("genero", com.apipokedex.apipokedex.utils.Genero.class);

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final DateTimePath<java.util.Date> nascimento = createDateTime("nascimento", java.util.Date.class);

    public final StringPath nome = createString("nome");

    public final ListPath<com.apipokedex.apipokedex.Pokemon.Pokemon, com.apipokedex.apipokedex.Pokemon.QPokemon> pokemonList = this.<com.apipokedex.apipokedex.Pokemon.Pokemon, com.apipokedex.apipokedex.Pokemon.QPokemon>createList("pokemonList", com.apipokedex.apipokedex.Pokemon.Pokemon.class, com.apipokedex.apipokedex.Pokemon.QPokemon.class, PathInits.DIRECT2);

    public final EnumPath<com.apipokedex.apipokedex.utils.Status> status = createEnum("status", com.apipokedex.apipokedex.utils.Status.class);

    public QTreinador(String variable) {
        super(Treinador.class, forVariable(variable));
    }

    public QTreinador(Path<? extends Treinador> path) {
        super(path.getType(), path.getMetadata());
    }

    public QTreinador(PathMetadata metadata) {
        super(Treinador.class, metadata);
    }

}

