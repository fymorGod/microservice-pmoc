package com.pmoc.mirante.dtos;

import com.pmoc.mirante.enums.Categories;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record TelemetriaDTO(
        @NotBlank
        String tag,
        @NotBlank
        String marca,
        @NotBlank
        String modelo,
        @NotNull
        Categories category
) {
}
