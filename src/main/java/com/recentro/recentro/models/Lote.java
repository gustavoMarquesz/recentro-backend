package com.recentro.recentro.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Lote {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;


    @Column
    private String nomeEdificil;
    @Column
    private String autorizacaoDeInformacao;
    @Column
    private String tributacao;
    @Column
    private String proprietarioLocalizado;
    @Column
    private String restauranteCafes;
    @Column
    private String qualInvestimento;
    @Column
    private String investimento;
    @Column
    private String pichacao;
    @Column
    private String obsevacao;
    @Column
    private String atividadeDeFuncionament;
    @Column
    private String acessibilidade;
    @Column
    private String laudo;
    @Column
    private String numeroPavimentoEmUso;

    @ManyToOne
    @JoinColumn(name = "idGrau")
    private GrauDeRisco grauDeRisco;

    @ManyToOne
    @JoinColumn(name = "idSituacao")
    private Situacao situacao;

    //@ManyToOne
    //@JoinColumn(name = "idDisponibilidade")
    //private Disponibilidade disponibilidade;


}
