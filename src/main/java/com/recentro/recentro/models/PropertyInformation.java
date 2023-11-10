package com.recentro.recentro.models;

import com.recentro.recentro.models.finances.Finances;
import com.recentro.recentro.models.finances.FinancesDTO;
import com.recentro.recentro.models.licensing.Licensing;
import com.recentro.recentro.models.licensing.LicensingDTO;
import com.recentro.recentro.models.lot.Lot;
import com.recentro.recentro.models.lot.LotDTO;
import com.recentro.recentro.models.property.PropertyDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PropertyInformation {
    PropertyDTO property;
    FinancesDTO finances;
    LotDTO lot;
    LicensingDTO licensing;
}
