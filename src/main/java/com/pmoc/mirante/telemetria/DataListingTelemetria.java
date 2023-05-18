package com.pmoc.mirante.telemetria;

import com.pmoc.mirante.enums.Categories;
import com.pmoc.mirante.gerais.Gerais;

public record DataListingTelemetria(
        Long id,
        Gerais gerais,
        Categories category
) {
    public DataListingTelemetria(Telemetria telemetria){
        this(telemetria.getId(), telemetria.getGerais(), telemetria.getCategory());
    }
}
