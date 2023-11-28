package com.recentro.recentro.models.property;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Data
@NoArgsConstructor
public class PropertyRequestDTO {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Property data
    private String endereco;
    private String contatoProprietario;
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
    private Double longitude;
    private Double latitude;
    private String plantaRegional;
    private String usoDoImovel;
    private String neighborhood;

    // Checkbox possible filter data
    String available;
    String occupied;
    String atConstruction;
    String abandoned;
    String cowork;
    String recifeAntigo;
    String santoAmaro;
    String saoJose;

    public PropertyRequestDTO(Property property) { // Corrigido para aceitar um objeto Property, não PropertyRequestDTO
        this.endereco = property.getEndereco();
        this.contatoProprietario = property.getContatoProprietario();
        this.proprietarioCartorio = property.getProprietarioCartorio();
        this.coincidenciaProprietario = property.getCoincidenciaProprietario();
        this.observacao = property.getObservacao();
        this.descricaoJudicializacao = property.getDescricaoJudicializacao();
        this.proprietarioCampo = property.getProprietarioCampo();
        this.planta = property.getPlanta();
        this.rgi = property.getRgi();
        this.valorDoAluguel = property.getValorDoAluguel();
        this.valorDeVenda = property.getValorDeVenda();
        this.judicializacao = property.getJudicializacao();
        this.longitude = property.getLongitude();
        this.latitude = property.getLatitude();
        this.plantaRegional = property.getPlantaRegional();
        this.usoDoImovel = property.getUsoDoImovel();
    }
}
