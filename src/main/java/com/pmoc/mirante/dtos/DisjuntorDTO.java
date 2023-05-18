package com.pmoc.mirante.dtos;

import com.pmoc.mirante.enums.Categories;
import com.pmoc.mirante.gerais.DadosGerais;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record DisjuntorDTO(
        @NotNull
        @Valid
        DadosGerais gerais,
        @NotBlank
        int corrente_maxima,
        @NotNull
        Categories category
) {

}
