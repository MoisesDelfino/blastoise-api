package com.apipokedex.apipokedex.Prontuario;


import com.apipokedex.apipokedex.Atendimento.AtendimentoService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("api/prontuario")
@CrossOrigin("*")
@AllArgsConstructor
public class ProntuarioController {

    private ProntuarioService prontuarioService;

    private AtendimentoService atendimentoService;

    @PostMapping("/{idAtendimento}")
    public ResponseEntity<ProntuarioRepresentation.Detalhes> createProntuario(
            @PathVariable Long idAtendimento,
            @RequestBody @Valid ProntuarioRepresentation.CriarOuAtualizar criar){

        Prontuario prontuario = this.prontuarioService.criarProntuario(criar, atendimentoService, idAtendimento);

        ProntuarioRepresentation.Detalhes detalhes =
                ProntuarioRepresentation.Detalhes.from(prontuario);

        return ResponseEntity.ok(detalhes);
    }
}
