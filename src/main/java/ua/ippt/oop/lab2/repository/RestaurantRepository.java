package ua.ippt.oop.lab2.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import ua.ippt.oop.lab2.entity.Restaurant;

import java.util.List;

public interface RestaurantRepository extends JpaRepository<Restaurant,Integer> {
    @Query("SELECT r FROM Restaurant r WHERE r.name=?1")
    List<Restaurant> findByName(String name);

}
