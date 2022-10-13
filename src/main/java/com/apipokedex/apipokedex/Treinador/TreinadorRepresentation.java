package com.apipokedex.apipokedex.Treinador;

import com.apipokedex.apipokedex.Pokemon.PokemonRepresentation;
import com.apipokedex.apipokedex.utils.Genero;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.catalina.authenticator.SavedRequest;

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
        @NotNull(message = "O campo nome não pode ser nulo")
        @NotEmpty
        private String nome;
        private String classificacao;
        private Genero genero;
        private Date nascimento;
    }

    @Data
    @Builder
    class Detalhes{
        private Long id;
        private String nome;
        private String classificacao;
        private Date nascimento;
        private Genero genero;
        private List<PokemonRepresentation.Padrao> pokemons;

        public static Detalhes from(Treinador treinador) {
            return Objects.isNull(treinador.getPokemonList()) || treinador.getPokemonList().isEmpty() ?
                    Detalhes.builder()
                            .id(treinador.getId())
                            .nome(treinador.getNome())
                            .genero(treinador.getGenero())
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
        private PokemonRepresentation.Padrao pokemon;

        private static Lista from(Treinador treinador) {
            return treinador.getPokemonList().isEmpty() ?
                    Lista.builder()
                            .id(treinador.getId())
                            .nome(
                                    String.format("%s %s", treinador.getNome())
                            )
                            .build() :

                    Lista.builder()
                            .id(treinador.getId())
                            .nome(
                                    String.format("%s %s", treinador.getNome())
                            )
                            .pokemon(PokemonRepresentation.Padrao
                                    .from(treinador.getPokemonList().get(0)))
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
