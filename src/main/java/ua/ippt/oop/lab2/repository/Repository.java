package ua.ippt.oop.lab2.repository;

import java.util.List;
import java.util.Optional;

public interface Repository<T> {
    void save(T item);

    void update(T item);

    void remove(T item);

    List<T> findAll();
}
