package com.apipokedex.apipokedex.Atendimento;

import com.apipokedex.apipokedex.Pokemon.Pokemon;
import com.apipokedex.apipokedex.Pokemon.PokemonService;
import com.apipokedex.apipokedex.exceptions.NotfoundException;
import com.apipokedex.apipokedex.exceptions.NullException;
import com.apipokedex.apipokedex.utils.Status;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import java.util.Optional;

@Service
@AllArgsConstructor
@Slf4j
public class AtendimentoService {

    private AtendimentoRepository atendimentoRepository;
    public Atendimento criarAtendimento(PokemonService pokemonService,
                                    Long idPokemon,
                                    AtendimentoRepresentation.CriarOuAtualizar criar) {

        if(criar.getUrgencia().toString().isEmpty()){
            log.error(criar.toString());
            throw new NullException("A urgência não pode ser vazia");
        }

        Pokemon pokemon = pokemonService.buscarUmPokemon(idPokemon);

        Atendimento atendimentoCriado = this.atendimentoRepository.save(Atendimento.builder()
                .pokemon(pokemon)
                .urgencia(criar.getUrgencia())
                .status(Status.A)
                .build());


        return atendimentoCriado;
    }

    public Atendimento buscarUmAtendimento(Long idAtendimento) {

        return this.getAtendimento(idAtendimento);

    }
    private Atendimento getAtendimento(Long idAtendimento) {
        Optional<Atendimento> atendimentoAtual =
                this.atendimentoRepository.findById(idAtendimento);

        if (atendimentoAtual.isPresent()) {

            if (atendimentoAtual.get().getStatus() == Status.A) {

                return atendimentoAtual.get();

            } else {

                throw new NotfoundException("Atendimento Desativado");
            }


        } else {
            throw new NotfoundException("Atendimento não encontrado");
        }
    }
    public Atendimento atualizar(
            PokemonService pokemonService,
            Long idAtendimento,
            AtendimentoRepresentation.CriarOuAtualizar atualizar) {


        if(atualizar.getUrgencia().toString().isEmpty()){
            log.error(atualizar.toString());
            throw new NullException("A urgência não pode ser vazio");
        }

        Atendimento atendimento = this.buscarUmAtendimento(idAtendimento);

        Long idPokemonAtendimentoCorreto = atendimento.getPokemon().getId();


        Atendimento atendimentoParaAtualizar = Atendimento.builder()
                .id(idAtendimento)
                .urgencia(atualizar.getUrgencia())
                .status(Status.A)
                .build();

        return this.atendimentoRepository.save(atendimentoParaAtualizar);

    }
    public Atendimento inativar(
            PokemonService pokemonService,
            Long idPokemon,
            Long idAtendimento) {

        Atendimento atendimento = this.buscarUmAtendimento(idAtendimento);
        Pokemon pokemon = pokemonService.buscarUmPokemon(idPokemon);

        Long idPokemonAtendimentoCorreto = atendimento.getPokemon().getId();;

        if (idPokemonAtendimentoCorreto != idPokemon) {
            throw new NotfoundException("Esse atendimento não pertence ao treinador com id: " + idPokemon);
        }


        return this.atendimentoRepository.save(Atendimento.builder()
                .id(idAtendimento)
                .pokemon(pokemon)
                .urgencia(atendimento.getUrgencia())
                .status(Status.D)
                .build());

    }


}
