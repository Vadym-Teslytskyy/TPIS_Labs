package ua.ippt.oop.lab2.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import ua.ippt.oop.lab2.entity.City;

import java.util.List;

public interface CityRepository extends JpaRepository<City,Integer> {

    @Query("SELECT c FROM City c WHERE c.id=?1")
    List<City> findById(Integer id);

    @Query("SELECT c FROM City c WHERE c.name=?1")
    List<City> findByName(String name);
}
