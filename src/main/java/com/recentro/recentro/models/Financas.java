package com.recentro.recentro.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;


@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Financas {
    
    @Id
    @Column(name = "Finan_ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;
    public String dsqfl;
    private String numero;
    private String rua;
    private String dsq;
    private String tipoEmpreendimento;
    private String areaTotal;
    private String bairro;

    @OneToOne(fetch = FetchType.LAZY, mappedBy = "financas")
    private Imovel owner;

    public Financas(PropertyInformation property) {
        this.dsqfl = property.getFinancas().getDsqfl();
        this.numero = property.getFinancas().getNumero();
        this.rua = property.getFinancas().getRua();
        this.dsq = property.getFinancas().getDsq();
        this.tipoEmpreendimento = property.getFinancas().getTipoEmpreendimento();
        this.areaTotal = property.getFinancas().getAreaTotal();
        this.bairro = property.getFinancas().getBairro();
    }
}
