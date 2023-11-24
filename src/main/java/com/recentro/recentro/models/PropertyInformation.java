package com.recentro.recentro.models;

import com.recentro.recentro.models.finances.FinancesRequestDTO;
import com.recentro.recentro.models.licensing.LicensingRequestDTO;
import com.recentro.recentro.models.lot.LotRequestDTO;
import com.recentro.recentro.models.property.PropertyRequestDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PropertyInformation {
    PropertyRequestDTO property;
    FinancesRequestDTO finances;
    LotRequestDTO lot;
    LicensingRequestDTO licensing;
}
