package com.recentro.recentro.models.finances;

import com.recentro.recentro.models.PropertyInformation;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class FinancesRequestDTO {

    public String dsqfl;
    private String numero;
    private String rua;
    private String dsq;
    private String tipoEmpreendimento;
    private String areaTotal;
    private String bairro;

    public FinancesRequestDTO(PropertyInformation property) {
        this.dsqfl = property.getFinances().getDsqfl();
        this.numero = property.getFinances().getNumero();
        this.rua = property.getFinances().getRua();
        this.dsq = property.getFinances().getDsq();
        this.tipoEmpreendimento = property.getFinances().getTipoEmpreendimento();
        this.areaTotal = property.getFinances().getAreaTotal();
        this.bairro = property.getFinances().getBairro();
    }
}
