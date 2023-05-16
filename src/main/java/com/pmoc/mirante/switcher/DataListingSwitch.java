package com.pmoc.mirante.switcher;

import com.pmoc.mirante.enums.Categories;

public record DataListingSwitch(
        Long id,
        String tag,
        String marca,
        String modelo,
        int qtd_portas,
        Categories category
) {
    public DataListingSwitch(Switcher switcher){
        this(switcher.getId(), switcher.getTag(), switcher.getMarca(), switcher.getModelo(), switcher.getQtd_portas(), switcher.getCategory());
    }
}
