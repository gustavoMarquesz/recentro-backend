package com.recentro.recentro.models.property;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class PropertyResponseDTO {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;

    public String endereco;
    public String contatoProprietario;
    public String proprietarioCartorio;

    public String coincidenciaProprietario;
    public String observacao;
    public String descricaoJudicializacao;
    public String proprietarioCampo;
    public String planta;
    public String rgi;
    public String valorDoAluguel;

    public String valorDeVenda;
    public String judicializacao;
    public Double longitude;
    public Double latitude;
    public String plantaRegional;
    public String usoDoImovel;
    public String dsqfl;
    public String numero;
    public String rua;
    public String dsq;
    public String tipoEmpreendimento;
    public String areaTotal;
    public String bairro;
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
    public String nuProcesso;
    public String nuLicenca;
    public String ProcessoAberto2018;



    // To return all fields with related entities
    public PropertyResponseDTO(

            String valorDeVenda, Long id, String endereco,
            String contatoProprietario,
            String proprietarioCartorio,
            String observacao,
            String descricaoJudicializacao,
            String proprietarioCampo,
            String planta,
            String rgi,
            String valorDoAluguel,
            String judicializacao,
            Double longitude,
            Double latitude,
            String plantaRegional,
            String usoDoImovel,
            String dsqfl,
            String numero,
            String rua,
            String dsq,
            String tipoEmpreendimento,
            String areaTotal,
            String bairro,
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
            String disponibilidade,
            String nuProcesso,
            String nuLicenca,
            String ProcessoAberto2018,
            String coincidenciaProprietario) {
        // Property data
        this.id = id;
        this.endereco = endereco;
        this.contatoProprietario = contatoProprietario;
        this.proprietarioCartorio = proprietarioCartorio;
        this.observacao = observacao;
        this.descricaoJudicializacao = descricaoJudicializacao;
        this.coincidenciaProprietario = contatoProprietario;
        this.proprietarioCampo = proprietarioCampo;
        this.planta = planta;
        this.rgi = rgi;
        this.valorDoAluguel = valorDoAluguel;
        this.judicializacao = judicializacao;
        this.longitude = longitude;
        this.latitude = latitude;
        this.plantaRegional = plantaRegional;
        this.usoDoImovel = usoDoImovel;
        this.valorDeVenda = valorDeVenda;


        // Finances data
        this.dsqfl = dsqfl;
        this.numero = numero;
        this.rua = rua;
        this.dsq = dsq;
        this.tipoEmpreendimento = tipoEmpreendimento;
        this.areaTotal = areaTotal;
        this.bairro = bairro;

        // Lot data
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

        // Licesing data
        this.nuProcesso = nuProcesso;
        this.nuLicenca = nuLicenca;
        this.ProcessoAberto2018 = ProcessoAberto2018;
    }

    // To return fields only related to a Property, without it's relations
    public PropertyResponseDTO(
            String endereco,
            String contatoProprietario,
            String proprietarioCartorio,
            String observacao,
            String descricaoJudicializacao,
            String proprietarioCampo,
            String planta,
            String rgi,
            String valorDoAluguel,
            String judicializacao,
            Double longitude,
            Double latitude,
            String plantaRegional,
            String usoDoImovel
    ) {
        this.endereco = endereco;
        this.contatoProprietario = contatoProprietario;
        this.proprietarioCartorio = proprietarioCartorio;
        this.observacao = observacao;
        this.descricaoJudicializacao = descricaoJudicializacao;
        this.proprietarioCampo = proprietarioCampo;
        this.planta = planta;
        this.rgi = rgi;
        this.valorDoAluguel = valorDoAluguel;
        this.judicializacao = judicializacao;
        this.longitude = longitude;
        this.latitude = latitude;
        this.plantaRegional = plantaRegional;
        this.usoDoImovel = usoDoImovel;
    }


}
