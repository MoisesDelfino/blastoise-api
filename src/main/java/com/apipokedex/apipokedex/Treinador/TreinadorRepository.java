package com.apipokedex.apipokedex.Treinador;

import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

public interface TreinadorRepository extends PagingAndSortingRepository<Treinador, Long>,
        QuerydslPredicateExecutor<Treinador> {

    List<Treinador> findAll();


}
