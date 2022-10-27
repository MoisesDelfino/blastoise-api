package com.apipokedex.apipokedex.Tipo;

import com.apipokedex.apipokedex.Pokemon.Pokemon;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

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

//    @ManyToMany(mappedBy = "pokemon", fetch = FetchType.LAZY)
//    @JoinColumn(name = "")
//    private Pokemon pokemon;

}
