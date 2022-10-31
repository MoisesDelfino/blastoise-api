package com.apipokedex.apipokedex.Receita;

import com.apipokedex.apipokedex.Atendimento.Atendimento;
import com.apipokedex.apipokedex.Atendimento.AtendimentoRepresentation;
import com.apipokedex.apipokedex.Atendimento.AtendimentoService;
import com.apipokedex.apipokedex.utils.Paginacao;
import com.querydsl.core.types.Predicate;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.querydsl.binding.QuerydslPredicate;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/receita")
@CrossOrigin("*")
@AllArgsConstructor
public class ReceitaController {

    private ReceitaService receitaService;

    @GetMapping("/")
    public ResponseEntity<Paginacao> buscarReceitas(
            @QuerydslPredicate(root = Receita.class) Predicate filtroURI,
            @RequestParam(name="tamanhoPagina", defaultValue = "30") int tamanhoPagina,
            @RequestParam(name = "paginaSelecionada", defaultValue = "0") int paginaSelecionada) {


        Pageable pageable = PageRequest.of(paginaSelecionada, tamanhoPagina);

        Page<Receita> receitaList = this.receitaService.buscarTodos(filtroURI, pageable);

        List<ReceitaRepresentation.Lista> listaFinal =
                ReceitaRepresentation.Lista.from(receitaList.getContent());
        Paginacao paginacao = Paginacao.builder()
                .conteudo(listaFinal)
                .paginaSelecionada(paginaSelecionada)
                .proximaPagina(receitaList.hasNext())
                .tamanhoPagina(tamanhoPagina)
                .build();

        return ResponseEntity.ok(paginacao);
    }
}

