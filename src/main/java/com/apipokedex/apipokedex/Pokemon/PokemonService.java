package com.apipokedex.apipokedex.Pokemon;

import com.apipokedex.apipokedex.Treinador.Treinador;
import com.apipokedex.apipokedex.Treinador.TreinadorService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Objects;


@Service
@AllArgsConstructor
@Slf4j
public class PokemonService {

    private PokemonRepository pokemonRepository;


    public Pokemon criarPokemon(TreinadorService treinadorService,
                             Long idTreinador,
                             PokemonRepresentation.CriarOuAtualizar criar) {

        Treinador treinador = treinadorService.buscarUmTreinador(idTreinador);

        return this.pokemonRepository.save(Pokemon.builder()
                .treinador(treinador)
                .nome(criar.getNome())
                .saude(criar.getSaude())
                .ataque(criar.getAtaque())
                .defesa(criar.getDefesa())
                .velocidade(criar.getVelocidade())
                .genero(criar.getGenero()) // Here can contain a error
                .build());
    }

//    public Pokemon criarPokemon(PokemonRepresentation.CriarOuAtualizar criar) {
//
//        if(Objects.isNull(criar.getNome())) {
//            log.error(criar.toString());
//            //throw new ProfessorServiceException("O sobrenome não pode ser nulo");
//        }
//
//        if(criar.getNome().isEmpty()) {
//            log.error(criar.toString());
//            //throw new ProfessorServiceException("O sobrenome não pode ser vazio");
//        }
//        return this.pokemonRepository.save(Pokemon.builder()
//                .nome(criar.getNome())
//                .saude(criar.getSaude())
//                .ataque(criar.getAtaque())
//                .defesa(criar.getDefesa())
//                .velocidade(criar.getVelocidade())
//                .genero(criar.getGenero())
//                .treinador(criar.getTreinador())
//                .build());
//
//    }



}
