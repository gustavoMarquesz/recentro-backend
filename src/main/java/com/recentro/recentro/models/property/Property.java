package com.recentro.recentro.models.property;

import com.recentro.recentro.models.finances.Finances;
import com.recentro.recentro.models.licensing.Licensing;
import com.recentro.recentro.models.lot.Lot;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Property {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;

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

    @OneToOne
    @JoinColumn(name = "finances_id")
    private Finances finances;

    @OneToOne
    @JoinColumn(name = "licensing_id")
    private Licensing licensing;

    @OneToOne
    @JoinColumn(name = "lot_id")
    private Lot lot;
    public Property(PropertyRequestDTO property) {
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

    public Property(
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
        String longetude,
        String latitude,
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
        this.longetude = longetude;
        this.latitude = latitude;
        this.plantaRegional = plantaRegional;
        this.usoDoImovel = usoDoImovel;
    }
}
