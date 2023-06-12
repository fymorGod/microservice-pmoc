package com.pmoc.mirante.dtos;

import com.pmoc.mirante.enums.Categories;
import com.pmoc.mirante.enums.TiposAntena;
import com.pmoc.mirante.models.gerais.DadosGerais;
import com.pmoc.mirante.models.transmissor.TransmissorModel;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.util.List;

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
        String gain,
        @NotNull
        List<TransmissorModel> transmissor
) {
}
