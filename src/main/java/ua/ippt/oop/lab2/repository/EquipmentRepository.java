package ua.ippt.oop.lab2.repository;

import ua.ippt.oop.lab2.entity.Equipment;

import java.util.List;

public interface EquipmentRepository extends Repository<Equipment>{
    List<Equipment> findById(Integer id);

    List<Equipment> findByName(String name);
}
