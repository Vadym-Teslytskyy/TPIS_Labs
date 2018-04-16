package ua.ippt.oop.lab2.repository;

import ua.ippt.oop.lab2.entity.Equipment;

import java.util.Optional;

public interface EquipmentRepository extends Repository<Equipment>{
    Optional<Equipment> findById(Integer id);

    Optional<Equipment> findByName(String name);
}
