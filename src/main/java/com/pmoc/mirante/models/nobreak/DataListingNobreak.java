package com.pmoc.mirante.models.nobreak;

import com.pmoc.mirante.enums.Categories;
import com.pmoc.mirante.models.gerais.Gerais;

public record DataListingNobreak(
        Long id,
        Gerais gerais,
        int tensao_entrada,
        int tensao_saida,
        Categories category
) {
    public DataListingNobreak(Nobreak nobreak){
        this(nobreak.getId(), nobreak.getGerais(), nobreak.getTensao_entrada(), nobreak.getTensao_saida(), nobreak.getCategory());
    }
}
