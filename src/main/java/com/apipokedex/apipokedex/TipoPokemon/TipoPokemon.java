package com.apipokedex.apipokedex.TipoPokemon;

import com.apipokedex.apipokedex.Pokemon.Pokemon;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity(name = "tipo_pokemon")
public class TipoPokemon {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_tipo")
    private Long id;

    @Column(name = "nome")
    private String nome;

//    (mappedBy="tiposPokemonList")
    @ManyToMany
    private List<TipoPokemon> pokemonList = new ArrayList<>();


}
