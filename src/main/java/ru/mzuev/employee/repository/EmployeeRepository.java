package ru.mzuev.employee.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.mzuev.employee.model.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository <Employee, Long> {
}
