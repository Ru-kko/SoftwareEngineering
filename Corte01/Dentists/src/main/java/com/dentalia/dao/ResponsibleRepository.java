package com.dentalia.dao;

import com.dentalia.domain.persistense.Responsible;

import java.util.UUID;

public class ResponsibleRepository extends GenericPersistence<UUID, Responsible> {
    private static ResponsibleRepository instance;
    private ResponsibleRepository() {
        super(Responsible.class);
    }

    public static ResponsibleRepository getInstance() {
        if (instance == null) {
            instance = new ResponsibleRepository();
        }
        return instance;
    }
}
