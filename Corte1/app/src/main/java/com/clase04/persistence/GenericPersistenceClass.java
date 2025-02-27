package com.clase04.persistence;

import lombok.SneakyThrows;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import java.util.List;
import java.util.Optional;

abstract class GenericPersistenceClass<K, V> {
    private static final String PERSISTENCE_UNIT_NAME = "default";
    private final Class<V> valueType;
    protected final EntityManager em;
    private final EntityManagerFactory emf;

    protected GenericPersistenceClass(Class<V> entityClass) {
        this.valueType = entityClass;
        this.emf = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
        em = emf.createEntityManager();
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
        return em.createQuery("SELECT e FROM " + valueType.getSimpleName() + " e", valueType).getResultList();
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
