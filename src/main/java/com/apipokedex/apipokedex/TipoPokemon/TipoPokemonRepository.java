package com.apipokedex.apipokedex.TipoPokemon;

import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;


public interface TipoPokemonRepository extends PagingAndSortingRepository<TipoPokemon, Long>,
        QuerydslPredicateExecutor<TipoPokemon> {



}