package com.apipokedex.apipokedex.Pokemon;


import com.apipokedex.apipokedex.TipoPokemon.TipoPokemon;
import com.apipokedex.apipokedex.TipoPokemon.TipoPokemonRepository;
import com.apipokedex.apipokedex.TipoPokemon.TipoPokemonRepresentation;
import com.apipokedex.apipokedex.Treinador.Treinador;
import com.apipokedex.apipokedex.utils.Genero;
import com.apipokedex.apipokedex.utils.Status;
import lombok.*;
import javax.persistence.*;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.*;


@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name= "pokemon")
public class Pokemon {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_pokemon")
    private Long id;

    @Column(name = "nome")
    @NotNull(message = "O campo nome não pode ser nulo - cod1")
    @NotEmpty(message = "O campo nome não pode ser vazio - cod1")
    private String nome;

    @Column(name = "saude")
    @NotNull(message = "O campo saude não pode ser nulo - cod1")
    private Long saude;

    @Column(name = "ataque")
    @NotNull(message = "O campo ataque não pode ser nulo - cod1")
    private Long ataque;

    @Column(name = "defesa")
    @NotNull(message = "O campo defesa não pode ser nulo - cod1")
    private Long defesa;

    @Column(name = "velocidade")
    @NotNull(message = "O campo velocidade não pode ser nulo - cod1")
    private Long velocidade;

    @Column(name = "genero")
    @Enumerated(EnumType.STRING)
    private Genero genero;

    @ManyToMany
    @NotNull(message = "O campo tiposPokemonList não pode ser nulo - cod1")
    private List<TipoPokemon> tiposPokemonList = new ArrayList<>();

    @Column(name = "status")
    @Enumerated(EnumType.STRING)
    private Status status;

    @ManyToOne
    private Treinador treinador;

}
