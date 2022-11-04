package com.apipokedex.apipokedex.Prontuario;

import com.apipokedex.apipokedex.Treinador.Treinador;
import com.apipokedex.apipokedex.Treinador.TreinadorRepository;
import com.apipokedex.apipokedex.Treinador.TreinadorRepresentation;
import com.apipokedex.apipokedex.exceptions.NullException;
import com.apipokedex.apipokedex.utils.Classificacao;
import com.apipokedex.apipokedex.utils.Status;

import java.util.Objects;

public class ProntuarioService {
    private ProntuarioRepository prontuarioRepository;
    public Prontuario criarProntuario(ProntuarioRepresentation.CriarOuAtualizar criar) {

        return this.prontuarioRepository.save(Prontuario.builder()
                .atendimento(criar.getAtendimento())
                .consideracoes(criar.getConsideracoes())
                .build());
    }
}
