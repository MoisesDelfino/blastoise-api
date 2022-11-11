package com.apipokedex.apipokedex.Prontuario;

import com.apipokedex.apipokedex.Atendimento.Atendimento;
import com.apipokedex.apipokedex.Pokemon.Pokemon;
import com.apipokedex.apipokedex.Treinador.Treinador;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity(name = "prontuario")
public class Prontuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_prontuario")
    private Long id;

    @OneToOne
    private Atendimento atendimento;

    @Column(name = "consideracoes")
    @NotEmpty(message = "O campo consideracoes não pode ser vazio - cod1")
    @NotNull(message = "O campo consideracoes não pode ser nulo - cod1")
    private String consideracoes;

}
