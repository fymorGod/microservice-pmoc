package com.pmoc.mirante.dtos;

import com.pmoc.mirante.enums.Categories;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record ArCondicionadoDTO(
        @NotBlank
        String tag,
        @NotBlank
        String modelo,
        @NotBlank
        String marca,
        @NotNull
        int potencia,
        @NotNull
        int tensao,
        @NotNull
        Categories category
) {
}
