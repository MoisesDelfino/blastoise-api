package com.apipokedex.apipokedex.Prontuario;


import com.apipokedex.apipokedex.Atendimento.Atendimento;
import com.apipokedex.apipokedex.Atendimento.AtendimentoService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
@Slf4j
public class ProntuarioService {
    private ProntuarioRepository prontuarioRepository;

    public Prontuario criarProntuario(ProntuarioRepresentation.CriarOuAtualizar criar,
                                      AtendimentoService atendimentoService,
                                      Long idAtendimento) {


        Atendimento atendimento = atendimentoService.buscarUmAtendimento(idAtendimento);

        

        return this.prontuarioRepository.save(Prontuario.builder()
                .atendimento(atendimento)
                .consideracoes(criar.getConsideracoes())
                .build());
    }
}
