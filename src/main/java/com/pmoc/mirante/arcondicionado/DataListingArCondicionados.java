package com.pmoc.mirante.arcondicionado;

import com.pmoc.mirante.enums.Categories;

public record DataListingArCondicionados(Long id, String tag, String marca, String modelo, int potencia, int tensao, Categories category) {
    public DataListingArCondicionados(ArCondicionado arCondicionado) {
        this(arCondicionado.getId(), arCondicionado.getTag(), arCondicionado.getMarca(), arCondicionado.getModelo(), arCondicionado.getPotencia(), arCondicionado.getTensao(), arCondicionado.getCategory());
    }

}
