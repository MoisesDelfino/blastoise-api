package com.apipokedex.apipokedex.Prontuario;

import com.apipokedex.apipokedex.Atendimento.Atendimento;
import com.apipokedex.apipokedex.Atendimento.AtendimentoRepresentation;
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

        @NotEmpty(message = "O campo consideracoes não pode ser vazio - cod2")
        @NotNull(message = "O campo consideracoes não pode ser nulo - cod2")
        private String consideracoes;
    }

    @Data
    @Builder
    class Detalhes{
        private Long id;
        private AtendimentoRepresentation.Detalhes atendimento;
        private String consideracoes;

        public static Detalhes from(Prontuario prontuario) {
            return Detalhes.builder()
                    .id(prontuario.getId())
                    .atendimento(AtendimentoRepresentation.Detalhes.from(prontuario.getAtendimento()))
                    .consideracoes(prontuario.getConsideracoes())
                    .build();
        }
    }
}
