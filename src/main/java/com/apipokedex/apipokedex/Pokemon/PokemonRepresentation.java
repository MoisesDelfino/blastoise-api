package com.apipokedex.apipokedex.Pokemon;
import com.apipokedex.apipokedex.TipoPokemon.TipoPokemonRepresentation;
import com.apipokedex.apipokedex.utils.Genero;
import com.apipokedex.apipokedex.utils.Status;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.validation.constraints.NotEmpty;
import java.util.List;
import java.util.stream.Collectors;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public interface PokemonRepresentation {

    @Data
    @Builder
    @AllArgsConstructor
    @NoArgsConstructor
    class CriarOuAtualizar {

        @NotNull(message = "O campo nome não pode ser nulo - cod2")
        @NotEmpty(message = "O campo nome não pode ser vazio - cod2")
        private String nome;
        @NotNull(message = "O campo saude não pode ser nulo - cod2")
        private Long saude;
        @NotNull(message = "O campo ataque não pode ser nulo - cod2")
        private Long ataque;
        @NotNull(message = "O campo defesa não pode ser nulo - cod2")
        private Long defesa;
        @NotNull(message = "O campo velocidade não pode ser nulo - cod2")
        private Long velocidade;

        private Genero genero;
        @NotNull(message = "O campo tiposPokemonList não pode ser nulo - cod2")
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
