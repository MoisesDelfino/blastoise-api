package com.apipokedex.apipokedex.Pokemon;

import com.apipokedex.apipokedex.TipoPokemon.TipoPokemon;
import com.apipokedex.apipokedex.TipoPokemon.TipoPokemonRepository;
import com.apipokedex.apipokedex.TipoPokemon.TipoPokemonRepresentation;
import com.apipokedex.apipokedex.Treinador.Treinador;
import com.apipokedex.apipokedex.Treinador.TreinadorService;
import com.apipokedex.apipokedex.exceptions.NotfoundException;
import com.apipokedex.apipokedex.exceptions.NullException;
import com.apipokedex.apipokedex.utils.Status;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.*;

@Service
@AllArgsConstructor
@Slf4j
public class PokemonService {
    private PokemonRepository pokemonRepository;

    private TipoPokemonRepository tipoPokemonRepository;

    public Pokemon criarPokemon(
            TreinadorService treinadorService,
            Long idTreinador,
            PokemonRepresentation.CriarOuAtualizar criar) {

        if(Objects.isNull(criar.getNome())){
            log.error(criar.toString());
            throw new NullException("O nome não pode ser nulo");
        }

        if(criar.getNome().isEmpty()){
            log.error(criar.toString());
            throw new NullException("O nome não pode ser vazio");
        }

        List<TipoPokemon> pokemonList = new ArrayList<>();

        criar.getTiposPokemonList().stream().forEach(id -> {
            pokemonList.add(this.tipoPokemonRepository.findById(id).get());
        });
//        List<TipoPokemon> pokemonList = this.tipoPokemonRepository.findAllById(criar.getTiposPokemonList());
        Treinador treinador = treinadorService.buscarUmTreinador(idTreinador);


        Pokemon pokemonCriado = this.pokemonRepository.save(Pokemon.builder()
                .treinador(treinador)
                .nome(criar.getNome())
                .saude(criar.getSaude())
                .ataque(criar.getAtaque())
                .defesa(criar.getDefesa())
                .velocidade(criar.getVelocidade())
                .genero(criar.getGenero())
                .tiposPokemonList(pokemonList)
                .status(Status.A)
                .build());


        return pokemonCriado;
    }

    public Pokemon buscarUmPokemon(Long idPokemon) {

        return this.getPokemon(idPokemon);

    }
    private Pokemon getPokemon(Long idPokemon) {
        Optional<Pokemon> pokemonAtual =
                this.pokemonRepository.findById(idPokemon);

        if (pokemonAtual.isPresent()) {

            if (pokemonAtual.get().getStatus() == Status.A) {

                return pokemonAtual.get();

            } else {

                throw new NotfoundException("Pokemon Desativado");
            }


        } else {
            throw new NotfoundException("Pokemon não encontrado");
        }
    }


    public Pokemon buscarDetalhesPokemon(
            Long idTreinador,
            Long idPokemon
            )
        {

        Pokemon pokemon = this.buscarUmPokemon(idPokemon);

        Long idTreinadorPokemonCorreto = pokemon.getTreinador().getId();

        if (idTreinadorPokemonCorreto != idTreinador) {
            throw new NotfoundException("Esse pokemon não pertence ao treinador com id: " + idTreinador);
        }


        return pokemon;

    }

    public Pokemon atualizar(
            TreinadorService treinadorService,
            Long idTreinador,
            Long idPokemon,
            PokemonRepresentation.CriarOuAtualizar atualizar) {


        if(Objects.isNull(atualizar.getNome())){
            log.error(atualizar.toString());
            throw new NotfoundException("O nome não pode ser nulo");
        }

        if(atualizar.getNome().isEmpty()){
            log.error(atualizar.toString());
            throw new NullException("O nome não pode ser vazio");
        }

        Pokemon pokemon = this.buscarUmPokemon(idPokemon);

        Long idTreinadorPokemonCorreto = pokemon.getTreinador().getId();

        if (idTreinadorPokemonCorreto != idTreinador) {
            throw new NotfoundException("Esse pokemon não pertence ao treinador com id: " + idTreinador);
        }

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
                .status(Status.A)
                .build();

        return this.pokemonRepository.save(pokemonParaAtualizar);

    }

    public Pokemon inativar(
            TreinadorService treinadorService,
            Long idTreinador,
            Long idPokemon) {

        Pokemon pokemon = this.buscarUmPokemon(idPokemon);
        Treinador treinador = treinadorService.buscarUmTreinador(idTreinador);

        Long idTreinadorPokemonCorreto = pokemon.getTreinador().getId();

        if (idTreinadorPokemonCorreto != idTreinador) {
            throw new NotfoundException("Esse pokemon não pertence ao treinador com id: " + idTreinador);
        }


        return this.pokemonRepository.save(Pokemon.builder()
                .id(idPokemon)
                .treinador(treinador)
                .nome(pokemon.getNome())
                .saude(pokemon.getSaude())
                .ataque(pokemon.getAtaque())
                .defesa(pokemon.getDefesa())
                .velocidade(pokemon.getVelocidade())
                .genero(pokemon.getGenero())
                .status(Status.D)
                .build());

    }
}
