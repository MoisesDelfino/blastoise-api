package com.apipokedex.apipokedex.TipoPokemon;

import lombok.*;
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
