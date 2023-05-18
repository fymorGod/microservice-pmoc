package com.pmoc.mirante.torre;

import com.pmoc.mirante.enums.Categories;
import com.pmoc.mirante.enums.TiposTorre;
import com.pmoc.mirante.gerais.DadosGerais;
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
