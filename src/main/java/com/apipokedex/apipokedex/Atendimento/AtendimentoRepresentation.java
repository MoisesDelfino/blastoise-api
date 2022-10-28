package com.apipokedex.apipokedex.Atendimento;

import com.apipokedex.apipokedex.Pokemon.Pokemon;
import com.apipokedex.apipokedex.Pokemon.PokemonRepresentation;
import com.apipokedex.apipokedex.utils.Status;
import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;

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
}
