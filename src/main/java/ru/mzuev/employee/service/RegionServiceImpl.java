package ru.mzuev.employee.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.mzuev.employee.model.Region;
import ru.mzuev.employee.repository.RegionRepository;
import java.util.List;

@Service
public class RegionServiceImpl implements RegionService {

    private RegionRepository regionRepository;

    @Autowired
    public RegionServiceImpl(RegionRepository regionRepository) {
        this.regionRepository = regionRepository;
    }

    @Override
    public List<Region> findAll() {
        return regionRepository.findAll();
    }

    @Override
    public Region findById(int id) {
        return regionRepository.findById(id);
    }
}