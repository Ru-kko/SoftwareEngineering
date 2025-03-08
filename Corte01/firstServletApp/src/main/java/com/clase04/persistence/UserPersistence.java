package com.clase04.persistence;

import com.clase04.domain.Usr;

public class UserPersistence extends  GenericPersistenceClass<Integer, Usr> {
    private static UserPersistence instance;
    private UserPersistence() {
        super(Usr.class);
    }

    public static UserPersistence getInstance() {
        if (instance == null) {
            return new UserPersistence();
        }
        return instance;
    }
}
