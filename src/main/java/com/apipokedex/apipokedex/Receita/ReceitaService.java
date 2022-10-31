package com.apipokedex.apipokedex.Receita;

import com.querydsl.core.types.Predicate;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public class ReceitaService {
    private ReceitaRepository receitaRepository;
    public Page<Receita> buscarTodos(Predicate filtroURI, Pageable pageable) {
        return this.receitaRepository.findAll(pageable);

    }
}
