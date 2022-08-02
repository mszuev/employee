package ru.mzuev.employee.service;

import ru.mzuev.employee.model.Region;
import java.util.List;

public interface RegionService {
    List<Region> findAll();
    Region findById(int id);
}
