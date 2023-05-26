package com.pmoc.mirante.cabo;

import com.pmoc.mirante.enums.Categories;
import com.pmoc.mirante.enums.TiposCabo;
import com.pmoc.mirante.gerais.Gerais;

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
