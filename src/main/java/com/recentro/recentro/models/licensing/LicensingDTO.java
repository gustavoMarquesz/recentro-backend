package com.recentro.recentro.models.licensing;

import com.recentro.recentro.models.PropertyInformation;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class LicensingDTO {

    private String nuProcesso;
    private String nuLicenca;
    private String ProcessoAberto2018;

    public LicensingDTO(PropertyInformation property) {
        this.nuProcesso = property.getLicensing().getNuProcesso();
        this.nuLicenca = property.getLicensing().getNuLicenca();
        this.ProcessoAberto2018 = property.getLicensing().getProcessoAberto2018();
    }
}
