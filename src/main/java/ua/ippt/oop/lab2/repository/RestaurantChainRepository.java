package ua.ippt.oop.lab2.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import ua.ippt.oop.lab2.entity.RestaurantChain;

import java.util.List;

public interface RestaurantChainRepository extends JpaRepository<RestaurantChain,Integer> {

    @Query("SELECT r FROM RestaurantChain r WHERE r.id=?1")
    List<RestaurantChain> findById(Integer id);

    @Query("SELECT r FROM RestaurantChain r WHERE r.name=?1")
    List<RestaurantChain> findByName(String name);
}
