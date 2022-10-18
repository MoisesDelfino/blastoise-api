package com.apipokedex.apipokedex.Treinador;

import com.apipokedex.apipokedex.Pokemon.Pokemon;
import com.apipokedex.apipokedex.utils.Genero;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity(name = "treinador")
public class Treinador {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_treinador")
    private Long id;

    @Column(name = "nome")
    private String nome;

    @Column(name = "classificacao")
    private String classificacao;

    @Column(name = "genero")
    @Enumerated(EnumType.STRING)
    private Genero genero;

    @Column(name = "nascimento")
    private Date nascimento;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "treinador", orphanRemoval = true)
    List<Pokemon> pokemonList = new ArrayList<>();
}
