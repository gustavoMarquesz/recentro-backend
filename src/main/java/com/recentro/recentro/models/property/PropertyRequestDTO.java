package com.recentro.recentro.models.property;

import com.recentro.recentro.models.PropertyInformation;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class PropertyRequestDTO {

    private String endereco;
    private String contatoProprietario;
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

    public PropertyRequestDTO(PropertyInformation property) {
        this.endereco = property.getProperty().getEndereco();
        this.contatoProprietario = property.getProperty().getContatoProprietario();
        this.proprietarioCartorio = property.getProperty().getProprietarioCartorio();
        this.observacao = property.getProperty().getObservacao();
        this.descricaoJudicializacao = property.getProperty().getJudicializacao();
        this.proprietarioCampo = property.getProperty().getProprietarioCampo();
        this.planta = property.getProperty().getPlanta();
        this.rgi = property.getProperty().getRgi();
        this.valorDoAluguel = property.getProperty().getValorDoAluguel();
        this.judicializacao = property.getProperty().getJudicializacao();
        this.longetude = property.getProperty().getLongetude();
        this.latitude = property.getProperty().getLatitude();
        this.plantaRegional = property.getProperty().getPlantaRegional();
        this.usoDoImovel = property.getProperty().getUsoDoImovel();
    }
}
