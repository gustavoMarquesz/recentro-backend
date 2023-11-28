package com.recentro.recentro.models.lot;

import com.recentro.recentro.models.PropertyInformation;
import com.recentro.recentro.models.property.Property;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Lot {
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
    private String atividadeDeFuncionamento;
    private String acessibilidade;
    private String laudo;
    private String numeroPavimentoEmUso;
    private String grauDeRisco;
    private String situacao;
    private String disponibilidade;

    @OneToOne(fetch = FetchType.LAZY, mappedBy = "lot")
    private Property property;

    public Lot(LotRequestDTO property) {
        this.investimento  = property.getInvestimento();
        this.nomeEdificil = property.getNomeEdificil();
        this.autorizacaoDeInformacao = property.getAutorizacaoDeInformacao();
        this.tributacao = property.getTributacao();
        this.proprietarioLocalizado = property.getProprietarioLocalizado();
        this.restauranteCafes = property.getRestauranteCafes();
        this.qualInvestimento = property.getQualInvestimento();
        this.pichacao = property.getPichacao();
        this.obsevacao = property.getObsevacao();
        this.atividadeDeFuncionamento = property.getAtividadeDeFuncionamento();
        this.acessibilidade = property.getAcessibilidade();
        this.laudo = property.getLaudo();
        this.numeroPavimentoEmUso = property.getNumeroPavimentoEmUso();
        this.grauDeRisco = property.getNumeroPavimentoEmUso();
        this.situacao = property.getSituacao();
        this.disponibilidade = property.getDisponibilidade();
    }
}
