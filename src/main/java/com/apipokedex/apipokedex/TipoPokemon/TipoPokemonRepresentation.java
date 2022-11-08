package com.apipokedex.apipokedex.TipoPokemon;

import com.apipokedex.apipokedex.Pokemon.Pokemon;
import com.apipokedex.apipokedex.Pokemon.PokemonRepresentation;
import com.sun.istack.NotNull;
import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;
import java.util.List;
import java.util.stream.Collectors;

public interface TipoPokemonRepresentation {

    @Data
    @Builder
    @AllArgsConstructor
    class ListTipo {

        private Long id;
        private String nome;

        public static List<ListTipo> from(List<TipoPokemon> tipoPokemonList) {
            return tipoPokemonList.stream()
                    .map(ListTipo::from)
                    .collect(Collectors.toList());
        }

        private static ListTipo from(TipoPokemon tipoPokemon) {
            return ListTipo.builder()
                    .id(tipoPokemon.getId())
                    .nome(tipoPokemon.getNome())
                    .build();
        }

    }
}
