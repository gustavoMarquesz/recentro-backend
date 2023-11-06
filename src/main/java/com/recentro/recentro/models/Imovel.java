package com.recentro.recentro.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Imovel {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;

    public String endereco;
    public String contatoProprietario;
    private String proprietarioCartorio;
    private String observacao;
    private String descricaoJudicializacao;
    private String proprietarioCampo;
    private String planta;
    private String rgi;
    private String valorDoAluguel;
    private String judicializacao;
    private String longetude;
    private String latitude;
    private String plantaRegional;
    private String usoDoImovel;

    public Imovel(PropertyInformation property) {
        this.endereco = property.getImovel().getEndereco();
        this.contatoProprietario = property.getImovel().getContatoProprietario();
        this.proprietarioCartorio = property.getImovel().getProprietarioCartorio();
        this.observacao = property.getImovel().getObservacao();
        this.descricaoJudicializacao = property.getImovel().getJudicializacao();
        this.proprietarioCampo = property.getImovel().getProprietarioCampo();
        this.planta = property.getImovel().getPlanta();
        this.rgi = property.getImovel().getRgi();
        this.valorDoAluguel = property.getImovel().getValorDoAluguel();
        this.judicializacao = property.getImovel().getJudicializacao();
        this.longetude = property.getImovel().getLongetude();
        this.latitude = property.getImovel().getLatitude();
        this.plantaRegional = property.getImovel().getPlantaRegional();
        this.usoDoImovel = property.getImovel().usoDoImovel;
    }
}
