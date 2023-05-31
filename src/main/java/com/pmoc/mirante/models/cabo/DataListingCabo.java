package com.pmoc.mirante.models.cabo;

import com.pmoc.mirante.enums.Categories;
import com.pmoc.mirante.enums.TiposCabo;
import com.pmoc.mirante.models.gerais.Gerais;

public record DataListingCabo(
        Long id,
        Gerais gerais,
        Categories category,
        TiposCabo tipos_cabo,
        Double tamanho
) {
    public DataListingCabo(Cabo cabo){
        this(cabo.getId(), cabo.getGerais(), cabo.getCategory(), cabo.getTipos_cabo(), cabo.getTamanho());
    }
}
