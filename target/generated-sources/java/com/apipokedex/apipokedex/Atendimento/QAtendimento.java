package com.apipokedex.apipokedex.Atendimento;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.annotations.Generated;
import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QAtendimento is a Querydsl query type for Atendimento
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QAtendimento extends EntityPathBase<Atendimento> {

    private static final long serialVersionUID = 1355410181L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QAtendimento atendimento = new QAtendimento("atendimento");

    public final DateTimePath<java.util.Date> dataHoraInicio = createDateTime("dataHoraInicio", java.util.Date.class);

    public final NumberPath<Long> id = createNumber("id", Long.class);

    protected com.apipokedex.apipokedex.Pokemon.QPokemon pokemon;

    protected com.apipokedex.apipokedex.Prontuario.QProntuario prontuario;

    public final StringPath sintoma = createString("sintoma");

    public final EnumPath<com.apipokedex.apipokedex.utils.Status> status = createEnum("status", com.apipokedex.apipokedex.utils.Status.class);

    public final NumberPath<Integer> urgencia = createNumber("urgencia", Integer.class);

    public QAtendimento(String variable) {
        this(Atendimento.class, forVariable(variable), INITS);
    }

    public QAtendimento(Path<? extends Atendimento> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QAtendimento(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QAtendimento(PathMetadata metadata, PathInits inits) {
        this(Atendimento.class, metadata, inits);
    }

    public QAtendimento(Class<? extends Atendimento> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.pokemon = inits.isInitialized("pokemon") ? new com.apipokedex.apipokedex.Pokemon.QPokemon(forProperty("pokemon"), inits.get("pokemon")) : null;
        this.prontuario = inits.isInitialized("prontuario") ? new com.apipokedex.apipokedex.Prontuario.QProntuario(forProperty("prontuario"), inits.get("prontuario")) : null;
    }

    public com.apipokedex.apipokedex.Pokemon.QPokemon pokemon() {
        if (pokemon == null) {
            pokemon = new com.apipokedex.apipokedex.Pokemon.QPokemon(forProperty("pokemon"));
        }
        return pokemon;
    }

    public com.apipokedex.apipokedex.Prontuario.QProntuario prontuario() {
        if (prontuario == null) {
            prontuario = new com.apipokedex.apipokedex.Prontuario.QProntuario(forProperty("prontuario"));
        }
        return prontuario;
    }

}

