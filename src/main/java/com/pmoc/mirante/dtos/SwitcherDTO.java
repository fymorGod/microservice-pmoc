package com.pmoc.mirante.dtos;

import com.pmoc.mirante.enums.Categories;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record SwitcherDTO(
        @NotBlank
        String tag,
        @NotBlank
        String marca,
        @NotBlank
        String modelo,
        @NotNull
        int qtd_portas,
        @NotNull
        Categories category
) {
}
