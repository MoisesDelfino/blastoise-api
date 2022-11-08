package com.apipokedex.apipokedex.Prontuario;


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


    @PostMapping("/")
    public ResponseEntity<ProntuarioRepresentation.Detalhes> createProntuario(
            @RequestBody @Valid ProntuarioRepresentation.CriarOuAtualizar criar){

        Prontuario prontuario = this.prontuarioService.criarProntuario(criar);

        ProntuarioRepresentation.Detalhes detalhes =
                ProntuarioRepresentation.Detalhes.from(prontuario);

        return ResponseEntity.ok(detalhes);
    }
}
