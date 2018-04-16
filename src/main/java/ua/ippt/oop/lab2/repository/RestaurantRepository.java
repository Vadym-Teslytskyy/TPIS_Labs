package ua.ippt.oop.lab2.repository;

import ua.ippt.oop.lab2.entity.Restaurant;

import java.util.Optional;

public interface RestaurantRepository extends Repository<Restaurant>{
    Optional<Restaurant> findById(Integer id);

    Optional<Restaurant> findByName(String name);

}
