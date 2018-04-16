package ua.ippt.oop.lab2.repository;
import ua.ippt.oop.lab2.entity.Country;

import java.util.List;

public interface CountryRepository extends Repository<Country> {

    List<Country> findById(Integer id);

    List<Country> findByName(String name);
}
