package com.pmoc.mirante.models.switcher;

import com.pmoc.mirante.enums.Categories;
import com.pmoc.mirante.models.gerais.Gerais;

public record DataListingSwitch(
        Long id,
        Gerais gerais,
        int qtd_portas,
        Categories category
) {
    public DataListingSwitch(Switcher switcher){
        this(switcher.getId(), switcher.getGerais(), switcher.getQtd_portas(), switcher.getCategory());
    }
}
