package com.apipokedex.apipokedex.Prontuario;


import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

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
