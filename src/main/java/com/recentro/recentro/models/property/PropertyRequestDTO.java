package com.recentro.recentro.models.property;

import com.recentro.recentro.models.PropertyInformation;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class PropertyRequestDTO {

    // Property data
    String endereco;
    String contatoProprietario;
    String proprietarioCartorio;
    String coincidenciaProprietario;
    String observacao;
    String descricaoJudicializacao;
    String proprietarioCampo;
    String planta;
    String rgi;
    String valorDoAluguel;
    String valorDeVenda;
    String judicializacao;
    String longetude;
    String latitude;
    String plantaRegional;
    String usoDoImovel;
    String neighborhood;

    // Checkbox possible filter data
    String available;
    String occupied;
    String atConstruction;
    String abandoned;
    String cowork;
    String recifeAntigo;
    String santoAmaro;
    String saoJose;

    public PropertyRequestDTO(PropertyInformation property) {
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
}
