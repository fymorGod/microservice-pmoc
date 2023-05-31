package com.pmoc.mirante.models.user;

import jakarta.validation.constraints.NotNull;

public record DataUpdatingUser(
        @NotNull
        Long id,
        String name,
        String last_name,
        String contact,
        String company,
        String contact_company
) {
}
