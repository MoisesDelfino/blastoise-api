package com.apipokedex.apipokedex.Prontuario;

import com.apipokedex.apipokedex.Atendimento.Atendimento;
import com.apipokedex.apipokedex.Treinador.Treinador;
import com.apipokedex.apipokedex.Treinador.TreinadorRepresentation;
import com.apipokedex.apipokedex.utils.Classificacao;
import com.apipokedex.apipokedex.utils.Genero;
import com.apipokedex.apipokedex.utils.Status;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.Date;

public interface ProntuarioRepresentation {
    @Data
    @Builder
    @AllArgsConstructor
    @NoArgsConstructor
    class CriarOuAtualizar {
        @NotNull(message = "O campo atendimento não pode ser nulo")
        @NotEmpty
        private Atendimento atendimento;
        private String consideracoes;
    }

    @Data
    @Builder
    class Detalhes{
        private Long id;
        private Atendimento atendimento;
        private String consideracoes;

        public static ProntuarioRepresentation.Detalhes from(Prontuario prontuario) {
            return ProntuarioRepresentation.Detalhes.builder()
                    .id(prontuario.getId())
                    .atendimento(prontuario.getAtendimento())
                    .consideracoes(prontuario.getConsideracoes())
                    .build();
        }
    }
}
