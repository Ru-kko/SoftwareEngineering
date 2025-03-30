package com.dentalia.dto;

import java.util.Optional;
import java.util.UUID;

import com.dentalia.domain.User;

import lombok.SneakyThrows;

public class UserDto extends GenericPersistence<UUID, User> {
    private static UserDto instance;
    private UserDto() {
        super(User.class);
    }

    public static UserDto getInstance() {
        if (instance == null) {
            instance = new UserDto();
        }
        return instance;
    }

    @SneakyThrows
    public Optional<User> findByEmail(String email) {
        var query = super.em.createQuery("SELECT u FROM usr u WHERE email = :email", User.class);
        query.setParameter("email", email);

        return query.getResultList().stream().findFirst();
    }
}