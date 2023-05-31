package com.pmoc.mirante.models.secao;

import com.pmoc.mirante.enums.Status;
import jakarta.validation.constraints.NotNull;

public record DataUpdatingSecao(
        @NotNull
        Long id,
        String nome,
        String latitude,
        String longitude,
        String link_grafana,
        Double endereco,
        Status status
) {
}
