package ua.ippt.oop.lab2.repository;

import ua.ippt.oop.lab2.entity.RestaurantChain;

import java.util.Optional;

public interface RestaurantChainRepository extends Repository<RestaurantChain> {
    Optional<RestaurantChain> findById(Integer id);

    Optional<RestaurantChain> findByName(String name);
}
