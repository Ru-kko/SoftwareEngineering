package com.dentalia.dao;

import com.dentalia.domain.persistense.Schedule;

import java.util.UUID;

public class ScheduleRepository extends GenericPersistence<UUID, Schedule> {
    private static ScheduleRepository instance;

    private ScheduleRepository() {
        super(Schedule.class);
    }
    public static ScheduleRepository getInstance() {
        if (instance == null) {
            instance = new ScheduleRepository();
        }
        return instance;
    }
}
