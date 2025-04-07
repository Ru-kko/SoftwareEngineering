package com.dentalia.dao;

import java.util.Optional;
import java.util.UUID;

import com.dentalia.domain.persistense.User;

import lombok.SneakyThrows;

public class UserRepository extends GenericPersistence<UUID, User> {
    private static UserRepository instance;
    private UserRepository() {
        super(User.class);
    }

    public static UserRepository getInstance() {
        if (instance == null) {
            instance = new UserRepository();
        }
        return instance;
    }

    @SneakyThrows
    public Optional<User> findByEmail(String email) {
        var query = super.em.createQuery("SELECT u FROM usr u WHERE email = :email", User.class);
        query.setParameter("email", email);
        query.setMaxResults(1);

        return Optional.ofNullable(query.getSingleResult());
    }
}