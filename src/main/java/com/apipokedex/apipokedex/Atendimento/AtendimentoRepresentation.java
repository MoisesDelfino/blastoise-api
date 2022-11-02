package com.apipokedex.apipokedex.Atendimento;

import com.apipokedex.apipokedex.Pokemon.Pokemon;
import com.apipokedex.apipokedex.Pokemon.PokemonRepresentation;
import com.apipokedex.apipokedex.utils.Status;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;
import java.util.List;
import java.util.stream.Collectors;

public interface AtendimentoRepresentation {
    @Data
    @Builder
    @AllArgsConstructor
    @NoArgsConstructor
    class CriarOuAtualizar {
        @NotNull
        @NotEmpty(message = "O campo não pode ser vazio")
        private Pokemon pokemon;

        @NotNull
        @NotEmpty(message = "O campo não pode ser vazio")
        private Integer urgencia;

        @NotNull
        @NotEmpty(message = "O campo não pode ser vazio")
        private String sintomas;
    }

    @Data
    @Builder
    class Detalhes {
        private Long id;
        private Integer urgencia;
        private Status status;
        private String sintomas;


        public static Detalhes from(Atendimento atendimento) {
            return AtendimentoRepresentation.Detalhes.builder()
                    .id(atendimento.getId())
                    .urgencia(atendimento.getUrgencia())
                    .status(atendimento.getStatus())
                    .sintomas(atendimento.getSintomas())
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
        private String sintomas;


        private static AtendimentoRepresentation.Lista from(Atendimento atendimento) {
            return Lista.builder()
                            .id(atendimento.getId())
                            .urgencia(atendimento.getUrgencia())
                            .sintomas(atendimento.getSintomas())
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