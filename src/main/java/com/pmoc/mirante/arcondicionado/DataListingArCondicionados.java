package com.pmoc.mirante.arcondicionado;

import com.pmoc.mirante.enums.Categories;
import com.pmoc.mirante.gerais.Gerais;

public record DataListingArCondicionados(Long id, Gerais gerais, int potencia, int tensao, Categories category) {
    public DataListingArCondicionados(ArCondicionado arCondicionado) {
        this(arCondicionado.getId(), arCondicionado.getGerais(), arCondicionado.getPotencia(), arCondicionado.getTensao(), arCondicionado.getCategory());
    }

}
