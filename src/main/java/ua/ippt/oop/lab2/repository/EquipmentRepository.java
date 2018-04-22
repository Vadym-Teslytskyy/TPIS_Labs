package ua.ippt.oop.lab2.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import ua.ippt.oop.lab2.entity.Equipment;

import java.util.List;

public interface EquipmentRepository extends JpaRepository<Equipment,Integer> {
    @Query("SELECT e FROM Equipment e WHERE e.name=?1")
    List<Equipment> findByName(String name);
}
