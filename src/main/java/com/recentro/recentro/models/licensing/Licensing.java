package com.recentro.recentro.models.licensing;

import com.recentro.recentro.models.property.Property;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Licensing {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;
    private String nuProcesso;
    private String nuLicenca;
    private String ProcessoAberto2018;

    @OneToOne(fetch = FetchType.LAZY, mappedBy = "licensing")
    private Property property;

    public Licensing(LicensingRequestDTO property) {
        this.nuProcesso = property.getNuProcesso();
        this.nuLicenca = property.getNuLicenca();
        this.ProcessoAberto2018 = property.getProcessoAberto2018();
    }

}
