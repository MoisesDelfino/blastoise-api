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
    private String nome;

    @Column(name = "saude")
    private Long saude;

    @Column(name = "ataque")
    private Long ataque;

    @Column(name = "defesa")
    private Long defesa;

    @Column(name = "velocidade")
    private Long velocidade;

    @Column(name = "genero")
    @Enumerated(EnumType.STRING)
    private Genero genero;

    @ManyToMany
    private List<TipoPokemon> tiposPokemonList = new ArrayList<>();


    @Column(name = "status")
    @Enumerated(EnumType.STRING)
    private Status status;

    @ManyToOne
    private Treinador treinador;

}
