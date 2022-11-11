package com.apipokedex.apipokedex.Atendimento;

import com.apipokedex.apipokedex.Pokemon.Pokemon;
import com.apipokedex.apipokedex.Prontuario.Prontuario;
import com.apipokedex.apipokedex.utils.Status;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name= "atendimento")
public class Atendimento {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_atendimento")
    private Long id;

    @ManyToOne
    private Pokemon pokemon;

    @Column(name = "urgencia")
    @NotNull(message = "O campo urgencia não pode ser nulo - cod1")
    private Integer urgencia;

    @Column(name = "status")
    private Status status;

    @Column(name = "dataHoraInicio")
    private Date dataHoraInicio;

    @OneToOne
    private Prontuario prontuario;

    @Column(name = "sintomas")
    @NotNull(message = "O campo sintomas não pode ser nulo - cod1")
    @NotEmpty(message = "O campo sintomas não pode ser vazio - cod1")
    private String sintomas;
}
