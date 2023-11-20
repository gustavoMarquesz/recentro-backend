package com.recentro.recentro.models.property;

import com.recentro.recentro.models.PropertyInformation;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class PropertyDTO {

    public String endereco;
    public String contatoProprietario;
    private String proprietarioCartorio;
    private String coincidenciaProprietario;
    private String observacao;
    private String descricaoJudicializacao;
    private String proprietarioCampo;
    private String planta;
    private String rgi;
    private String valorDoAluguel;
    private String valorDeVenda;
    private String judicializacao;
    private String longetude;
    private String latitude;
    private String plantaRegional;
    private String usoDoImovel;

    public PropertyDTO(PropertyInformation property) {
        this.endereco = property.getProperty().getEndereco();
        this.contatoProprietario = property.getProperty().getContatoProprietario();
        this.proprietarioCartorio = property.getProperty().getProprietarioCartorio();
        this.coincidenciaProprietario = property.getProperty().getCoincidenciaProprietario();
        this.observacao = property.getProperty().getObservacao();
        this.descricaoJudicializacao = property.getProperty().getJudicializacao();
        this.proprietarioCampo = property.getProperty().getProprietarioCampo();
        this.planta = property.getProperty().getPlanta();
        this.rgi = property.getProperty().getRgi();
        this.valorDoAluguel = property.getProperty().getValorDoAluguel();
        this.valorDeVenda = property.getProperty().getValorDeVenda();
        this.judicializacao = property.getProperty().getJudicializacao();
        this.longetude = property.getProperty().getLongetude();
        this.latitude = property.getProperty().getLatitude();
        this.plantaRegional = property.getProperty().getPlantaRegional();
        this.usoDoImovel = property.getProperty().getUsoDoImovel();
    }

    public PropertyDTO(Property property) {
        this.endereco = property.getEndereco();
        this.contatoProprietario = property.getContatoProprietario();
        this.proprietarioCartorio = property.getProprietarioCartorio();
        this.coincidenciaProprietario = property.getCoincidenciaProprietario();
        this.observacao = property.getObservacao();
        this.descricaoJudicializacao = property.getJudicializacao();
        this.proprietarioCampo = property.getProprietarioCampo();
        this.planta = property.getPlanta();
        this.rgi = property.getRgi();
        this.valorDoAluguel = property.getValorDoAluguel();
        this.valorDeVenda = property.getValorDeVenda();
        this.judicializacao = property.getJudicializacao();
        this.longetude = property.getLongetude();
        this.latitude = property.getLatitude();
        this.plantaRegional = property.getPlantaRegional();
        this.usoDoImovel = property.getUsoDoImovel();
    }
}
