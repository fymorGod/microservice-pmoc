package com.pmoc.mirante.dtos;

import com.pmoc.mirante.enums.Status;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record StationDTO(
        @NotNull
        Status status,
        @NotBlank
        String nome,
        @NotBlank
        String latitude,
        @NotBlank
        String longitude,
        @NotBlank
        Double endereco,
        String link_grafana
) {
}
