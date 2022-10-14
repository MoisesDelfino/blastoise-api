package com.apipokedex.apipokedex.Pokemon;

import com.apipokedex.apipokedex.utils.Paginacao;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.querydsl.binding.QuerydslPredicate;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Objects;
import java.util.function.Predicate;


@RestController
@RequestMapping("api/Pokemon")
@CrossOrigin("*")
@AllArgsConstructor
public class PokemonController {

    private PokemonService PokemonService;

    @PostMapping("/")
    public ResponseEntity<PokemonRepresentation.Detalhes> createPokemon(
            @RequestBody @Valid PokemonRepresentation.CriarOuAtualizar criar){

        Pokemon Pokemon = this.PokemonService.criarPokemon(criar);

        PokemonRepresentation.Detalhes detalhes =
                PokemonRepresentation.Detalhes.from(Pokemon);

        return ResponseEntity.ok(detalhes);
    }

//    @GetMapping("/")
//    public ResponseEntity<Paginacao> buscarPokemones(
//            @QuerydslPredicate(root = Pokemon.class) Predicate filtroURI,
//            @RequestParam(name="tamanhoPagina", defaultValue = "30") int tamanhoPagina,
//            @RequestParam(name = "paginaSelecionada", defaultValue = "0") int paginaSelecionada) {
//
//
//        Pageable pageable = PageRequest.of(paginaSelecionada, tamanhoPagina);
//
//        Page<Pokemon> PokemonList = Objects.isNull(filtroURI) ?
//                this.PokemonService.buscarTodos(pageable) :
//                this.PokemonService.buscarTodos(filtroURI, pageable);
//
//        List<PokemonRepresentation.Lista> listaFinal =
//                PokemonRepresentation.Lista.from(PokemonList.getContent());
//        Paginacao paginacao = Paginacao.builder()
//                .conteudo(listaFinal)
//                .paginaSelecionada(paginaSelecionada)
//                .proximaPagina(PokemonList.hasNext())
//                .tamanhoPagina(tamanhoPagina)
//                .build();
//
//        return ResponseEntity.ok(paginacao);
//    }
//    @PutMapping("/{idPokemon}")
//    public ResponseEntity<PokemonRepresentation.Detalhes> atualizarPokemon(
//            @PathVariable Long idPokemon,
//            @RequestBody PokemonRepresentation.CriarOuAtualizar atualizar) {
//
//        Pokemon PokemonAtualizado =
//                this.PokemonService.atualizar(idPokemon, atualizar);
//
//        PokemonRepresentation.Detalhes detalhes =
//                PokemonRepresentation.Detalhes
//                        .from(PokemonAtualizado);
//
//        return ResponseEntity
//                .ok(detalhes);
//
//
//    }
//
//    @GetMapping("/{idPokemon}")
//    public ResponseEntity<PokemonRepresentation.Detalhes> buscarUmPokemon(
//            @PathVariable Long idPokemon) {
//
//        Pokemon Pokemon = this.PokemonService.buscarUmPokemon(idPokemon);
//
//        PokemonRepresentation.Detalhes detalhes =
//                PokemonRepresentation.Detalhes
//                        .from(Pokemon);
//
//        return ResponseEntity
//                .ok(detalhes);
//
//    }
}
