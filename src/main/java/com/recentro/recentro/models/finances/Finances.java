package com.recentro.recentro.models.finances;

import com.recentro.recentro.models.PropertyInformation;
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

    public Finances(PropertyInformation property) {
        this.dsqfl = property.getFinances().getDsqfl();
        this.numero = property.getFinances().getNumero();
        this.rua = property.getFinances().getRua();
        this.dsq = property.getFinances().getDsq();
        this.tipoEmpreendimento = property.getFinances().getTipoEmpreendimento();
        this.areaTotal = property.getFinances().getAreaTotal();
        this.bairro = property.getFinances().getBairro();
    }

    public Finances(FinancesDTO property) {
        this.dsqfl = property.getDsqfl();
        this.numero = property.getNumero();
        this.rua = property.getRua();
        this.dsq = property.getDsq();
        this.tipoEmpreendimento = property.getTipoEmpreendimento();
        this.areaTotal = property.getAreaTotal();
        this.bairro = property.getBairro();
    }
}
