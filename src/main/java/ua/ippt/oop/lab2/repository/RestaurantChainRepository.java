package ua.ippt.oop.lab2.repository;

import ua.ippt.oop.lab2.entity.RestaurantChain;

import java.util.List;

public interface RestaurantChainRepository extends Repository<RestaurantChain> {
    List<RestaurantChain> findById(Integer id);

    List<RestaurantChain> findByName(String name);
}
