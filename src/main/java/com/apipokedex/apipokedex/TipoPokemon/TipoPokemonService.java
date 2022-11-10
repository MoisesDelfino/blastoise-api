package com.apipokedex.apipokedex.TipoPokemon;


import com.apipokedex.apipokedex.Treinador.Treinador;
import com.querydsl.core.types.Predicate;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
@Slf4j
public class TipoPokemonService {

    TipoPokemonRepository tipoPokemonRepository;

    public Page<TipoPokemon> buscarTodos(Pageable pageable) {
        return this.tipoPokemonRepository.findAll(pageable);
    }
}
