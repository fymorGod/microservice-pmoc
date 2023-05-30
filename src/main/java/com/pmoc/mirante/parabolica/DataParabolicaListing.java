package com.pmoc.mirante.parabolica;

import com.pmoc.mirante.enums.Categories;
import com.pmoc.mirante.gerais.Gerais;
import com.pmoc.mirante.receptor.Receptor;

import java.util.List;

public record DataParabolicaListing(
        Long id,
        Gerais gerais,
        Categories category,
        List<Receptor> receptor,
        Double diametro,
        String satelite
) {
    public DataParabolicaListing(Parabolica parabolica){
        this(parabolica.getId(), parabolica.getGerais(), parabolica.getCategory(), parabolica.getReceptor(), parabolica.getDiametro(), parabolica.getSatelite());
    }
}
