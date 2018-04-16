package ua.ippt.oop.lab2.repository;

import ua.ippt.oop.lab2.entity.Staff;

import java.util.Optional;

public interface StaffRepository extends Repository<Staff>{
    Optional<Staff> findById(Integer id);

    Optional<Staff> findByName(String name);
}
