package com.pmoc.mirante.torre;

import com.pmoc.mirante.enums.Categories;
import com.pmoc.mirante.enums.TiposTorre;
import com.pmoc.mirante.gerais.Gerais;

public record DataListingTorre(Long id, Gerais gerais, double altura, boolean aterramento, Categories category, TiposTorre tipos_estrutura) {
    public DataListingTorre(Torre torre){
        this(torre.getId(), torre.getGerais(), torre.getAltura(), torre.getAterramento(), torre.getCategory(), torre.getTipos_estrutura());
    }
}
