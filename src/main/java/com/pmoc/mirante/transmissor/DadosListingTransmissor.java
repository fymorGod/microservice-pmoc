package com.pmoc.mirante.transmissor;

import com.pmoc.mirante.antena.Antena;
import com.pmoc.mirante.enums.Categories;
import com.pmoc.mirante.gerais.Gerais;
import com.pmoc.mirante.receptor.Receptor;

public record DadosListingTransmissor(
        Long id,
        Gerais gerais,
        Categories category,
        Antena antena,
        Receptor receptor,
        Double canal_fisico,
        Double canal_virutal,
        Double programmed
) {
    public DadosListingTransmissor(Transmissor transmissor){
        this(transmissor.getId(), transmissor.getGerais(), transmissor.getCategory(), transmissor.getAntena(), transmissor.getReceptor(), transmissor.getCanal_fisico(), transmissor.getCanal_virtual(), transmissor.getProgrammed());
    }
}
