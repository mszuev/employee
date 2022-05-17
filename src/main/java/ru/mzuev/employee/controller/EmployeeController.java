package ru.mzuev.employee.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.mzuev.employee.model.Employee;
import ru.mzuev.employee.service.EmployeeService;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class EmployeeController {

    private EmployeeService employeeService;

    @Autowired
    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/")
    public String onUpdateReceived() {
        return "Ok";
    }

    @GetMapping("/getall")
    public String getAll(Model model) {
        List<Employee> employeeList = employeeService.readAll();
        model.addAttribute("employeeList", employeeList);
        model.addAttribute("employeeSize", employeeList.size());
        return "index";
    }


}
