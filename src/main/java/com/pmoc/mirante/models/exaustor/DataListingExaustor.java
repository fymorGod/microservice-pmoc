package com.pmoc.mirante.models.exaustor;

import com.pmoc.mirante.enums.Categories;
import com.pmoc.mirante.models.gerais.Gerais;

public record DataListingExaustor(
        Long id,
        Gerais gerais,
        Categories category
) {
    public DataListingExaustor(Exaustor exaustor){
        this(exaustor.getId(), exaustor.getGerais(), exaustor.getCategory());
    }
}
