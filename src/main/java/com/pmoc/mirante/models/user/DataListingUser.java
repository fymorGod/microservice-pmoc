package com.pmoc.mirante.models.user;

public record DataListingUser(
        Long id,
        String name,
        String last_name,
        String contact,
        String company,
        String contact_company) {
    public DataListingUser(User user) {
        this(user.getId(), user.getName(), user.getLast_name(), user.getContact(), user.getCompany(), user.getContact_company());
    }

}
