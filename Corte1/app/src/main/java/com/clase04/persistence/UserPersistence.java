package com.clase04.persistence;

import com.clase04.domain.Usr;

public class UserPersistence extends  GenericPersistenceClass<Integer, Usr> {
    public UserPersistence() {
        super(Usr.class);
    }
}
