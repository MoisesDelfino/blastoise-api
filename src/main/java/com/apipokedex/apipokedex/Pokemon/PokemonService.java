package com.apipokedex.apipokedex.Pokemon;

import com.apipokedex.apipokedex.Treinador.Treinador;
import com.apipokedex.apipokedex.Treinador.TreinadorService;
import com.apipokedex.apipokedex.exceptions.NotfoundException;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Optional;


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


    public Pokemon buscarUmPokemon(Long idPokemon) {

        return this.getPokemon(idPokemon);

    }
    private Pokemon getPokemon(Long idPokemon) {
        Optional<Pokemon> pokemonAtual =
                this.pokemonRepository.findById(idPokemon);

        if (pokemonAtual.isPresent()) {
            return pokemonAtual.get();
        } else {
            throw new NotfoundException("Pokemon não encontrado");
        }
    }

    public Pokemon atualizar(
            TreinadorService treinadorService,
            Long idTreinador,
            Long idPokemon,
            PokemonRepresentation.CriarOuAtualizar atualizar) {

        Treinador treinador = treinadorService.buscarUmTreinador(idTreinador);

        Pokemon pokemonParaAtualizar = Pokemon.builder()
                .id(idPokemon)
                .treinador(treinador)
                .nome(atualizar.getNome())
                .saude(atualizar.getSaude())
                .ataque(atualizar.getAtaque())
                .defesa(atualizar.getDefesa())
                .velocidade(atualizar.getVelocidade())
                .genero(atualizar.getGenero())
                .build();

        return this.pokemonRepository.save(pokemonParaAtualizar);

    }

}
