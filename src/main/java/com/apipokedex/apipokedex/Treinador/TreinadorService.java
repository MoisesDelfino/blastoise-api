package com.apipokedex.apipokedex.Treinador;

import com.apipokedex.apipokedex.Pokemon.Pokemon;
import com.apipokedex.apipokedex.utils.Classificacao;
import com.apipokedex.apipokedex.utils.Genero;
import com.querydsl.core.types.Predicate;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import com.apipokedex.apipokedex.exceptions.NotfoundException;
import com.apipokedex.apipokedex.exceptions.TreinadorServiceException;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;


@Service
@AllArgsConstructor
@Slf4j
public class TreinadorService {

    private TreinadorRepository treinadorRepository;
    public Treinador criarTreinador(TreinadorRepresentation.CriarOuAtualizar criar) {

        if(Objects.isNull(criar.getNome())){
            log.error(criar.toString());
            throw new TreinadorServiceException("O nome não pode ser nulo");
        }

        if(criar.getNome().isEmpty()){
            log.error(criar.toString());
            throw new TreinadorServiceException("O nome não pode ser vazio");
        }

        return this.treinadorRepository.save(Treinador.builder()
                .nome(criar.getNome())
                .classificacao(Classificacao.valueOf(criar.getClassificacao().name()))
                .genero(criar.getGenero())
                .status(criar.getStatus())
                .nascimento(criar.getNascimento())
                .build());
    }
    public Page<Treinador> buscarTodos(Pageable pageable) {
        return this.treinadorRepository.findAll(pageable);

    }

    public Page<Treinador> buscarTodos(Predicate filtroURI, Pageable pageable) {
        return this.treinadorRepository.findAll(filtroURI, pageable);
    }

    public Treinador atualizar(
            Long idTreinador,
            TreinadorRepresentation.CriarOuAtualizar atualizar) {

        this.getTreinador(idTreinador);

        Treinador treinadorParaAtualizar = Treinador.builder()
                    .id(idTreinador)
                    .nome(atualizar.getNome())
                    .classificacao(Classificacao.valueOf(atualizar.getClassificacao().name()))
                    .genero(atualizar.getGenero())
                    .status(atualizar.getStatus())
                    .nascimento(atualizar.getNascimento())
                    .build();


//        Pokemon pokemon = new Pokemon();
//
//        List pokemonList = new ArrayList();
//
//        pokemonList.add(pokemon);
//
//        treinadorParaAtualizar.getPokemonList().clear();
//
//        treinadorParaAtualizar.getPokemonList().addAll(pokemonList);



        return this.treinadorRepository.save(treinadorParaAtualizar);

    }


    public Treinador buscarUmTreinador(Long idTreinador) {

        return this.getTreinador(idTreinador);

    }

    private Treinador getTreinador(Long idTreinador) {
        Optional<Treinador> treinadorAtual =
                this.treinadorRepository.findById(idTreinador);

        if (treinadorAtual.isPresent()) {
            return treinadorAtual.get();
        } else {
            throw new NotfoundException("Treinador não encontrado");
        }
    }
}
