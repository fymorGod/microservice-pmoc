package com.pmoc.mirante.receptor;

import com.pmoc.mirante.enums.Categories;
import com.pmoc.mirante.gerais.Gerais;
import com.pmoc.mirante.parabolica.Parabolica;

public record DataListingReceptor(
        Long id,
        Gerais gerais,
        Categories category,
        int symbol_rate,
        int frequency,
        Parabolica parabolica
) {
    public DataListingReceptor(Receptor receptor){
        this(receptor.getId(), receptor.getGerais(), receptor.getCategory(), receptor.getSymbol_rate(), receptor.getFrequency(), receptor.getParabolica());
    }
}
