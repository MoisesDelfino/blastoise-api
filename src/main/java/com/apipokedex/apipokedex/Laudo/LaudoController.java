package com.apipokedex.apipokedex.Laudo;


import com.apipokedex.apipokedex.Treinador.Treinador;
import com.apipokedex.apipokedex.Treinador.TreinadorRepresentation;
import com.apipokedex.apipokedex.Treinador.TreinadorService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("api/laudo")
@CrossOrigin("*")
@AllArgsConstructor
public class LaudoController {

    private LaudoService laudoService;

    @PostMapping("/")
    public ResponseEntity<LaudoRepresentation.Detalhes> createLaudo(
            @RequestBody @Valid LaudoRepresentation.CriarOuAtualizar criar){

        Laudo laudo = this.laudoService.criarLaudo(criar);

        LaudoRepresentation.Detalhes detalhes =
                LaudoRepresentation.Detalhes.from(laudo);

        return ResponseEntity.ok(detalhes);
    }
}
