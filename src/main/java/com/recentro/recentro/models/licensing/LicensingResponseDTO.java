package com.recentro.recentro.models.licensing;

public class LicensingResponseDTO {

    public String nuProcesso;
    public String nuLicenca;
    public String ProcessoAberto2018;

    public LicensingResponseDTO(String nuProcesso, String nuLcenca, String ProcessoAberto2018) {
        this.nuProcesso = nuProcesso;
        this.nuLicenca = nuLicenca;
        this.ProcessoAberto2018 = ProcessoAberto2018;
    }
}
