package com.apipokedex.apipokedex.Atendimento;

import com.apipokedex.apipokedex.Pokemon.Pokemon;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface AtendimentoRepository extends PagingAndSortingRepository<Atendimento, Long>,
        QuerydslPredicateExecutor<Atendimento> {
}
