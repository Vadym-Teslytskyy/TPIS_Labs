package ua.ippt.oop.lab2.repository;

import ua.ippt.oop.lab2.entity.Staff;

import java.util.List;

public interface StaffRepository extends Repository<Staff>{
    List<Staff> findById(Integer id);

    List<Staff> findByName(String name);
}
