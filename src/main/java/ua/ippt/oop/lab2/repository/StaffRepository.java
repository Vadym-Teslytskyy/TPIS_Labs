package ua.ippt.oop.lab2.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import ua.ippt.oop.lab2.entity.Staff;

import java.util.List;

public interface StaffRepository extends JpaRepository<Staff,Integer> {
    @Query("SELECT s FROM Staff s WHERE s.fullName=?1")
    List<Staff> findByName(String name);
}
