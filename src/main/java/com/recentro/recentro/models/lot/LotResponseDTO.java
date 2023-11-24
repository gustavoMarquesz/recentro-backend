package com.recentro.recentro.models.lot;

public class LotResponseDTO {
    public String nomeEdificil;
    public String autorizacaoDeInformacao;
    public String tributacao;
    public String proprietarioLocalizado;
    public String restauranteCafes;
    public String qualInvestimento;
    public String investimento;
    public String pichacao;
    public String obsevacao;
    public String atividadeDeFuncionamento;
    public String acessibilidade;
    public String laudo;
    public String numeroPavimentoEmUso;
    public String grauDeRisco;
    public String situacao;
    public String disponibilidade;

    public LotResponseDTO(
        String nomeEdificil,
        String autorizacaoDeInformacao,
        String tributacao,
        String proprietarioLocalizado,
        String restauranteCafes,
        String qualInvestimento,
        String investimento,
        String pichacao,
        String obsevacao,
        String atividadeDeFuncionamento,
        String acessibilidade,
        String laudo,
        String numeroPavimentoEmUso,
        String grauDeRisco,
        String situacao,
        String disponibilidade
    ) {
        this.nomeEdificil = nomeEdificil;
        this.autorizacaoDeInformacao = autorizacaoDeInformacao;
        this.tributacao = tributacao;
        this.proprietarioLocalizado = proprietarioLocalizado;
        this.restauranteCafes = restauranteCafes;
        this.qualInvestimento = qualInvestimento;
        this.investimento = investimento;
        this.pichacao = pichacao;
        this.obsevacao = obsevacao;
        this.atividadeDeFuncionamento = atividadeDeFuncionamento;
        this.acessibilidade = acessibilidade;
        this.laudo = laudo;
        this.numeroPavimentoEmUso = numeroPavimentoEmUso;
        this.grauDeRisco = grauDeRisco;
        this.situacao = situacao;
        this.disponibilidade = disponibilidade;
    }
}
