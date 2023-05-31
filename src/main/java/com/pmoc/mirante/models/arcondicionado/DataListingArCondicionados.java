package com.pmoc.mirante.models.arcondicionado;

import com.pmoc.mirante.enums.Categories;
import com.pmoc.mirante.models.gerais.Gerais;

public record DataListingArCondicionados(Long id, Gerais gerais, int potencia, int tensao, Categories category) {
    public DataListingArCondicionados(ArCondicionado arCondicionado) {
        this(arCondicionado.getId(), arCondicionado.getGerais(), arCondicionado.getPotencia(), arCondicionado.getTensao(), arCondicionado.getCategory());
    }

}
