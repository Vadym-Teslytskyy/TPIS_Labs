package ua.ippt.oop.lab2.repository;

import ua.ippt.oop.lab2.entity.City;

import java.util.List;

public interface CityRepository extends Repository<City> {

    List<City> findById(Integer id);

    List<City> findByName(String name);
}
