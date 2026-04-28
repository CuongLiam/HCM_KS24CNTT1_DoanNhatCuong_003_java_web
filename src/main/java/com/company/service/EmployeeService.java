package com.company.service;

import com.company.model.Employee;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeeService {

    private final List<Employee> list = new ArrayList<>();
    private Long id = 1L;

    public List<Employee> findAll() {
        return list;
    }

    public void save(Employee e) {
        e.setId(id++);
        list.add(e);
    }

    public Employee findById(Long id) {
        return list.stream().filter(e -> e.getId().equals(id)).findFirst().orElse(null);
    }

    public void update(Employee e) {
        delete(e.getId());
        list.add(e);
    }

    public void delete(Long id) {
        list.removeIf(e -> e.getId().equals(id));
    }
}