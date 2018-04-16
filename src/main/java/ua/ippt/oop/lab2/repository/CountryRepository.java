package ua.ippt.oop.lab2.repository;
import ua.ippt.oop.lab2.entity.Country;

import java.util.Optional;

public interface CountryRepository extends Repository<Country> {

    Optional<Country> findById(Integer id);

    Optional<Country> findByName(String name);
}
