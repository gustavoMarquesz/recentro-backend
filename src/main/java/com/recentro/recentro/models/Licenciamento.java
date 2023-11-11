package com.recentro.recentro.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Licenciamento {

    @Id
    @Column(name = "Licen_ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;
    private String nuProcesso;
    private String nuLicenca;
    private String ProcessoAberto2018;

    @OneToOne(fetch = FetchType.LAZY, mappedBy = "licenciamento")
    private Imovel owner;

    public Licenciamento(PropertyInformation property) {
        this.nuProcesso = property.getLicenciamento().getNuProcesso();
        this.nuLicenca = property.getLicenciamento().getNuLicenca();
        this.ProcessoAberto2018 = property.getLicenciamento().getProcessoAberto2018();
    }

}
