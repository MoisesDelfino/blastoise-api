package com.apipokedex.apipokedex.Receita;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.Data;

import java.util.List;
import java.util.stream.Collectors;

public interface ReceitaRepresentation {
    @Data
    @Builder
    @JsonInclude(JsonInclude.Include.NON_NULL)
    class Lista {
        private Long id;
        private String descricao;


        private static ReceitaRepresentation.Lista from(Receita receita) {
            return Lista.builder()
                    .id(receita.getId())
                    .descricao(receita.getDescricao())
                    .build();
        }

        public static List<ReceitaRepresentation.Lista> from(List<Receita> ReceitaList) {
            return ReceitaList
                    .stream()
                    .map(ReceitaRepresentation.Lista::from)
                    .collect(Collectors.toList());
        }
    }
}
