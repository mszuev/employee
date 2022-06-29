package ru.mzuev.employee.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import ru.mzuev.employee.model.Employee;

import java.util.List;

//import java.awt.print.Pageable;

@Repository
public interface EmployeeRepository extends JpaRepository <Employee, Long> {


    //    @Query("SELECT u FROM Employee u WHERE u.address_city = 'Пушкин' and u.first_name Like 'Мар%'")
//    List<Employee> findAll(Sort sort);
//    Page<Employee> findAlena(Pageable pageable);

    @Query("SELECT s FROM Employee s")
    Page<Employee> findAll(Pageable pageable);

    List<Employee> findByEmailContaining(String text);

    @Query("SELECT s FROM Employee s WHERE lower(s.first_name) like %?1% or lower(s.full_name) like %?1%")
    Page<Employee> findByName(String text, Pageable pageable);
}