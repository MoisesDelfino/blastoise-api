package com.apipokedex.apipokedex.Pokemon;

import com.apipokedex.apipokedex.Treinador.Treinador;
import com.apipokedex.apipokedex.utils.Genero;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

public interface PokemonRepresentation {



    @Data
    @Builder
    @AllArgsConstructor
    @NoArgsConstructor
    class CriarOuAtualizar {

        @NotNull(message = "O campo nome não pode ser nulo")
        @NotEmpty
        private Long id;
        private String nome;
        private Long saude;
        private Long ataque;
        private Long defesa;
        private Long velocidade;
        private Genero genero;
        private Treinador treinador;


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
        private Treinador treinador;


        public static Detalhes from(Pokemon pokemon) {
            return Detalhes.builder()
                    .id(pokemon.getId())
                    .nome(pokemon.getNome())
                    .saude(pokemon.getSaude())
                    .ataque(pokemon.getAtaque())
                    .defesa(pokemon.getDefesa())
                    .velocidade(pokemon.getVelocidade())
                    .genero(pokemon.getGenero())
                    .treinador(pokemon.getTreinador())
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
        private Treinador treinador;

        public static Padrao from(Pokemon pokemon) {
            return Padrao.builder()
                    .id(pokemon.getId())
                    .nome(pokemon.getNome())
                    .saude(pokemon.getSaude())
                    .ataque(pokemon.getAtaque())
                    .defesa(pokemon.getDefesa())
                    .velocidade(pokemon.getVelocidade())
                    .genero(pokemon.getGenero())
                    .treinador(pokemon.getTreinador())
                    .build();
        }

        public static List<Padrao> from(List<Pokemon> pokemonList) {
            return pokemonList.stream()
                    .map(Padrao::from)
                    .collect(Collectors.toList());
        }

    }
    
}
