package com.pmoc.mirante.antena;

import com.pmoc.mirante.enums.Categories;
import com.pmoc.mirante.enums.TiposAntena;
import com.pmoc.mirante.gerais.DadosGerais;
import jakarta.validation.constraints.NotNull;

public record DataUpdatingAntena(
        @NotNull
        Long id,
        DadosGerais gerais,
        Categories category,
        TiposAntena tipos_antena,
        String gain,
        Double fendas,
        Double posicao_torre,
        String vr
) {
}
