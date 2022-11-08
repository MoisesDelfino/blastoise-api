package com.apipokedex.apipokedex.Prontuario;

import com.apipokedex.apipokedex.Treinador.Treinador;
import com.apipokedex.apipokedex.Treinador.TreinadorRepository;
import com.apipokedex.apipokedex.Treinador.TreinadorRepresentation;
import com.apipokedex.apipokedex.exceptions.NullException;
import com.apipokedex.apipokedex.utils.Classificacao;
import com.apipokedex.apipokedex.utils.Status;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
@AllArgsConstructor
@Slf4j
public class ProntuarioService {
    private ProntuarioRepository prontuarioRepository;
    public Prontuario criarProntuario(ProntuarioRepresentation.CriarOuAtualizar criar) {

        return this.prontuarioRepository.save(Prontuario.builder()
                .atendimento(criar.getAtendimento())
                .consideracoes(criar.getConsideracoes())
                .build());
    }
}
