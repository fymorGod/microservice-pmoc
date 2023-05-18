package com.pmoc.mirante.exaustor;

import com.pmoc.mirante.enums.Categories;
import com.pmoc.mirante.gerais.Gerais;

public record DataListingExaustor(
        Long id,
        Gerais gerais,
        Categories category
) {
    public DataListingExaustor(Exaustor exaustor){
        this(exaustor.getId(), exaustor.getGerais(), exaustor.getCategory());
    }
}
