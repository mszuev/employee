package ru.mzuev.employee.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.mzuev.employee.model.Employee;
import ru.mzuev.employee.model.Region;
import ru.mzuev.employee.service.EmployeeService;
import org.springframework.stereotype.Controller;
import ru.mzuev.employee.service.HttpSession;
import ru.mzuev.employee.service.RegionService;

import java.util.List;
import java.util.stream.Collectors;

@Controller
public class EmployeeController {

    private EmployeeService employeeService;
    private RegionService regionService;
    private HttpSession httpSession;

    @Autowired
    public EmployeeController(EmployeeService employeeService, RegionService regionService, HttpSession httpSession) {
        this.employeeService = employeeService;
        this.regionService = regionService;
        this.httpSession = httpSession;
    }

    @GetMapping("/map/{id}")
    public String getMap(@PathVariable long id, Model model) {
        Employee employee = employeeService.getById(id);
        model.addAttribute("employee", employee);
        return "map";
    }


    @GetMapping("/")
    public String test(@RequestParam(defaultValue = "0") int page,
                       @RequestParam(defaultValue = "15") int size,
                       Model model) {

        List<Region> regionAll = regionService.findAll();

        List regionList = regionAll.stream()
                .filter(s -> s.getId() != httpSession.getRegion())
                .collect(Collectors.toList());

        String currentCityName = regionService.findById(httpSession.getRegion()).getCityName();

        Page <Employee> employeePage = employeeService.findAll(
                PageRequest.of(page, size, Sort.by("full_name").and(Sort.by("first_name").ascending())));

        model.addAttribute("page", employeePage);
        model.addAttribute("regionList", regionList);
        model.addAttribute("currentRegionId", httpSession.getRegion());
        model.addAttribute("currentCityName", currentCityName);
        model.addAttribute("url", "/");
        return "index";
    }


    @PostMapping("/search")
    public String search(@RequestParam String search,
                         @RequestParam(defaultValue = "0") int region,
                         @RequestParam(defaultValue = "0") int page,
                         @RequestParam(defaultValue = "15") int size,
                         Model model) {

        httpSession.setSearchQuery(search);
        httpSession.setRegion(region);

        List<Region> regionAll = regionService.findAll();

        List regionList = regionAll.stream()
                .filter(s -> s.getId() != httpSession.getRegion())
                .collect(Collectors.toList());


        String currentCityName = regionService.findById(httpSession.getRegion()).getCityName();

        Page <Employee> searchPage;

        if (region == 0) {
            searchPage = employeeService.findByName(search,
                    PageRequest.of(page, size, Sort.by("first_name").and(Sort.by("full_name"))));
        } else {
            searchPage = employeeService.findByNameAllRegions(search, region,
                    PageRequest.of(page, size, Sort.by("first_name").and(Sort.by("full_name"))));
        }

        model.addAttribute("page", searchPage);
        model.addAttribute("employeeSize", searchPage.getTotalElements());
        model.addAttribute("regionList", regionList);
        model.addAttribute("currentRegionId", httpSession.getRegion());
        model.addAttribute("currentCityName", currentCityName);
        model.addAttribute("url", "/search");
        return "search";
    }

    @GetMapping("/search")
    public String searchGet(@RequestParam(defaultValue = "0") int page,
                            @RequestParam(defaultValue = "15") int size,
                            Model model) {

        List<Region> regionAll = regionService.findAll();

        List regionList = regionAll.stream()
                .filter(s -> s.getId() != httpSession.getRegion())
                .collect(Collectors.toList());

        Page <Employee> searchPage;

        String currentCityName = regionService.findById(httpSession.getRegion()).getCityName();

        if (httpSession.getRegion() == 0) {
            searchPage = employeeService.findByName(httpSession.getSearchQuery(),
                    PageRequest.of(page, size, Sort.by("first_name").and(Sort.by("full_name"))));
        } else {
            searchPage = employeeService.findByNameAllRegions(httpSession.getSearchQuery(), httpSession.getRegion(),
                    PageRequest.of(page, size, Sort.by("first_name").and(Sort.by("full_name"))));
        }

        model.addAttribute("page", searchPage);
        model.addAttribute("employeeSize", searchPage.getTotalElements());
        model.addAttribute("regionList", regionList);
        model.addAttribute("currentRegionId", httpSession.getRegion());
        model.addAttribute("currentCityName", currentCityName);
        model.addAttribute("url", "/search");
        return "search";
    }
}
