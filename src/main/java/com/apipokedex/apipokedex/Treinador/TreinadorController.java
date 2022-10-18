package com.apipokedex.apipokedex.Treinador;

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
import java.util.Objects;

@RestController
@RequestMapping("api/treinador")
@CrossOrigin("*")
@AllArgsConstructor
public class TreinadorController {

    private TreinadorService treinadorService;

    @PostMapping("/")
    public ResponseEntity<TreinadorRepresentation.Detalhes> createTreinador(
            @RequestBody @Valid TreinadorRepresentation.CriarOuAtualizar criar){

        Treinador treinador = this.treinadorService.criarTreinador(criar);

        TreinadorRepresentation.Detalhes detalhes =
                TreinadorRepresentation.Detalhes.from(treinador);

        return ResponseEntity.ok(detalhes);
    }

    @GetMapping("/")
    public ResponseEntity<Paginacao> buscarTreinadores(
            @QuerydslPredicate(root = Treinador.class) Predicate filtroURI,
            @RequestParam(name="tamanhoPagina", defaultValue = "30") int tamanhoPagina,
            @RequestParam(name = "paginaSelecionada", defaultValue = "0") int paginaSelecionada) {


        Pageable pageable = PageRequest.of(paginaSelecionada, tamanhoPagina);

        Page<Treinador> treinadorList = Objects.isNull(filtroURI) ?
                this.treinadorService.buscarTodos(pageable) :
                this.treinadorService.buscarTodos(filtroURI, pageable);

        List<TreinadorRepresentation.Lista> listaFinal =
                TreinadorRepresentation.Lista.from(treinadorList.getContent());
        Paginacao paginacao = Paginacao.builder()
                .conteudo(listaFinal)
                .paginaSelecionada(paginaSelecionada)
                .proximaPagina(treinadorList.hasNext())
                .tamanhoPagina(tamanhoPagina)
                .build();

        return ResponseEntity.ok(paginacao);
    }
    @PutMapping("/{idTreinador}")
    public ResponseEntity<TreinadorRepresentation.Detalhes> atualizarTreinador(
            @PathVariable Long idTreinador,
            @RequestBody TreinadorRepresentation.CriarOuAtualizar atualizar) {

        Treinador treinadorAtualizado =
                this.treinadorService.atualizar(idTreinador, atualizar);

        TreinadorRepresentation.Detalhes detalhes =
                TreinadorRepresentation.Detalhes
                        .from(treinadorAtualizado);

        return ResponseEntity
                .ok(detalhes);


    }

    @GetMapping("/{idTreinador}")
    public ResponseEntity<TreinadorRepresentation.Detalhes> buscarUmTreinador(
            @PathVariable Long idTreinador) {

        Treinador treinador = this.treinadorService.buscarUmTreinador(idTreinador);

        TreinadorRepresentation.Detalhes detalhes =
                TreinadorRepresentation.Detalhes
                        .from(treinador);

        return ResponseEntity
                .ok(detalhes);
    }
}
