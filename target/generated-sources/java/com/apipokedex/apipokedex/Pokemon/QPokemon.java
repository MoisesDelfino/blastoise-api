package com.apipokedex.apipokedex.Pokemon;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.annotations.Generated;
import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;

import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QPokemon is a Querydsl query type for Pokemon
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QPokemon extends EntityPathBase<Pokemon> {

    private static final long serialVersionUID = 1005402635L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QPokemon pokemon = new QPokemon("pokemon");

    public final NumberPath<Long> ataque = createNumber("ataque", Long.class);

    public final NumberPath<Long> defesa = createNumber("defesa", Long.class);

    public final EnumPath<com.apipokedex.apipokedex.utils.Genero> genero = createEnum("genero", com.apipokedex.apipokedex.utils.Genero.class);

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final StringPath nome = createString("nome");

    public final NumberPath<Long> saude = createNumber("saude", Long.class);

    public final EnumPath<com.apipokedex.apipokedex.utils.Status> status = createEnum("status", com.apipokedex.apipokedex.utils.Status.class);

    protected com.apipokedex.apipokedex.Treinador.QTreinador treinador;

    public final NumberPath<Long> velocidade = createNumber("velocidade", Long.class);

    public QPokemon(String variable) {
        this(Pokemon.class, forVariable(variable), INITS);
    }

    public QPokemon(Path<? extends Pokemon> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QPokemon(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QPokemon(PathMetadata metadata, PathInits inits) {
        this(Pokemon.class, metadata, inits);
    }

    public QPokemon(Class<? extends Pokemon> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.treinador = inits.isInitialized("treinador") ? new com.apipokedex.apipokedex.Treinador.QTreinador(forProperty("treinador")) : null;
    }

    public com.apipokedex.apipokedex.Treinador.QTreinador treinador() {
        if (treinador == null) {
            treinador = new com.apipokedex.apipokedex.Treinador.QTreinador(forProperty("treinador"));
        }
        return treinador;
    }

}

