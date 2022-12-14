package com.apipokedex.apipokedex.Treinador;

import com.apipokedex.apipokedex.Pokemon.Pokemon;
import com.apipokedex.apipokedex.Pokemon.PokemonRepresentation;
import com.apipokedex.apipokedex.utils.Classificacao;
import com.apipokedex.apipokedex.utils.Genero;
import com.apipokedex.apipokedex.utils.Status;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public interface TreinadorRepresentation {

    @Data
    @Builder
    @AllArgsConstructor
    @NoArgsConstructor
    class CriarOuAtualizar {
        @NotNull(message = "O campo nome não pode ser nulo - cod2")
        @NotEmpty(message = "O campo nome não pode ser vazio - cod2")
        private String nome;

        private Classificacao classificacao;

        private Genero genero;

        private Date nascimento;
    }

    @Data
    @Builder
    class Detalhes{
        private Long id;
        private String nome;
        private Classificacao classificacao;
        private Date nascimento;
        private Genero genero;
        private Status status;
        private List<PokemonRepresentation.Padrao> pokemons;

        public static Detalhes from(Treinador treinador) {
            return Objects.isNull(treinador.getPokemonList()) || treinador.getPokemonList().isEmpty() ?
                    Detalhes.builder()
                            .id(treinador.getId())
                            .nome(treinador.getNome())
                            .classificacao(treinador.getClassificacao())
                            .genero(treinador.getGenero())
                            .status(treinador.getStatus())
                            .nascimento(treinador.getNascimento())
                            .build() :
                    Detalhes.builder()
                            .id(treinador.getId())
                            .nome(treinador.getNome())
                            .genero(treinador.getGenero())
                            .status(treinador.getStatus())
                            .classificacao(treinador.getClassificacao())
                            .nascimento(treinador.getNascimento())
                            .pokemons(PokemonRepresentation.Padrao.from(treinador.getPokemonList()))
                            .build();
        }
    }
    @Data
    @Builder
    @JsonInclude(JsonInclude.Include.NON_NULL)
    class Lista {
        private Long id;
        private String nome;

        private static Lista from(Treinador treinador) {
            return Lista.builder()
                            .id(treinador.getId())
                            .nome(treinador.getNome())
                            .build();
        }

        public static List<Lista> from(List<Treinador> TreinadorList) {
            return TreinadorList
                    .stream()
                    .map(Lista::from)
                    .collect(Collectors.toList());
        }
    }


}
