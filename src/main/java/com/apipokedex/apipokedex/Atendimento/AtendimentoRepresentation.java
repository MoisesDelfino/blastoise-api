package com.apipokedex.apipokedex.Atendimento;

import com.apipokedex.apipokedex.Pokemon.Pokemon;
import com.apipokedex.apipokedex.Pokemon.PokemonRepresentation;
import com.apipokedex.apipokedex.utils.Status;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.stream.Collectors;

public interface AtendimentoRepresentation {
    @Data
    @Builder
    @AllArgsConstructor
    @NoArgsConstructor
    class CriarOuAtualizar {
        @NotNull(message = "O campo não pode ser vazio")
        private Pokemon pokemon;

        @NotNull(message = "O campo não pode ser vazio")
        private Integer urgencia;
    }

    @Data
    @Builder
    class Detalhes {
        private Long id;
        private Integer urgencia;
        private Status status;


        public static Detalhes from(Atendimento atendimento) {
            return AtendimentoRepresentation.Detalhes.builder()
                    .id(atendimento.getId())
                    .urgencia(atendimento.getUrgencia())
                    .status(atendimento.getStatus())
                    .build();
        }
    }
    @Data
    @Builder
    @JsonInclude(JsonInclude.Include.NON_NULL)
    class Lista {
        private Long id;
        private PokemonRepresentation.Padrao pokemon;
        private Integer urgencia;
        private Integer status;


        private static AtendimentoRepresentation.Lista from(Atendimento atendimento) {
            return Lista.builder()
                            .id(atendimento.getId())
                            .urgencia(atendimento.getUrgencia())
                            .build();
        }

        public static List<AtendimentoRepresentation.Lista> from(List<Atendimento> AtendimentoList) {
            return AtendimentoList
                    .stream()
                    .map(AtendimentoRepresentation.Lista::from)
                    .collect(Collectors.toList());
        }
    }
}
