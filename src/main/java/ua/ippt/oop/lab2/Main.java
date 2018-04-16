package ua.ippt.oop.lab2;

import ua.ippt.oop.lab2.entity.City;
import ua.ippt.oop.lab2.entity.Country;
import ua.ippt.oop.lab2.entity.RestaurantChain;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.time.LocalDate;
import java.util.Collections;

public class Main {
    private static EntityManager em;

    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("primary");
        em = emf.createEntityManager();
        em.getTransaction().begin();
        persistEntities();
        em.getTransaction().commit();
        selectFromDatabase();
        emf.close();
    }

    private static void persistEntities() {
        for (int i = 0; i < 3; i++) {
            Country country = new Country("country" + i);
            City city = new City("city" + i);
            RestaurantChain restaurantChain = new RestaurantChain("rc" + i, LocalDate.now());
            city.setCountry(country);
            country.setCities(Collections.singleton(city));
            country.setRestaurantChain(restaurantChain);
            restaurantChain.setCountries(Collections.singletonList(country));
            em.persist(restaurantChain);
            em.persist(country);
            em.persist(city);
        }
    }

    private static void selectFromDatabase() {
        RestaurantChain restaurantChain = em.find(RestaurantChain.class, 1);
        System.out.println(restaurantChain.getName());
        System.out.println(restaurantChain.getCountries().get(0).getName());
    }
}
