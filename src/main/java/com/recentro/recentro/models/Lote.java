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
    @Column(name = "Lote_ID")
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

    @OneToOne(fetch = FetchType.LAZY, mappedBy = "lote")
    private Imovel owner;

    public Lote(PropertyInformation property) {
        this.nomeEdificil = property.getLote().getNomeEdificil();
        this.autorizacaoDeInformacao = property.getLote().getAutorizacaoDeInformacao();
        this.tributacao = property.getLote().getTributacao();
        this.proprietarioLocalizado = property.getLote().getProprietarioLocalizado();
        this.restauranteCafes = property.getLote().getRestauranteCafes();
        this.qualInvestimento = property.getLote().getQualInvestimento();
        this.pichacao = property.getLote().getPichacao();
        this.obsevacao = property.getLote().getObsevacao();
        this.atividadeDeFuncionament = property.getLote().getAtividadeDeFuncionament();
        this.acessibilidade = property.getLote().getAcessibilidade();
        this.laudo = property.getLote().getLaudo();
        this.numeroPavimentoEmUso = property.getLote().getNumeroPavimentoEmUso();
        this.grauDeRisco = property.getLote().getNumeroPavimentoEmUso();
        this.situacao = property.getLote().getSituacao();
        this.disponibilidade = property.getLote().getDisponibilidade();
    }
}
