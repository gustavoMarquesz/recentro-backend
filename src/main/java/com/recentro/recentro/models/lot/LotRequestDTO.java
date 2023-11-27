package com.recentro.recentro.models.lot;

import com.recentro.recentro.models.PropertyInformation;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class LotRequestDTO {

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

    public LotRequestDTO(PropertyInformation property) {
        this.investimento = property.getLot().getInvestimento();
        this.nomeEdificil = property.getLot().getNomeEdificil();
        this.autorizacaoDeInformacao = property.getLot().getAutorizacaoDeInformacao();
        this.tributacao = property.getLot().getTributacao();
        this.proprietarioLocalizado = property.getLot().getProprietarioLocalizado();
        this.restauranteCafes = property.getLot().getRestauranteCafes();
        this.qualInvestimento = property.getLot().getQualInvestimento();
        this.pichacao = property.getLot().getPichacao();
        this.obsevacao = property.getLot().getObsevacao();
        this.atividadeDeFuncionamento = property.getLot().getAtividadeDeFuncionamento();
        this.acessibilidade = property.getLot().getAcessibilidade();
        this.laudo = property.getLot().getLaudo();
        this.numeroPavimentoEmUso = property.getLot().getNumeroPavimentoEmUso();
        this.grauDeRisco = property.getLot().getNumeroPavimentoEmUso();
        this.situacao = property.getLot().getSituacao();
        this.disponibilidade = property.getLot().getDisponibilidade();
    }
}
