package com.recentro.recentro.models.finances;

public class FinancesResponseDTO {

    public String dsqfl;
    public String numero;
    public String rua;
    public String dsq;
    public String tipoEmpreendimento;
    public String areaTotal;
    public String bairro;

    public FinancesResponseDTO(
        String dsqfl,
        String numero,
        String rua,
        String dsq,
        String tipoEmpreendimento,
        String areaTotal,
        String bairro
    )
    {
        this.dsqfl = dsqfl;
        this.numero = numero;
        this.rua = rua;
        this.dsq = dsq;
        this.tipoEmpreendimento = tipoEmpreendimento;
        this.areaTotal = areaTotal;
        this.bairro = bairro;
    }
}
