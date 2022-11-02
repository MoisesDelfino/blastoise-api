package com.apipokedex.apipokedex.Laudo;

import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

public interface LaudoRepository extends PagingAndSortingRepository<Laudo, Long>,
        QuerydslPredicateExecutor<Laudo> {

    List<Laudo> findAll();
}
