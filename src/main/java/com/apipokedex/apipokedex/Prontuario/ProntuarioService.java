package com.apipokedex.apipokedex.Prontuario;

<<<<<<< HEAD
=======
import com.apipokedex.apipokedex.Treinador.Treinador;
import com.apipokedex.apipokedex.Treinador.TreinadorRepository;
import com.apipokedex.apipokedex.Treinador.TreinadorRepresentation;
import com.apipokedex.apipokedex.exceptions.NullException;
import com.apipokedex.apipokedex.utils.Classificacao;
import com.apipokedex.apipokedex.utils.Status;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
>>>>>>> 984d88eb2fcb86572dbc08bd1cff6fd155e4b485

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
