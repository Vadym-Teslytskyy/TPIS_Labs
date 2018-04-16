package ua.ippt.oop.lab2.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import ua.ippt.oop.lab2.entity.Country;

import java.util.List;

public interface CountryRepository extends JpaRepository<Country,Integer> {

    @Query("SELECT c FROM Country c WHERE c.id=?1")
    List<Country> findById(Integer id);

    @Query("SELECT c FROM Country c WHERE c.name=?1")
    List<Country> findByName(String name);
}
