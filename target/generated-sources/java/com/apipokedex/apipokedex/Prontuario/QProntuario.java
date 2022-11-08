package com.apipokedex.apipokedex.Prontuario;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.annotations.Generated;
import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QProntuario is a Querydsl query type for Prontuario
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QProntuario extends EntityPathBase<Prontuario> {

    private static final long serialVersionUID = -2127473055L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QProntuario prontuario = new QProntuario("prontuario");

    protected com.apipokedex.apipokedex.Atendimento.QAtendimento atendimento;

    public final StringPath consideracoes = createString("consideracoes");

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public QProntuario(String variable) {
        this(Prontuario.class, forVariable(variable), INITS);
    }

    public QProntuario(Path<? extends Prontuario> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QProntuario(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QProntuario(PathMetadata metadata, PathInits inits) {
        this(Prontuario.class, metadata, inits);
    }

    public QProntuario(Class<? extends Prontuario> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.atendimento = inits.isInitialized("atendimento") ? new com.apipokedex.apipokedex.Atendimento.QAtendimento(forProperty("atendimento"), inits.get("atendimento")) : null;
    }

    public com.apipokedex.apipokedex.Atendimento.QAtendimento atendimento() {
        if (atendimento == null) {
            atendimento = new com.apipokedex.apipokedex.Atendimento.QAtendimento(forProperty("atendimento"));
        }
        return atendimento;
    }

}

