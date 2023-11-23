package com.recentro.recentro.models.finances;

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
public class Finances {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;
    public String dsqfl;
    private String numero;
    private String rua;
    private String dsq;
    private String tipoEmpreendimento;
    private String areaTotal;
    private String bairro;

    @OneToOne(fetch = FetchType.LAZY, mappedBy = "finances")
    private Property property;

    public Finances(FinancesRequestDTO property) {
        this.dsqfl = property.getDsqfl();
        this.numero = property.getNumero();
        this.rua = property.getRua();
        this.dsq = property.getDsq();
        this.tipoEmpreendimento = property.getTipoEmpreendimento();
        this.areaTotal = property.getAreaTotal();
        this.bairro = property.getBairro();
    }
}
