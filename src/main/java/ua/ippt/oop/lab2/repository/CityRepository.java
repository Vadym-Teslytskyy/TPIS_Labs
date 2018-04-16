package ua.ippt.oop.lab2.repository;

import ua.ippt.oop.lab2.entity.City;

import java.util.Optional;

public interface CityRepository extends Repository<City> {

    Optional<City> findById(Integer id);

    Optional<City> findByName(String name);
}
