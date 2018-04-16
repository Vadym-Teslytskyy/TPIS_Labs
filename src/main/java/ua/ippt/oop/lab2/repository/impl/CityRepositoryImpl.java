package ua.ippt.oop.lab2.repository.impl;

import ua.ippt.oop.lab2.entity.City;
import ua.ippt.oop.lab2.repository.CityRepository;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import java.util.List;

public class CityRepositoryImpl implements CityRepository {

    private EntityManagerFactory entityManagerFactory;

    public CityRepositoryImpl(EntityManagerFactory entityManagerFactory) {
        this.entityManagerFactory = entityManagerFactory;
    }

    @Override
    public List<City> findById(Integer id) {
        EntityManager em = entityManagerFactory.createEntityManager();
        List<City> list = em.createQuery("SELECT c FROM City c WHERE c.id=?1",City.class)
				.setParameter(1, id)
				.getResultList();
        return list;
    }

    @Override
    public List<City> findByName(String name) {
        EntityManager em = entityManagerFactory.createEntityManager();
        List<City> list = em.createQuery("SELECT c FROM City c WHERE c.name=?1",City.class)
                .setParameter(1, name)
                .getResultList();
        return list;
    }

    @Override
    public void save(City item) {
        EntityManager em = entityManagerFactory.createEntityManager();
        em.getTransaction().begin();
        em.persist(item);
        em.getTransaction().commit();
        em.close();
    }

    @Override
    public void update(City item) {
        EntityManager em = entityManagerFactory.createEntityManager();
        em.getTransaction().begin();
        em.persist(item);
        em.getTransaction().commit();
        em.close();
    }

    @Override
    public void remove(City item) {
        EntityManager em = entityManagerFactory.createEntityManager();
        em.getTransaction().begin();
        em.remove(item);
        em.getTransaction().commit();
        em.close();
    }

    @Override
    public List<City> findAll() {
        EntityManager em = entityManagerFactory.createEntityManager();
        List<City> list = em.createQuery("SELECT c FROM City c",City.class)
                .getResultList();
        return list;
    }
}
