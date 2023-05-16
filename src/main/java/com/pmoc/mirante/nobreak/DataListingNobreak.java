package com.pmoc.mirante.nobreak;

import com.pmoc.mirante.enums.Categories;

public record DataListingNobreak(
        Long id,
        String tag,
        String marca,
        String modelo,
        int tensao_entrada,
        int tensao_saida,
        Categories category
) {
    public DataListingNobreak(Nobreak nobreak){
        this(nobreak.getId(), nobreak.getTag(), nobreak.getMarca(), nobreak.getModelo(), nobreak.getTensao_entrada(), nobreak.getTensao_saida(), nobreak.getCategory());
    }
}
