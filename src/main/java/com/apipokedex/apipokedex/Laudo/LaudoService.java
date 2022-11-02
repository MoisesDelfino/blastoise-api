package com.apipokedex.apipokedex.Laudo;

import com.apipokedex.apipokedex.Treinador.Treinador;
import com.apipokedex.apipokedex.Treinador.TreinadorRepository;
import com.apipokedex.apipokedex.Treinador.TreinadorRepresentation;
import com.apipokedex.apipokedex.exceptions.NullException;
import com.apipokedex.apipokedex.utils.Classificacao;
import com.apipokedex.apipokedex.utils.Status;

import java.util.Objects;

public class LaudoService {
    private LaudoRepository laudoRepository;
    public Laudo criarLaudo(LaudoRepresentation.CriarOuAtualizar criar) {

        return this.laudoRepository.save(Laudo.builder()
                .observacao(criar.getObservacao())
                .dataInicial(criar.getDataInicial())
                .dataFinal(criar.getDataFinal())
                .diagnostico(criar.getDiagnostico())
                .tratamento(criar.getTratamento())
                //.prontuario(criar.getProntuario())
                .saudeInicial(criar.getSaudeInicial())
                .saudeFinal(criar.getSaudeFinal())
                .status(criar.getStatus())
                .build());
    }
}
