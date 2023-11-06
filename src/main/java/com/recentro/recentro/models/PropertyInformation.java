package com.recentro.recentro.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PropertyInformation {
    Imovel imovel;
    Financas financas;
    Lote lote;
    Licenciamento licenciamento;
}
