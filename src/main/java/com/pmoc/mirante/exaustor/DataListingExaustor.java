package com.pmoc.mirante.exaustor;

import com.pmoc.mirante.enums.Categories;

public record DataListingExaustor(
        Long id,
        String tag,
        String marca,
        String modelo,
        Categories category
) {
    public DataListingExaustor(Exaustor exaustor){
        this(exaustor.getId(), exaustor.getTag(), exaustor.getMarca(), exaustor.getModelo(), exaustor.getCategory());
    }
}
