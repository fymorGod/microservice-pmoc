package com.pmoc.mirante.models.parabolica;

import com.pmoc.mirante.enums.Categories;
import com.pmoc.mirante.models.gerais.Gerais;
import com.pmoc.mirante.models.receptor.Receptor;

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
