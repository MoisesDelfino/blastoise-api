package com.apipokedex.apipokedex.Treinador;

import com.apipokedex.apipokedex.Pokemon.Pokemon;
import com.apipokedex.apipokedex.utils.Classificacao;
import com.apipokedex.apipokedex.utils.Genero;
import com.apipokedex.apipokedex.utils.Status;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Where;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
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
    @NotNull(message = "O campo nome não pode ser nulo - cod1")
    @NotEmpty(message = "O campo nome não pode ser vazio - cod1")
    private String nome;

    @Column(name = "classificacao")
    private Classificacao classificacao;

    @Column(name = "genero")
    @Enumerated(EnumType.STRING)
    private Genero genero;

    @Column(name = "status")
    @Enumerated(EnumType.STRING)
    private Status status;

    @Column(name = "nascimento")
    private Date nascimento;

    @Where(clause = "status='A'")
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "treinador", orphanRemoval = false)
    List<Pokemon> pokemonList = new ArrayList<>();
}
