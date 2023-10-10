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

    private String nomeEdificil;
    private String autorizacaoDeInformacao;
    private String tributacao;
    private String proprietarioLocalizado;
    private String restauranteCafes;
    private String qualInvestimento;
    private String investimento;
    private String pichacao;
    private String obsevacao;
    private String atividadeDeFuncionament;
    private String acessibilidade;
    private String laudo;
    private String numeroPavimentoEmUso;
    private String grauDeRisco;
    private String situacao;
    private String disponibilidade;


}
