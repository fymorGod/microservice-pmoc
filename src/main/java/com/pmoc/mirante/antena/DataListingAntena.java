package com.pmoc.mirante.antena;

import com.pmoc.mirante.enums.Categories;
import com.pmoc.mirante.enums.TiposAntena;
import com.pmoc.mirante.gerais.Gerais;
import com.pmoc.mirante.transmissor.Transmissor;

import java.util.List;

public record DataListingAntena(
        Long id,
        Gerais gerais,
        Double posicao_torre,
        Categories category,
        String vr,
        Double fendas,
        String gain,
        TiposAntena tipos_antena,
        List<Transmissor> transmissor
) {
    public DataListingAntena(Antena antena) {
        this(antena.getId(), antena.getGerais(), antena.getPosicao_torre(), antena.getCategory(), antena.getVr(), antena.getFendas(), antena.getGain(),antena.getTiposAntena(), antena.getTransmissor());
    }
}
