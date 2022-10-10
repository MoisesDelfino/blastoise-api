package com.apipokedex.apipokedex.Pokemon;


import com.apipokedex.apipokedex.Treinador.Treinador;
import com.apipokedex.apipokedex.utils.Genero;
import lombok.*;

import javax.persistence.*;
import javax.persistence.ManyToOne;


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
    private Integer id;

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

    @ManyToOne(fetch = FetchType.LAZY) //, mappedBy = "treinador", orphanRemoval = true
    @JoinColumn(name = "id_treinador")
    Treinador treinador = new Treinador();


}
