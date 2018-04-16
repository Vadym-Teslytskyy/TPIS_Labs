package ua.ippt.oop.lab2.repository;

import ua.ippt.oop.lab2.entity.Restaurant;

import java.util.List;

public interface RestaurantRepository extends Repository<Restaurant>{
    List<Restaurant> findById(Integer id);

    List<Restaurant> findByName(String name);

}
