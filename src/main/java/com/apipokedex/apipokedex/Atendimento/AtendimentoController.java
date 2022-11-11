package com.apipokedex.apipokedex.Atendimento;

import com.apipokedex.apipokedex.Pokemon.PokemonService;
import com.apipokedex.apipokedex.utils.Paginacao;
import com.querydsl.core.types.Predicate;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.querydsl.binding.QuerydslPredicate;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

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
            @RequestBody @Valid AtendimentoRepresentation.CriarOuAtualizar criar) {


        Atendimento atendimento = this.atendimentoService.criarAtendimento(pokemonService, idPokemon, criar);

        AtendimentoRepresentation.Detalhes detalhes =
                AtendimentoRepresentation.Detalhes.from(atendimento);

        return ResponseEntity.ok(detalhes);

    }

    @GetMapping("/")
    public ResponseEntity<Paginacao> buscarAtendimentos(
            @QuerydslPredicate(root = Atendimento.class) Predicate filtroURI,
            @RequestParam(name="tamanhoPagina", defaultValue = "30") int tamanhoPagina,
            @RequestParam(name = "paginaSelecionada", defaultValue = "0") int paginaSelecionada) {


        Pageable pageable = PageRequest.of(paginaSelecionada, tamanhoPagina);

        Page<Atendimento> atendimentoList = this.atendimentoService.buscarTodos(filtroURI, pageable);

        List<AtendimentoRepresentation.Lista> listaFinal =
                AtendimentoRepresentation.Lista.from(atendimentoList.getContent());
        Paginacao paginacao = Paginacao.builder()
                .conteudo(listaFinal)
                .paginaSelecionada(paginaSelecionada)
                .proximaPagina(atendimentoList.hasNext())
                .tamanhoPagina(tamanhoPagina)
                .build();

        return ResponseEntity.ok(paginacao);
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
            @PathVariable Long idAtendimento) {

        Atendimento atendimentoInativo = this.atendimentoService.inativar(pokemonService, idAtendimento);

        AtendimentoRepresentation.Detalhes detalhes = AtendimentoRepresentation.Detalhes.from(atendimentoInativo);

        return ResponseEntity.ok(detalhes);

    }
}
