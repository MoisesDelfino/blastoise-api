package com.apipokedex.apipokedex.Atendimento;

import com.apipokedex.apipokedex.Pokemon.Pokemon;
import com.apipokedex.apipokedex.Prontuario.Prontuario;
import com.apipokedex.apipokedex.utils.Status;
import lombok.*;

import javax.persistence.*;
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
    private Integer urgencia;

    @Column(name = "status")
    private Status status;

    @Column(name = "dataHoraInicio")
    private Date dataHoraInicio;

    @OneToOne(mappedBy = "atendimento")
    private Prontuario prontuario;

    @Column(name = "sintomas")
    private String sintomas;
}
