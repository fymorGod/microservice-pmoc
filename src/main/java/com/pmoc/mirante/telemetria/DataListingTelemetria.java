package com.pmoc.mirante.telemetria;

import com.pmoc.mirante.enums.Categories;

public record DataListingTelemetria(
        Long id,
        String tag,
        String marca,
        String modelo,
        Categories category
) {
    public DataListingTelemetria(Telemetria telemetria){
        this(telemetria.getId(), telemetria.getTag(), telemetria.getMarca(), telemetria.getModelo(), telemetria.getCategory());
    }
}
