package com.pmoc.mirante.models.parabolica;

import com.pmoc.mirante.enums.Categories;
import com.pmoc.mirante.models.gerais.DadosGerais;
import com.pmoc.mirante.models.receptor.Receptor;
import jakarta.validation.constraints.NotNull;

import java.util.List;

public record DataUpdatingParabolica(

        @NotNull
        Long id,
        DadosGerais gerais,
        Double diametro,
        String satelite,
        List<Receptor> receptor,
        Categories category
) {
}
