package com.pmoc.mirante.dtos;

import com.pmoc.mirante.enums.Categories;
import com.pmoc.mirante.models.gerais.DadosGerais;
import com.pmoc.mirante.models.receptor.ReceptorModel;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.util.List;

public record ParabolicaDTO(
        @NotNull
        @Valid
        DadosGerais gerais,
        @NotNull
        Double diametro,
        @NotBlank
        String satelite,
        @NotNull
        List<ReceptorModel> receptor,
        @NotNull
        Categories category
) {
}
