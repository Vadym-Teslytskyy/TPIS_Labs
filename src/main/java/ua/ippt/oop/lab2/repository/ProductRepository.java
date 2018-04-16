package ua.ippt.oop.lab2.repository;

import ua.ippt.oop.lab2.entity.Product;

import java.util.Optional;

public interface ProductRepository extends Repository<Product> {
    Optional<Product> findById(Integer id);

    Optional<Product> findByName(String name);
}
