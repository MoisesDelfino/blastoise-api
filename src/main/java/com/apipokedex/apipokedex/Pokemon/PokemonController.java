package com.apipokedex.apipokedex.Pokemon;

import com.apipokedex.apipokedex.TipoPokemon.TipoPokemonRepository;
import com.apipokedex.apipokedex.Treinador.TreinadorService;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("api/treinador/{idTreinador}/pokemon")
@CrossOrigin("*")
@AllArgsConstructor
public class PokemonController {
    private PokemonService pokemonService;
    private TreinadorService treinadorService;

    @PostMapping("/")
    public ResponseEntity<PokemonRepresentation.Detalhes> createPokemon(
            @PathVariable Long idTreinador,
            @RequestBody @Valid PokemonRepresentation.CriarOuAtualizar criar) {


        Pokemon pokemon = this.pokemonService.criarPokemon(treinadorService, idTreinador, criar);

        PokemonRepresentation.Detalhes detalhes =
                PokemonRepresentation.Detalhes.from(pokemon);

        return ResponseEntity.ok(detalhes);

    }

    @GetMapping("/{idPokemon}")
    public ResponseEntity<PokemonRepresentation.Detalhes> buscarUmPokemon(
            @PathVariable Long idTreinador,
            @PathVariable Long idPokemon
            ) {

        Pokemon pokemonBuscado =
                this.pokemonService.buscarDetalhesPokemon(idTreinador, idPokemon);

        PokemonRepresentation.Detalhes detalhes =
                PokemonRepresentation.Detalhes
                        .from(pokemonBuscado);

        return ResponseEntity
                .ok(detalhes);

    }


    @PutMapping("/{idPokemon}")
    public ResponseEntity<PokemonRepresentation.Detalhes> atualizarPokemon(
            @PathVariable Long idTreinador,
            @PathVariable Long idPokemon,
            @RequestBody PokemonRepresentation.CriarOuAtualizar atualizar) {

        Pokemon pokemonAtualizado =
                this.pokemonService.atualizar(treinadorService, idTreinador, idPokemon, atualizar);

        PokemonRepresentation.Detalhes detalhes =
                PokemonRepresentation.Detalhes
                        .from(pokemonAtualizado);

        return ResponseEntity
                .ok(detalhes);

    }

    @DeleteMapping("/{idPokemon}")
    public ResponseEntity<PokemonRepresentation.Detalhes> inativarPokemon(
            @PathVariable Long idTreinador,
            @PathVariable Long idPokemon) {

        Pokemon pokemonInativo = this.pokemonService.inativar(treinadorService, idTreinador, idPokemon);

        PokemonRepresentation.Detalhes detalhes = PokemonRepresentation.Detalhes.from(pokemonInativo);

        return ResponseEntity.ok(detalhes);

    }
}
