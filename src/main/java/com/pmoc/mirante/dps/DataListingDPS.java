package com.pmoc.mirante.dps;

import com.pmoc.mirante.enums.Categories;
import com.pmoc.mirante.enums.ClasseDPS;
import com.pmoc.mirante.gerais.Gerais;

public record DataListingDPS(
        Long id,
        Gerais gerais,
        Categories category,
        ClasseDPS classe,
        int corrente_maxima
) {
    public DataListingDPS(DPS dps){
        this(dps.getId(), dps.getGerais(), dps.getCategory(), dps.getClasse(), dps.getCorrente_maxima());
    }
}
