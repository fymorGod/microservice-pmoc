package com.pmoc.mirante.disjuntor;

import com.pmoc.mirante.enums.Categories;
import com.pmoc.mirante.gerais.Gerais;

public record DataListingDisjuntor(Long id, Gerais gerais, Categories category, int corrente_maxima) {
    public DataListingDisjuntor(Disjuntor disjuntor) {
        this(disjuntor.getId(), disjuntor.getGerais(), disjuntor.getCategory(), disjuntor.getCorrente_maxima());
    }
}
