package ru.mzuev.employee.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.mzuev.employee.model.Employee;
import ru.mzuev.employee.service.EmployeeService;
import org.springframework.stereotype.Controller;
import ru.mzuev.employee.service.HttpSession;

@Controller
public class EmployeeController {

    private EmployeeService employeeService;
    private HttpSession httpSession;

    @Autowired
    public EmployeeController(EmployeeService employeeService, HttpSession httpSession) {
        this.employeeService = employeeService;
        this.httpSession = httpSession;
    }


    @GetMapping("/map/{id}")
    public String getMap(@PathVariable long id, Model model) {
        Employee employee = employeeService.getById(id);
        model.addAttribute("employee", employee);
        return "map";
    }


//    @GetMapping("/")
//    public String test(Model model, @PageableDefault(size = 15) Pageable pageable) {
//
//        Page <Employee> page = employeeService.findAll(pageable);
//        model.addAttribute("page", page);
//        model.addAttribute("url", "/");
//        return "index";
//    }

    @GetMapping("/")
    public String test(@RequestParam(defaultValue = "0") int page,
                       @RequestParam(defaultValue = "15") int size,
                       Model model) {

        Page <Employee> employeePage = employeeService.findAll(
                PageRequest.of(page, size, Sort.by("full_name").and(Sort.by("first_name").ascending())));

        model.addAttribute("page", employeePage);
        model.addAttribute("url", "/");
        return "index";
    }


    @PostMapping("/search")
    public String search(@RequestParam String search,
                         @RequestParam(defaultValue = "0") int page,
                         @RequestParam(defaultValue = "15") int size,
                         Model model) {

        httpSession.setSearchQuery(search);
        Page <Employee> searchPage = employeeService.findByName(search,
                PageRequest.of(page, size, Sort.by("first_name").and(Sort.by("full_name"))));

        model.addAttribute("page", searchPage);
        model.addAttribute("employeeSize", searchPage.getTotalElements());
        model.addAttribute("url", "/search");
        return "search_new";
    }

    @GetMapping("/search")
    public String searchGet(@RequestParam(defaultValue = "0") int page,
                            @RequestParam(defaultValue = "15") int size,
                            Model model) {

        Page <Employee> searchPage = employeeService.findByName(httpSession.getSearchQuery(),
                PageRequest.of(page, size, Sort.by("first_name").and(Sort.by("full_name"))));

        model.addAttribute("page", searchPage);
        model.addAttribute("employeeSize", searchPage.getTotalElements());
        model.addAttribute("url", "/search");
        return "search_new";
    }
}
