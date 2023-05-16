package com.pmoc.mirante.nobreak;

import com.pmoc.mirante.enums.Categories;
import jakarta.validation.constraints.NotNull;

public record DataUpdatingNobreak(
        @NotNull
        Long id,
        String tag,
        String marca,
        String modelo,
        int tensao_entrada,
        int tensao_saida,
        Categories category
) {
}
