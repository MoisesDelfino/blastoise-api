package com.apipokedex.apipokedex.Atendimento;

import com.apipokedex.apipokedex.Pokemon.PokemonService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/atendimento")
@CrossOrigin("*")
@AllArgsConstructor
public class AtendimentoController {
    private AtendimentoService atendimentoService;

    private PokemonService pokemonService;

    @PostMapping("/{idPokemon}")
    public ResponseEntity<AtendimentoRepresentation.Detalhes> createAtendimento(
            @PathVariable Long idPokemon,
            @RequestBody AtendimentoRepresentation.CriarOuAtualizar criar) {


        Atendimento atendimento = this.atendimentoService.criarAtendimento(pokemonService, idPokemon, criar);

        AtendimentoRepresentation.Detalhes detalhes =
                AtendimentoRepresentation.Detalhes.from(atendimento);

        return ResponseEntity.ok(detalhes);

    }

    @PutMapping("/{idAtendimento}")
    public ResponseEntity<AtendimentoRepresentation.Detalhes> atualizarAtendimento(
            @PathVariable Long idAtendimento,
            @RequestBody AtendimentoRepresentation.CriarOuAtualizar atualizar) {

        Atendimento atendimentoAtualizado =
                this.atendimentoService.atualizar(pokemonService, idAtendimento, atualizar);

        AtendimentoRepresentation.Detalhes detalhes =
                AtendimentoRepresentation.Detalhes
                        .from(atendimentoAtualizado);

        return ResponseEntity
                .ok(detalhes);

    }

    @DeleteMapping("/{idAtendimento}")
    public ResponseEntity<AtendimentoRepresentation.Detalhes> inativarAtendimento(
            @PathVariable Long idPokemon,
            @PathVariable Long idAtendimento) {

        Atendimento atendimentoInativo = this.atendimentoService.inativar(pokemonService, idPokemon, idAtendimento);

        AtendimentoRepresentation.Detalhes detalhes = AtendimentoRepresentation.Detalhes.from(atendimentoInativo);

        return ResponseEntity.ok(detalhes);

    }
}
