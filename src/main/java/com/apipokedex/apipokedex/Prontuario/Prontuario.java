package com.apipokedex.apipokedex.Prontuario;

import com.apipokedex.apipokedex.Atendimento.Atendimento;
import com.apipokedex.apipokedex.Pokemon.Pokemon;
import com.apipokedex.apipokedex.Treinador.Treinador;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

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
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_atendimento", referencedColumnName = "id")
    private Atendimento atendimento;

    @Column(name = "consideracoes")
    private String consideracoes;

}
