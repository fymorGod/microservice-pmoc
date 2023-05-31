package com.pmoc.mirante.models.disjuntor;

import com.pmoc.mirante.enums.Categories;
import com.pmoc.mirante.models.gerais.Gerais;

public record DataListingDisjuntor(Long id, Gerais gerais, Categories category, int corrente_maxima) {
    public DataListingDisjuntor(Disjuntor disjuntor) {
        this(disjuntor.getId(), disjuntor.getGerais(), disjuntor.getCategory(), disjuntor.getCorrente_maxima());
    }
}
