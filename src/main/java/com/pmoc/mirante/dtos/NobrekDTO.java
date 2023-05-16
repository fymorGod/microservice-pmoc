package com.pmoc.mirante.dtos;

import com.pmoc.mirante.enums.Categories;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record NobrekDTO(
        @NotBlank
        String tag,
        @NotBlank
        String marca,
        @NotBlank
        String modelo,
        @NotBlank
        int tensao_entrada,
        @NotBlank
        int tensao_saida,
        @NotNull
        Categories category
) {
}
