package ua.ippt.oop.lab2.repository.impl;

import ua.ippt.oop.lab2.entity.City;
import ua.ippt.oop.lab2.entity.Country;
import ua.ippt.oop.lab2.repository.CountryRepository;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import java.util.List;

public class CountryRepositoryImpl implements CountryRepository {

    private EntityManagerFactory entityManagerFactory;

    public CountryRepositoryImpl(EntityManagerFactory entityManagerFactory) {
        this.entityManagerFactory = entityManagerFactory;
    }

    @Override
    public List<Country> findById(Integer id) {
        EntityManager em = entityManagerFactory.createEntityManager();
        List<Country> list = em.createQuery("SELECT c FROM Country c WHERE c.id=?1",Country.class)
                .setParameter(1, id)
                .getResultList();
        return list;
    }

    @Override
    public List<Country> findByName(String name) {
        EntityManager em = entityManagerFactory.createEntityManager();
        List<Country> list = em.createQuery("SELECT c FROM Country c WHERE c.name=?1",Country.class)
                .setParameter(1, name)
                .getResultList();
        return list;
    }

    @Override
    public void save(Country item) {
        EntityManager em = entityManagerFactory.createEntityManager();
        em.getTransaction().begin();
        em.persist(item);
        em.getTransaction().commit();
        em.close();
    }

    @Override
    public void update(Country item) {
        EntityManager em = entityManagerFactory.createEntityManager();
        em.getTransaction().begin();
        em.persist(item);
        em.getTransaction().commit();
        em.close();
    }

    @Override
    public void remove(Country item) {
        EntityManager em = entityManagerFactory.createEntityManager();
        em.getTransaction().begin();
        em.remove(item);
        em.getTransaction().commit();
        em.close();
    }

    @Override
    public List<Country> findAll() {
        return null;
    }
}
