package com.company.controller;

import com.company.model.Employee;
import com.company.service.EmployeeService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/employees")
public class EmployeeController {

    private final EmployeeService service;

    public EmployeeController(EmployeeService service) {
        this.service = service;
    }

//    @GetMapping
//    public String list(Model model) {
//        model.addAttribute("employees", service.findAll());
//        return "employee-list";
//    }

    @GetMapping("/create")
    public String createForm(Model model) {
        model.addAttribute("employee", new Employee());
        return "employee-form";
    }

    @PostMapping("/create")
    public String create(@ModelAttribute Employee e) {
        service.save(e);
        return "redirect:/employees";
    }

    @GetMapping("/edit/{id}")
    public String edit(@PathVariable Long id, Model model) {
        model.addAttribute("employee", service.findById(id));
        return "employee-form";
    }

    @PostMapping("/edit")
    public String update(@ModelAttribute Employee e) {
        service.update(e);
        return "redirect:/employees";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Long id) {
        service.delete(id);
        return "redirect:/employees";
    }

//    @GetMapping
//    public String list(
//            @RequestParam(defaultValue = "") String keyword,
//            @RequestParam(defaultValue = "0") int page,
//            Model model) {
//
//        int size = 5;
//
//        // search
//        var filtered = service.search(keyword);
//
//        // pagination
//        var employees = service.paginate(filtered, page, size);
//
//        int totalPages = (int) Math.ceil((double) filtered.size() / size);
//
//        model.addAttribute("employees", employees);
//        model.addAttribute("currentPage", page);
//        model.addAttribute("totalPages", totalPages);
//        model.addAttribute("keyword", keyword);
//
//        return "employee-list";
//    }

    @GetMapping
    public String list(
            @RequestParam(name = "keyword", defaultValue = "") String keyword,
            Model model) {

        var employees = service.search(keyword);

        model.addAttribute("employees", employees);
        model.addAttribute("keyword", keyword);

        return "employee-list";
    }
}