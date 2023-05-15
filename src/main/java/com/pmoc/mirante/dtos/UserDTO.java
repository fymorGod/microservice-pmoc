package com.pmoc.mirante.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

public record UserDTO(
    @NotBlank
    String name,
    @NotBlank
    String last_name,
    @NotBlank
    @Pattern(regexp = "\\d{4,11}")
    String contact,
    @NotBlank
    String company,
    @NotBlank
    String contact_company
) {
}
