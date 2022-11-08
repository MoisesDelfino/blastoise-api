package com.apipokedex.apipokedex.Pokemon;

import com.apipokedex.apipokedex.TipoPokemon.TipoPokemon;
import com.apipokedex.apipokedex.TipoPokemon.TipoPokemonRepresentation;
import com.apipokedex.apipokedex.Treinador.Treinador;
import com.apipokedex.apipokedex.Treinador.TreinadorRepresentation;
import com.apipokedex.apipokedex.utils.Genero;
import com.apipokedex.apipokedex.utils.Status;
import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public interface PokemonRepresentation {

    @Data
    @Builder
    @AllArgsConstructor
    @NoArgsConstructor
    class CriarOuAtualizar {

        @NotNull
        @NotEmpty(message = "O campo não pode ser vazio")
        private String nome;
        @NotNull
        @NotEmpty(message = "O campo não pode ser vazio")
        private Long saude;
        @NotNull
        @NotEmpty(message = "O campo não pode ser vazio")
        private Long ataque;
        @NotNull
        @NotEmpty(message = "O campo não pode ser vazio")
        private Long defesa;
        @NotNull
        @NotEmpty(message = "O campo não pode ser vazio")
        private Long velocidade;
        @NotNull
        @NotEmpty(message = "O campo não pode ser vazio")
        private Genero genero;

        private List<Long> tiposPokemonList;

    }

    @Data
    @Builder
    class Detalhes {
        private Long id;
        private String nome;
        private Long saude;
        private Long ataque;
        private Long defesa;
        private Long velocidade;
        private Genero genero;
        private Status status;
        private List<TipoPokemonRepresentation.ListTipo> tiposPokemonList;


        public static Detalhes from(Pokemon pokemon) {
            return Detalhes.builder()
                    .id(pokemon.getId())
                    .nome(pokemon.getNome())
                    .saude(pokemon.getSaude())
                    .ataque(pokemon.getAtaque())
                    .defesa(pokemon.getDefesa())
                    .velocidade(pokemon.getVelocidade())
                    .genero(pokemon.getGenero())
                    .status(pokemon.getStatus())
                    .tiposPokemonList(TipoPokemonRepresentation.ListTipo.from(pokemon.getTiposPokemonList()))
                    .build();
        }
    }


    @Builder
    @Data
    class Padrao {
        private Long id;
        private String nome;
        private Long saude;
        private Long ataque;
        private Long defesa;
        private Long velocidade;
        private Genero genero;
        private Status status;
        private List<TipoPokemonRepresentation.ListTipo> tiposPokemonList;

        public static Padrao from(Pokemon pokemon) {
            return Padrao.builder()
                    .id(pokemon.getId())
                    .nome(pokemon.getNome())
                    .saude(pokemon.getSaude())
                    .ataque(pokemon.getAtaque())
                    .defesa(pokemon.getDefesa())
                    .velocidade(pokemon.getVelocidade())
                    .genero(pokemon.getGenero())
                    .status(pokemon.getStatus())
                    .tiposPokemonList(TipoPokemonRepresentation.ListTipo.from(pokemon.getTiposPokemonList()))
                    .build();
        }

        public static List<Padrao> from(List<Pokemon> pokemonList) {
            return pokemonList.stream()
                    .map(Padrao::from)
                    .collect(Collectors.toList());
        }

    }
    
}
