package ru.mzuev.employee.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import ru.mzuev.employee.model.Employee;
import ru.mzuev.employee.repository.EmployeeRepository;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService{

    private EmployeeRepository employeeRepository;

    @Autowired
    public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }


//    @Override
//    public List<Employee> readAll() {
////        return employeeRepository.findAll(Sort.by(Sort.Order.asc("full_name")));
//        return employeeRepository.findAll();
//    }

    @Override
    public Page<Employee> findAll(Pageable pageable) {
        return employeeRepository.findAll(pageable);
    }

    @Override
    public void save(Employee employee) {
        employeeRepository.save(employee);
    }

    @Override
    public Employee getById(long id) {
        return employeeRepository.getById(id);
    }

    @Override
    public boolean isExist(long id) {
        return employeeRepository.existsById(id);
    }

    @Override
    public void delete(long id) {
        employeeRepository.deleteById(id);
    }

    @Override
    public void deleteAll() {
        employeeRepository.deleteAll();
    }

//    @Override
//    public Page<Employee> findAlena(Pageable pageable) {
//        return employeeRepository.findAlena(pageable);
//    }

    @Override
    public List<Employee> findByEmailContaining(String text) {
        return employeeRepository.findByEmailContaining(text);
    }

    @Override
    public Page<Employee> findByName(String text, Pageable pageable) {
        return employeeRepository.findByName(text, pageable);
    }
}
