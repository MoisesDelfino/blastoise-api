package com.apipokedex.apipokedex.Laudo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity(name = "laudo")
public class Laudo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_laudo")
    private Long id;

    @Column(name = "observacao")
    private String observacao;

    @Column(name = "dataInicial")
    private Date dataInicial;

    @Column(name = "dataFinal")
    private Date dataFinal;

    @Column(name = "diagnostico")
    private String diagnostico;

    @Column(name = "tratamento")
    private String tratamento;

//    @OneToOne(cascade = CascadeType.ALL)
//    @JoinColumn(name = "id_prontuario", referencedColumnName = "id")
//    private Prontuario prontuario;

    @Column(name = "saudeInicial")
    private Integer saudeInicial;

    @Column(name = "saudeFinal")
    private Integer saudeFinal;

    @Column(name = "status")
    private String status;

}
