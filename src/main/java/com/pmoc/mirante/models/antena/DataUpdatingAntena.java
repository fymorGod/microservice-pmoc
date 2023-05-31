package com.pmoc.mirante.models.antena;

import com.pmoc.mirante.enums.Categories;
import com.pmoc.mirante.enums.TiposAntena;
import com.pmoc.mirante.models.gerais.DadosGerais;
import com.pmoc.mirante.models.transmissor.Transmissor;
import jakarta.validation.constraints.NotNull;

import java.util.List;

public record DataUpdatingAntena(
        @NotNull
        Long id,
        DadosGerais gerais,
        Categories category,
        TiposAntena tipos_antena,
        String gain,
        Double fendas,
        Double posicao_torre,
        String vr,
        List<Transmissor> transmissor
) {
}
