package ru.mzuev.employee.service;

import ru.mzuev.employee.model.Employee;

import java.util.List;

public interface EmployeeService {
    List<Employee> readAll();
    void save(Employee employee);
    Employee getById (long id);
    boolean isExist (long id);
    void delete (long id);
    void deleteAll();
}
