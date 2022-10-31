package com.apipokedex.apipokedex.Receita;

import com.apipokedex.apipokedex.Atendimento.Atendimento;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface ReceitaRepository extends PagingAndSortingRepository<Receita, Long>,
        QuerydslPredicateExecutor<Receita> {
}
