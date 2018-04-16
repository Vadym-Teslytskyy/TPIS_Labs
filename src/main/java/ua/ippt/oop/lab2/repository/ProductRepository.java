package ua.ippt.oop.lab2.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import ua.ippt.oop.lab2.entity.Product;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product,Integer> {

    @Query("SELECT p FROM Product p WHERE p.id=?1")
    List<Product> findById(Integer id);

    @Query("SELECT p FROM Product p WHERE p.name=?1")
    List<Product> findByName(String name);
}
