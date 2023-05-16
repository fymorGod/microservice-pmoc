package com.pmoc.mirante.dtos;

import com.pmoc.mirante.enums.Categories;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record ExaustorDTO(
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
