package com.pmoc.mirante.models.combinador;

import com.pmoc.mirante.enums.Categories;
import com.pmoc.mirante.models.gerais.Gerais;

public record DataListingCombinador(
        Long id,
        Gerais gerais,
        Categories category
) {
    public DataListingCombinador(Combinador combinador){
        this(combinador.getId(), combinador.getGerais(), combinador.getCategory());
    }
}
