package ru.mzuev.employee.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import ru.mzuev.employee.model.Employee;

import java.util.Collection;
import java.util.List;

public interface EmployeeService {
//    List<Employee> readAll();
    void save(Employee employee);
    Employee getById (long id);
    boolean isExist (long id);
    void delete (long id);
    void deleteAll();
//    Page<Employee> findAlena(Pageable pageable);
    Page<Employee> findAll(Pageable pageable);
    List<Employee> findByEmailContaining(String text);
    Page<Employee> findByName(String text, Pageable pageable);

}
