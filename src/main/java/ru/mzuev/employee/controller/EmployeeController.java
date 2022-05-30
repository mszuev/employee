package ru.mzuev.employee.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.mzuev.employee.model.Employee;
import ru.mzuev.employee.service.EmployeeService;
import org.springframework.stereotype.Controller;

import java.util.ArrayList;
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
        List<Employee> list = employeeService.readAll();
        List<Employee> employeeList = new ArrayList<>();
        
        for (int i = 0; i < 10; i++) {
            employeeList.add(list.get(i));
        }

        System.out.println(employeeList);
        
        model.addAttribute("employeeList", employeeList);
        model.addAttribute("employeeSize", employeeList.size());
        return "index";
    }

    @GetMapping("/map/{id}")
    public String getMap(@PathVariable long id, Model model) {
        Employee employee = employeeService.getById(id);
        model.addAttribute("employee", employee);
        return "map";
    }


    @GetMapping("/test")
    public String test() {
        return "test";
    }

}
