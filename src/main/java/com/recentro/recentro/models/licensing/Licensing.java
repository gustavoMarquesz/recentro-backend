package com.recentro.recentro.models.licensing;

import com.recentro.recentro.models.PropertyInformation;
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

    public Licensing(PropertyInformation property) {
        this.nuProcesso = property.getLicensing().getNuProcesso();
        this.nuLicenca = property.getLicensing().getNuLicenca();
        this.ProcessoAberto2018 = property.getLicensing().getProcessoAberto2018();
    }

    public Licensing(LicensingDTO property) {
        this.nuProcesso = property.getNuProcesso();
        this.nuLicenca = property.getNuLicenca();
        this.ProcessoAberto2018 = property.getProcessoAberto2018();
    }

}
