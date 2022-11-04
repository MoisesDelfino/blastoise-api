package com.apipokedex.apipokedex.Prontuario;

import com.apipokedex.apipokedex.Treinador.Treinador;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

public interface ProntuarioRepository extends PagingAndSortingRepository<Prontuario, Long>,
        QuerydslPredicateExecutor<Prontuario> {

    List<Prontuario> findAll();
}
