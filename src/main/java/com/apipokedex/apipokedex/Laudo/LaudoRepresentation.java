package com.apipokedex.apipokedex.Laudo;

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

public interface LaudoRepresentation {
    @Data
    @Builder
    @AllArgsConstructor
    @NoArgsConstructor
    class CriarOuAtualizar {
        @NotNull(message = "O campo nome não pode ser nulo")
        @NotEmpty
        private String observacao;
        private Date dataInicial;
        private Date dataFinal;
        private String diagnostico;
        private String tratamento;
        //private Prontuario prontuario;
        private Integer saudeInicial;
        private Integer saudeFinal;
        private String status;
    }

    @Data
    @Builder
    class Detalhes{
        private Long id;
        private String observacao;
        private Date dataInicial;
        private Date dataFinal;
        private String diagnostico;
        private String tratamento;
        //private Prontuario prontuario;
        private Integer saudeInicial;
        private Integer saudeFinal;
        private String status;

        public static LaudoRepresentation.Detalhes from(Laudo laudo) {
            return Detalhes.builder()
                    .id(laudo.getId())
                    .observacao(laudo.getObservacao())
                    .dataInicial(laudo.getDataInicial())
                    .dataFinal(laudo.getDataFinal())
                    .diagnostico(laudo.getDiagnostico())
                    .tratamento(laudo.getTratamento())
                    //.prontuario(laudo.getProntuario())
                    .saudeInicial(laudo.getSaudeInicial())
                    .saudeFinal(laudo.getSaudeFinal())
                    .status(laudo.getStatus())
                    .build();
        }
    }
}
