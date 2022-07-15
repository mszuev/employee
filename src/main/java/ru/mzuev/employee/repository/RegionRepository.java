package ru.mzuev.employee.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.mzuev.employee.model.Region;

import java.util.List;

@Repository
public interface RegionRepository extends JpaRepository<Region, Long> {

    List<Region> findAll();
    Region findById(int id);
}
