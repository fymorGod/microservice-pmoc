package com.pmoc.mirante.models.torre;

import com.pmoc.mirante.enums.Categories;
import com.pmoc.mirante.enums.TiposTorre;
import com.pmoc.mirante.models.gerais.DadosGerais;
import jakarta.validation.constraints.NotNull;

public record DataUpdatingTorre(@NotNull
                                Long id,
                                DadosGerais gerais,
                                Boolean aterramento,
                                Double altura,
                                Categories category,
                                TiposTorre tipos_estrutura
                                ) {
}
