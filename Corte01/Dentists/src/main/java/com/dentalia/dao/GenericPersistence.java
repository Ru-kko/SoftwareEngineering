package com.dentalia.dao;

import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import lombok.SneakyThrows;
import lombok.extern.java.Log;

import java.util.List;
import java.util.Optional;

@Log
abstract class GenericPersistence<K, V> {
    private static final String PERSISTENCE_UNIT_NAME = "default";
    private final Class<V> valueType;
    private final String entityName;
    protected final EntityManager em;
    private final EntityManagerFactory emf;

    protected GenericPersistence(Class<V> entityClass) {
        this.valueType = entityClass;
        this.emf = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
        em = emf.createEntityManager();

        Entity annotation = entityClass.getAnnotation(Entity.class);
        this.entityName = (annotation != null && !annotation.name().isEmpty())
                ? annotation.name()
                : entityClass.getSimpleName();
    }

    @SneakyThrows
    public void save(V entity) {
        em.getTransaction().begin();
        em.persist(entity);
        em.getTransaction().commit();
    }

    @SneakyThrows
    public Optional<V> findById(K id) {
        return Optional.ofNullable(em.find(valueType, id));
    }

    @SneakyThrows
    public List<V> getAll() {
        String query = "SELECT t FROM " + entityName + " t";
        try {
            return em.createQuery(query, valueType).getResultList();
        } catch (Exception e) {
            log.throwing("GenericPersistence", "getAll", e);
        }
        return List.of();
    }

    @SneakyThrows
    public void update(V entity) {
        em.getTransaction().begin();
        em.merge(entity);
        em.getTransaction().commit();
    }

    @SneakyThrows
    public void deleteById(K id) {
        em.getTransaction().begin();
        V entity = em.find(valueType, id);
        if (entity != null) {
            em.remove(entity);
        }
        em.getTransaction().commit();
    }

    public void close() {
        if (emf != null && emf.isOpen()) {
            emf.close();
        }
    }
}
