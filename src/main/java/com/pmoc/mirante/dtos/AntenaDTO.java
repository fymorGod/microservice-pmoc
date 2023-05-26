package com.pmoc.mirante.dtos;

import com.pmoc.mirante.enums.Categories;
import com.pmoc.mirante.enums.TiposAntena;
import com.pmoc.mirante.gerais.DadosGerais;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record AntenaDTO(
        @NotNull
        @Valid
        DadosGerais gerais,
        @NotNull
        Categories category,
        @NotNull
        TiposAntena tipos_antena,
        @NotBlank
        String vr,
        @NotBlank
        Double fendas,
        @NotBlank
        Double posicao_torre,
        @NotBlank
        String gain
) {
}
