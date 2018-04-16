package ua.ippt.oop.lab2.repository;

import ua.ippt.oop.lab2.entity.Product;

import java.util.List;

public interface ProductRepository extends Repository<Product> {
    List<Product> findById(Integer id);

    List<Product> findByName(String name);
}
